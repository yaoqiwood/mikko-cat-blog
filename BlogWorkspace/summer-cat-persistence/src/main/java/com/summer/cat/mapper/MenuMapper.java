package com.summer.cat.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.summer.cat.entity.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author summerCat
 * @since 2018-05-03
 */
public interface MenuMapper extends BaseMapper<Menu> {

    List<Menu> findMenuByRoleCode(@Param("roleCode") String roleCode);

    /**
     * 获取所有menuItem （根据parentId)
     * @param parentId
     * @return
     */
    List<Menu> getAllMenu(@Param("parentId") String parentId);
}
