package com.summer.cat.controller;

import java.io.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.base.Charsets;
import com.google.common.base.Strings;
import com.summer.cat.annotation.AccessLimit;
import com.summer.cat.annotation.CurrentUser;
import com.summer.cat.annotation.Pass;
import com.summer.cat.annotation.ValidationParam;
import com.summer.cat.base.Constant;
import com.summer.cat.base.PublicResultConstant;
import com.summer.cat.config.ResponseHelper;
import com.summer.cat.config.ResponseModel;
import com.summer.cat.dto.UserInfoProfileDto;
import com.summer.cat.entity.User;
import com.summer.cat.service.service.IUserInfService;
import com.summer.cat.service.service.IUserService;
import com.summer.cat.service.system.SystemConfig;
import com.summer.cat.shiro.JWTToken;
import com.summer.cat.util.*;

import cn.hutool.core.io.FileUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author summer
 * @since 2018-05-03
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    private IUserService userService;

    private IUserInfService userInfService;

    @Autowired
    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setUserInfService(IUserInfService userInfService) {
        this.userInfService = userInfService;
    }

    /**
     * 获取当前登录用户信息
     *
     * @param user
     * @return
     * @throws Exception
     */
    @GetMapping("/currentUser")
    public ResponseModel<User> getUser(@CurrentUser User user) throws Exception {
        return ResponseHelper.buildResponseModel(user);
    }

    @PostMapping("/mobile")
    public ResponseModel<String> resetMobile(@CurrentUser User currentUser,
            @ValidationParam("newMobile,captcha") @RequestBody JSONObject requestJson) throws Exception {
        userService.resetMobile(currentUser, requestJson);
        return ResponseHelper.buildResponseModel(PublicResultConstant.SUCCEED);
    }

    @PostMapping("/password")
    public ResponseModel<String> resetPassWord(@CurrentUser User currentUser,
            @ValidationParam("oldPassword,password,rePassword") @RequestBody JSONObject requestJson) throws Exception {
        userService.resetPassWord(currentUser, requestJson);
        return ResponseHelper.buildResponseModel(PublicResultConstant.SUCCEED);
    }

    /**
     * 管理端修改密码
     *
     * @return
     * @throws Exception
     */
    @PostMapping("/admin/password")
    public ResponseModel<String> resetPassWord(
            @ValidationParam("userNo,password,rePassword") @RequestBody JSONObject requestJson) throws Exception {
        // userService.resetPassWord(userService.selectById(requestJson.getString("userNo")),
        // requestJson);
        userService.resetPassWord(userService.getById(requestJson.getString("userNo")), requestJson);
        return ResponseHelper.buildResponseModel(PublicResultConstant.SUCCEED);
    }

    @PostMapping("/info")
    public ResponseModel<User> resetUserInfo(@CurrentUser User currentUser, @RequestBody JSONObject requestJson)
            throws Exception {
        if (!ComUtil.isEmpty(requestJson.getString("username"))) {
            currentUser.setUsername(requestJson.getString("username"));
        }
        if (!ComUtil.isEmpty(requestJson.getString("avatar"))) {
            currentUser.setAvatar(requestJson.getString("avatar"));
        }
        if (!ComUtil.isEmpty(requestJson.getString("email"))) {
            currentUser.setEmail(requestJson.getString("email"));
        }
        if (!ComUtil.isEmpty(requestJson.getString("job"))) {
            currentUser.setJob(requestJson.getString("job"));
        }
        userService.updateById(currentUser);
        return ResponseHelper.buildResponseModel(currentUser);
    }

    @GetMapping(value = "/pageList")
    @RequiresPermissions(value = { "user:list" })
    // 拥有超级管理员或管理员角色的用户可以访问这个接口,换成角色控制权限,改变请看MyRealm.class
    // @RequiresRoles(value =
    // {Constant.RoleType.SYS_ASMIN_ROLE,Constant.RoleType.ADMIN},logical =
    // Logical.OR)
    @AccessLimit(perSecond = 1, timeOut = 500) // 5秒钟生成一个令牌
    public ResponseModel<Page<User>> findList(
            @RequestParam(name = "pageIndex", defaultValue = "1", required = false) Integer pageIndex,
            @RequestParam(name = "pageSize", defaultValue = "10", required = false) Integer pageSize,
            @RequestParam(value = "username", defaultValue = "", required = false) String username) {
        return ResponseHelper.buildResponseModel(
                userService.page(new Page<>(pageIndex, pageSize), ComUtil.isEmpty(username) ? new QueryWrapper<User>()
                        : new QueryWrapper<User>().eq("user_name", username)));
    }

    @GetMapping("/admin/infoList")
    @ApiOperation(value = "获取用户列表", notes = "需要header里加入Authorization")
    @ApiImplicitParams({ @ApiImplicitParam(name = "pageIndex", value = "第几页", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页多少条", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "info", value = "会员名称或者电话", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "startTime", value = "开始时间", dataType = "Long", paramType = "query"),
            @ApiImplicitParam(name = "endTime", value = "结束时间", dataType = "Long", paramType = "query") })
    public ResponseModel findInfoList(
            @RequestParam(name = "pageIndex", defaultValue = "1", required = false) Integer pageIndex,
            @RequestParam(name = "pageSize", defaultValue = "10", required = false) Integer pageSize,
            // info-->用户名或者电话号码
            @RequestParam(name = "info", defaultValue = "", required = false) String info,
            @RequestParam(name = "startTime", defaultValue = "", required = false) String startTime,
            @RequestParam(name = "endTime", defaultValue = "", required = false) String endTime) throws Exception {
        // 启用或禁用的用户
        Integer[] status = { 1, 2 };
        // 自定义分页关联查询列表
        Page<User> userPage = userService.selectPageByConditionUser(new Page<User>(pageIndex, pageSize), info, status,
                startTime, endTime);
        return ResponseHelper.buildResponseModel(userPage);
    }

    @ApiOperation(value = "获取用户详细信息", notes = "根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "userNo", value = "用户ID", required = true, dataType = "String", paramType = "path")
    @GetMapping(value = "/{userNo}")
    // 暂时换成了角色控制权限,改变请看MyRealm.class
    @RequiresPermissions(value = { "user:list" })
    // 拥有超级管理员或管理员角色的用户可以访问这个接口,换成角色控制权限,改变请看MyRealm.class
    // @RequiresRoles(value =
    // {Constant.RoleType.SYS_ASMIN_ROLE,Constant.RoleType.ADMIN},logical =
    // Logical.OR)
    public ResponseModel<User> findOneUser(@PathVariable("userNo") String userNo) {
        User user = userService.getById(userNo);
        return ResponseHelper.buildResponseModel(user);
    }

    @ApiOperation(value = "删除用户", notes = "根据url的id来删除用户")
    @ApiImplicitParam(name = "userNo", value = "用户ID", required = true, dataType = "String", paramType = "path")
    @DeleteMapping(value = "/{userNo}")
    @RequiresPermissions(value = { "user:delete" })
    public ResponseModel deleteUser(@PathVariable("userNo") String userNo) throws Exception {
        userService.deleteByUserNo(userNo);
        return ResponseHelper.buildResponseModel(PublicResultConstant.SUCCEED);
    }

    /**
     * 读取当前用户头像
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("reviewUserProfile")
    void reviewUserProfile(HttpServletRequest request, HttpServletResponse response) throws IOException {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        String authorization = request.getHeader(Constant.AUTHORIZATION);
        JWTToken token = new JWTToken(authorization);
        String userNo = JWTUtil.getUserNo(token.getPrincipal().toString());
        // 查找用户头像信息
        UserInfoProfileDto userInfoProfileDto = this.userInfService.findProfileByUserNo(userNo);
        if (null == userInfoProfileDto || Strings.isNullOrEmpty(userInfoProfileDto.getSaciStoragePath())) {
            throw new CatsException("获取头像失败");
        }
        // 拼接图片路径
        String profilePath = SystemConfig.systemUploadDir + userInfoProfileDto.getSaciStoragePath()
                + userInfoProfileDto.getSaciNewAnnexName();
        if (!FileUtil.exist(profilePath)) {
            String errorInf = "文件不存在，获取头像失败";
            log.error(errorInf);
            throw new CatsException(errorInf);
        }
        File file = new File(profilePath);
        long fileLong = file.length();
        response.setHeader(HttpUtil.HEADER_CONTENT_DISPOSITION, HttpUtil.ATTACHMENT_FILENAME + new String(
                userInfoProfileDto.getSaciNewAnnexName().getBytes(Charsets.UTF_8.name()), Charsets.ISO_8859_1.name()));
        response.setHeader(HttpUtil.HEADER_CONTENT_LENGTH, String.valueOf(fileLong));
        try {
            bis = new BufferedInputStream(new FileInputStream(profilePath));
            bos = new BufferedOutputStream(response.getOutputStream());
            byte[] buff = new byte[2048];
            int byteRead;
            while (-1 != (byteRead = bis.read(buff, 0, buff.length))) {
                bos.write(buff, 0, byteRead);
            }
        } finally {
            BufferCloseUtil.closeBufferInput(bis);
            BufferCloseUtil.closeBufferOutput(bos);
        }

    }

    /**
     * 读取用户头像
     * @param request
     * @param response
     * @throws IOException
     */
    @Pass
    @GetMapping("reviewProfile")
    public void reviewProfile(HttpServletRequest request, HttpServletResponse response) throws IOException {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        String userNo = this.userInfService.selectAdminNoByUserRole();
        // 查找用户头像信息
        UserInfoProfileDto userInfoProfileDto = this.userInfService.findProfileByUserNo(userNo);
        if (null == userInfoProfileDto || Strings.isNullOrEmpty(userInfoProfileDto.getSaciStoragePath())) {
            throw new CatsException("获取头像失败");
        }
        // 拼接图片路径
        String profilePath = SystemConfig.systemUploadDir + userInfoProfileDto.getSaciStoragePath()
                + userInfoProfileDto.getSaciNewAnnexName();
        if (!FileUtil.exist(profilePath)) {
            String errorInf = "文件不存在，获取头像失败";
            log.error(errorInf);
            throw new CatsException(errorInf);
        }
        File file = new File(profilePath);
        long fileLong = file.length();
        response.setHeader(HttpUtil.HEADER_CONTENT_DISPOSITION, HttpUtil.ATTACHMENT_FILENAME + new String(
                userInfoProfileDto.getSaciNewAnnexName().getBytes(Charsets.UTF_8.name()), Charsets.ISO_8859_1.name()));
        response.setHeader(HttpUtil.HEADER_CONTENT_LENGTH, String.valueOf(fileLong));
        try {
            bis = new BufferedInputStream(new FileInputStream(profilePath));
            bos = new BufferedOutputStream(response.getOutputStream());
            byte[] buff = new byte[2048];
            int byteRead;
            while (-1 != (byteRead = bis.read(buff, 0, buff.length))) {
                bos.write(buff, 0, byteRead);
            }
        } finally {
            BufferCloseUtil.closeBufferInput(bis);
            BufferCloseUtil.closeBufferOutput(bos);
        }

    }
}
