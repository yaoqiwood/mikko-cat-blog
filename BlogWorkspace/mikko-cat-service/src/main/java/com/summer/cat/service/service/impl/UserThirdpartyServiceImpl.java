package com.summer.cat.service.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.summer.cat.base.Constant;
import com.summer.cat.entity.User;
import com.summer.cat.entity.UserThirdparty;
import com.summer.cat.mapper.UserThirdpartyMapper;
import com.summer.cat.model.ThirdPartyUser;
import com.summer.cat.service.service.IUserService;
import com.summer.cat.service.service.IUserThirdpartyService;

/**
 * <p>
 * 第三方用户表 服务实现类
 * </p>
 *
 * @author liugh123
 * @since 2018-07-27
 */
@Service
public class UserThirdpartyServiceImpl extends ServiceImpl<UserThirdpartyMapper, UserThirdparty>
        implements IUserThirdpartyService {

    @Autowired
    private IUserService userService;

    @Override
    public User insertThirdPartyUser(ThirdPartyUser param, String password) throws Exception {
        User sysUser = User.builder().password(password).username("游客" + param.getOpenid()).mobile(param.getOpenid())
                .avatar(param.getAvatarUrl()).build();
        User register = userService.register(sysUser, Constant.RoleType.USER);
        // 初始化第三方信息
        UserThirdparty thirdparty = UserThirdparty.builder().providerType(param.getProvider()).openId(param.getOpenid())
                .createTime(new Date()).userNo(register.getUserNo()).status(Constant.ENABLE)
                .accessToken(param.getToken()).build();
        this.save(thirdparty);
        return register;
    }
}
