package com.summer.cat.service.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.summer.cat.entity.UserToRole;
import com.summer.cat.mapper.UserToRoleMapper;
import com.summer.cat.service.service.IUserToRoleService;
import com.summer.cat.util.ComUtil;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liugh123
 * @since 2018-05-03
 */
@Service
public class UserToRoleServiceImpl extends ServiceImpl<UserToRoleMapper, UserToRole> implements IUserToRoleService {

    @Override
    // @Cacheable(value = "UserToRole",keyGenerator="wiselyKeyGenerator")
    public UserToRole selectByUserNo(String userNo) {
        // EntityWrapper<UserToRole> ew = new EntityWrapper<>();
        QueryWrapper<UserToRole> ew = new QueryWrapper<>();
        // ew.where("user_no={0}", userNo);
        ew.eq("user_no", userNo);
        List<UserToRole> userToRoleList = this.list(ew);
        return ComUtil.isEmpty(userToRoleList) ? null : userToRoleList.get(0);
    }
}
