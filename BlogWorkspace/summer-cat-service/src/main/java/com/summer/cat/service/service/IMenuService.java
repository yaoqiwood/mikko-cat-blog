package com.summer.cat.service.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.summer.cat.entity.Menu;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liugh123
 * @since 2018-05-03
 */
public interface IMenuService extends IService<Menu> {

    /**
     * 根据 Ids 查询
     * @param permissionIds ids
     * @return  权限List
     */
    List<Menu> selectByIds(List<Integer> permissionIds);

    /**
     * 根据角色查询菜单
     * @param roleCode 角色主键
     * @return
     */
    List<Menu> findMenuByRoleCode(String roleCode);

    /**
     * 获取菜单树形结构
     * @param pId
     * @param list
     * @return
     */
    List<Menu> treeMenuList(String pId, List<Menu> list);

    /**
     * 获取菜单（根据父级Id）
     * @param parentId
     * @return
     */
    List<Menu> getAllMenu(String parentId);

}
