package com.summer.cat.service.service;

import java.io.IOException;

import com.summer.cat.dto.UserInfWithImgDto;
import com.summer.cat.dto.UserInfoProfileDto;
import com.summer.cat.entity.UserInf;

import meme.cat.basic.service.BaseService;

/**
 * <p>
 * 用户信息表 服务类
 * </p>
 *
 * @author mikko
 * @since 2021-12-20
 */
public interface IUserInfService extends BaseService<UserInf> {

    /**
     * findProfileByUserNo
     *
     * @param userNo
     * @return
     */
    UserInfoProfileDto findProfileByUserNo(String userNo);

    /**
     * selectAdminNoByUserRole
     * @param roleName
     * @return
     */
    String selectAdminNoByUserRole();

    /**
     * loadUserInfWithImg
     * @return
     */
    UserInfWithImgDto loadUserInfWithImg(String systemUploadDir) throws IOException;
}
