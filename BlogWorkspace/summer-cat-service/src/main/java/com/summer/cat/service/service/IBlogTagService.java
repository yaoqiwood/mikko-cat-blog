package com.summer.cat.service.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.summer.cat.entity.BlogTag;

import meme.cat.basic.service.BaseService;

/**
* <p>
	* Tag表 服务类
	* </p>
*
* @author SummerCat
* @since 2020-04-23
*/
public interface IBlogTagService extends BaseService<BlogTag> {
    QueryWrapper<BlogTag> buildWrapper(BlogTag var);

    /**
     * 插入tag （如有重复名称则丢弃
     * @param blogTag
     * @return
     */
    public int insertTagByIgnoreIfExistTagName(BlogTag blogTag);
}
