package com.summer.cat.service.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.summer.cat.entity.RoleToMenu;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liugh123
 * @since 2018-05-03
 */
public interface IRoleToMenuService extends IService<RoleToMenu> {

    /**
     * 根据角色ID查询
     * @param roleId    角色ID
     * @return  结果集
     */
    List<RoleToMenu> selectByRoleCode(String roleId);

    /**
     * 根据角色、权限集合录入数据
     * @param roleCode 角色ID
     * @param menuCodes 权限集合
     * @return 结果 true/false
     */
    boolean saveAll(String roleCode, List<String> menuCodes);

    boolean deleteAllByRoleCode(String roleCode);

}
