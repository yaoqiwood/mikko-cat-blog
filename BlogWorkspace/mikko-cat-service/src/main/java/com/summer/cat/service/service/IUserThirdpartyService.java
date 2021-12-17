package com.summer.cat.service.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.summer.cat.entity.User;
import com.summer.cat.entity.UserThirdparty;
import com.summer.cat.model.ThirdPartyUser;

/**
 * <p>
 * 第三方用户表 服务类
 * </p>
 *
 * @author liugh123
 * @since 2018-07-27
 */
public interface IUserThirdpartyService extends IService<UserThirdparty> {

    User insertThirdPartyUser(ThirdPartyUser param, String password) throws Exception;

}
