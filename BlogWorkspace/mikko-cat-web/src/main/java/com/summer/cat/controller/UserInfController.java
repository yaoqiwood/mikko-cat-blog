package com.summer.cat.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.summer.cat.annotation.Pass;
import com.summer.cat.dto.UserInfWithImgDto;
import com.summer.cat.entity.UserInf;
import com.summer.cat.service.service.IUserInfService;
import com.summer.cat.service.system.SystemConfig;
import com.summer.cat.util.Returns;

import lombok.extern.slf4j.Slf4j;
import meme.cat.basic.controller.BaseController;

/**
 * <p>
 * 用户信息表 前端控制器
 * </p>
 *
 * @author mikko
 * @since 2021-12-20
 */
@RestController
@RequestMapping("/user-inf")
@Slf4j
public class UserInfController extends BaseController<UserInf, IUserInfService> {
    public UserInfController() {
        super(UserInf.class);
    }

    /**
     * 查询主页信息框信息与图片背景
     * @param request
     * @return
     */
    @GetMapping("loadUserInfWithImg")
    @Pass
    @ResponseBody
    public Map<String, ?> loadUserInfWithImg(HttpServletRequest request) {
        try {
            UserInfWithImgDto userInfWithImgDto = this.service.loadUserInfWithImg(SystemConfig.systemUploadDir);
            return Returns.mapOk(userInfWithImgDto, "查询成功");
        } catch (IOException e) {
            log.error("查询失败", e);
            return Returns.mapError("查询失败:" + e.getMessage());
        }
    }

}
