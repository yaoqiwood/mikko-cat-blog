package com.summer.cat.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.summer.cat.entity.RoleToMenu;
import com.summer.cat.mapper.RoleToMenuMapper;
import com.summer.cat.service.IRoleToMenuService;
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
public class RoleToMenuServiceImpl extends ServiceImpl<RoleToMenuMapper, RoleToMenu> implements IRoleToMenuService {

    @Override
    // redis生成key注解，以类名方法名和参数组成key
    // @Cacheable(value = "UserToRole",keyGenerator="wiselyKeyGenerator")
    public List<RoleToMenu> selectByRoleCode(String roleCode) {
        QueryWrapper<RoleToMenu> ew = new QueryWrapper<>();
        // ew.where("role_code={0}", roleCode);
        ew.eq("role_code", "{0}");
        return this.list(ew);
    }

    @Override
    public boolean saveAll(String roleCode, List<String> menuCodes) {
        boolean result = true;
        if (!ComUtil.isEmpty(menuCodes)) {
            List<RoleToMenu> modelList = new ArrayList<>();
            for (String menuCode : menuCodes) {
                modelList.add(RoleToMenu.builder().roleCode(roleCode).menuCode(menuCode).build());
            }
            result = this.saveBatch(modelList);
        }
        return result;
    }

    @Override
    public boolean deleteAllByRoleCode(String roleCode) {
        QueryWrapper<RoleToMenu> ew = new QueryWrapper<>();
        // 框架老旧 {0} 代表第一位占位符的意思
        // ew.where("role_code={0}", roleCode);
        ew.eq("role_code", roleCode);
        return this.remove(ew);
    }
}
