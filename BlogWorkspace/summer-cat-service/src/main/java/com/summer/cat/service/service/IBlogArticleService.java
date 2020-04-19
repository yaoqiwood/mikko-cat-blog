package com.summer.cat.service.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.summer.cat.entity.BlogArticle;

import meme.cat.basic.service.BaseService;

/**
* <p>
	* 文章表 服务类
	* </p>
*
* @author SummerCat
* @since 2020-04-17
*/
public interface IBlogArticleService extends BaseService<BlogArticle> {
    QueryWrapper<BlogArticle> buildWrapper(BlogArticle var);
}
