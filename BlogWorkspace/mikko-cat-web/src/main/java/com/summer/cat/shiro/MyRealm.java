package com.summer.cat.shiro;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.summer.cat.base.Constant;
import com.summer.cat.entity.Menu;
import com.summer.cat.entity.User;
import com.summer.cat.entity.UserToRole;
import com.summer.cat.exception.UnauthorizedException;
import com.summer.cat.service.service.*;
import com.summer.cat.util.ComUtil;
import com.summer.cat.util.GsonUtil;
import com.summer.cat.util.JWTUtil;

/**
 * @author summer
 * @since 2018-05-03
 */
public class MyRealm extends AuthorizingRealm {
    private IUserService userService;

    private IUserToRoleService userToRoleService;

    private IMenuService menuService;

    private IRoleService roleService;

    /**
     * 大坑！，必须重写此方法，不然Shiro会报错
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }

    /**
     * 只有当需要检测用户权限的时候才会调用此方法，例如checkRole,checkPermission之类的
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        if (userToRoleService == null) {
            this.userToRoleService = SpringContextBeanService.getBean(IUserToRoleService.class);
        }
        if (menuService == null) {
            this.menuService = SpringContextBeanService.getBean(IMenuService.class);
        }
        if (roleService == null) {
            this.roleService = SpringContextBeanService.getBean(IRoleService.class);
        }

        String userNo = JWTUtil.getUserNo(principals.toString());
        User user = userService.getById(userNo);
        UserToRole userToRole = userToRoleService.selectByUserNo(user.getUserNo());

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        /*
        Role role = roleService.selectOne(new EntityWrapper<Role>().eq("role_code", userToRole.getRoleCode()));
        //添加控制角色级别的权限
        Set<String> roleNameSet = new HashSet<>();
        roleNameSet.add(role.getRoleName());
        simpleAuthorizationInfo.addRoles(roleNameSet);
        */
        // 控制菜单级别按钮 类中用@RequiresPermissions("user:list") 对应数据库中code字段来控制controller
        ArrayList<String> pers = new ArrayList<>();
        List<Menu> menuList = menuService.findMenuByRoleCode(userToRole.getRoleCode());
        for (Menu per : menuList) {
            if (!ComUtil.isEmpty(per.getCode())) {
                pers.add(String.valueOf(per.getCode()));
            }
        }
        Set<String> permission = new HashSet<>(pers);
        simpleAuthorizationInfo.addStringPermissions(permission);
        return simpleAuthorizationInfo;
    }

    /**
     * 默认使用此方法进行用户名正确与否验证，错误抛出异常即可。
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken auth) throws UnauthorizedException {
        if (userService == null) {
            this.userService = SpringContextBeanService.getBean(IUserService.class);
        }
        String token = (String) auth.getCredentials();
        if (Constant.isPass) {
            return new SimpleAuthenticationInfo(token, token, this.getName());
        }
        // 解密获得username，用于和数据库进行对比
        String userNo = JWTUtil.getUserNo(token);
        String userStr = JWTUtil.getUserStr(token);
        User userBean = GsonUtil.gson2Bean(userStr, User.class);
        if (userNo == null) {
            throw new UnauthorizedException("token invalid");
        }
        // User userBean = userService.getById(userNo);
        if (userBean == null) {
            throw new UnauthorizedException("User didn't existed!");
        }
        if (!JWTUtil.verify(token, userNo, userBean.getPassword())) {
            throw new UnauthorizedException("Username or password error");
        }
        return new SimpleAuthenticationInfo(token, token, this.getName());
    }
}
