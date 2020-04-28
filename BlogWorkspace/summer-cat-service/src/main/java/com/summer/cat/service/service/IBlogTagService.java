package com.summer.cat.service.service;

import java.util.List;

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
    /**
     * 插入tag （如有重复名称则丢弃
     * @param blogTag
     * @return
     */
    public int insertTagByIgnoreIfExistTagName(BlogTag blogTag);

    /**
     * 查询文章id
     * @param id
     * @return
     */
    public List<BlogTag> selectTagsByArticleId(String id);
}
