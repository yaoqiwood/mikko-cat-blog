package com.summer.cat.service.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.summer.cat.entity.BlogArticleTag;

import meme.cat.basic.service.BaseService;

/**
* <p>
	* 文章Tag表 服务类
	* </p>
*
* @author SummerCat
* @since 2020-04-23
*/
public interface IBlogArticleTagService extends BaseService<BlogArticleTag> {
    QueryWrapper<BlogArticleTag> buildWrapper(BlogArticleTag var);

}
