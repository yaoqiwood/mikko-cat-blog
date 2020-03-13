package com.summer.cat.controller;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.alibaba.fastjson.JSONObject;
import com.summer.cat.annotation.*;
import com.summer.cat.base.Constant;
import com.summer.cat.config.ResponseHelper;
import com.summer.cat.config.ResponseModel;
import com.summer.cat.entity.User;
import com.summer.cat.service.service.IUserService;
import com.summer.cat.util.BufferCloseUtil;
import com.summer.cat.util.ComUtil;
import com.summer.cat.util.Returns;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.ShearCaptcha;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import springfox.documentation.annotations.ApiIgnore;

/**
 *  登录接口
 * @author summer
 * @since 2018-05-03
 */
@RestController
@Slf4j
@Api(description = "身份认证模块")
public class LoginController {
    @Autowired
    private IUserService userService;

    @PostMapping("/login.action")
    @Pass
    // 5秒产生一个令牌,放入容量为0.3的令牌桶
    @AccessLimit(perSecond = 0.3, timeOut = 5000)
    public Map<String, ? extends Object> login(
            @ValidationParam("account,password,verificationCode") @RequestBody JSONObject requestJson,
            HttpSession session) {
        try {
            String verificationCode = (String) session.getAttribute(Constant.VERIFICATION_CODE);
            Map<String, Object> userMap = userService.checkMobileAndPasswd(requestJson, verificationCode);
            return Returns.mapOk(userMap, "登录成功");
        } catch (Exception e) {
            log.error("登录失败", e);
            return Returns.mapError("登录失败：" + e.getMessage());
        }

    }

    @ApiIgnore
    @Log(action = "register", modelName = "User", description = "添加用户")
    @PostMapping("/admin/register")
    // 添加用户的按钮权限
    @RequiresPermissions("user:add")
    public ResponseModel register(@ValidationParam("username,roleName") @RequestBody JSONObject requestJson,
            @CurrentUser User user) throws Exception {
        requestJson.put("createUser", user.getUserNo());
        return ResponseHelper.buildResponseModel(userService.insertUserByAdmin(requestJson));
    }

    @ApiOperation(value = "短信验证码登录", notes = "body体参数,不需要Authorization", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "requestJson", value = "{\"mobile\":\"13888888888\",\"captcha\":\"5780\"}", required = true, dataType = "String", paramType = "body") })
    @PostMapping("/login/captcha")
    @Log(action = "SignInByCaptcha", modelName = "Login", description = "前台短信验证码登录接口")
    @Pass
    public ResponseModel<Map<String, Object>> loginBycaptcha(
            @ValidationParam("mobile,captcha") @RequestBody JSONObject requestJson) throws Exception {
        return ResponseHelper.buildResponseModel(userService.checkMobileAndCatcha(requestJson));
    }

    @ApiOperation(value = "手机验证码注册", notes = "body体参数,不需要Authorization", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "requestJson", value = "{\"username\":\"summer\",\"mobile\":\"13888888888\",</br>"
                    + "\"captcha\":\"5780\",\"password\":\"123456\",</br>\"rePassword\":\"123456\",\"job\":\"java开发\","
                    + "</br>\"unit(可不传)\":\"xxx公司\"}", required = true, dataType = "String", paramType = "body") })
    @PostMapping("/register")
    @Log(action = "register", modelName = "Login", description = "注册接口")
    @Pass
    public ResponseModel<User> register(
            @ValidationParam("username,password,rePassword,mobile,captcha,job") @RequestBody JSONObject requestJson)
            throws Exception {
        return ResponseHelper.buildResponseModel(userService.checkAndRegisterUser(requestJson));
    }

    @ApiOperation(value = "忘记密码", notes = "body体参数,不需要Authorization", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "requestJson", value = "{\"mobile\":\"17765071662\",\"captcha\":\"5780\",</br>"
                    + "\"password\":\"123456\",\"rePassword\":\"123456\"}", required = true, dataType = "String", paramType = "body") })
    @PostMapping("/forget/password")
    @Pass
    public ResponseModel<User> resetPassWord(
            @ValidationParam("mobile,captcha,password,rePassword") @RequestBody JSONObject requestJson)
            throws Exception {
        return ResponseHelper.buildResponseModel(userService.updateForgetPasswd(requestJson));
    }

    /**
     * 检查用户是否注册过
     * @param mobile
     * @return
     * @throws Exception
     */
    @GetMapping("/check/mobile")
    @Pass
    @ApiIgnore
    public ResponseModel loginBycaptcha(@RequestParam("mobile") String mobile) throws Exception {
        User user = userService.getUserByMobile(mobile);
        return ResponseHelper.buildResponseModel(!ComUtil.isEmpty(user));
    }

    /**
     * 验证码
     * @param session
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = { "/verificationCode.action" })
    @Pass
    public void verificationCode(HttpSession session, HttpServletResponse response) throws IOException {
        ShearCaptcha captcha = CaptchaUtil.createShearCaptcha(220, 100, 4, 4);
        BufferedOutputStream bos = null;
        try {
            session.removeAttribute(Constant.VERIFICATION_CODE);
            bos = new BufferedOutputStream(response.getOutputStream());
            session.setAttribute(Constant.VERIFICATION_CODE, captcha.getCode().toLowerCase());
            log.info(session.getAttribute(Constant.VERIFICATION_CODE) + "");
            captcha.write(bos);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            BufferCloseUtil.closeBufferOutput(bos);
        }
    }
}
