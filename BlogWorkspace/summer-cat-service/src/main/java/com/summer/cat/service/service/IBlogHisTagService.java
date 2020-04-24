package com.summer.cat.service.service;

import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.summer.cat.entity.BlogHisTag;
import com.summer.cat.entity.BlogTag;
import com.summer.cat.vo.UserRoleVo;

import meme.cat.basic.service.BaseService;

/**
* <p>
	* 标签历史表 服务类
	* </p>
*
* @author SummerCat
* @since 2020-04-23
*/
public interface IBlogHisTagService extends BaseService<BlogHisTag> {
    QueryWrapper<BlogHisTag> buildWrapper(BlogHisTag var);

    /**
     * 新增历史标签
     * @param blogTagList
     * @param userRole
     */
    public void addTagHisList(List<BlogTag> blogTagList, UserRoleVo userRole);
}
