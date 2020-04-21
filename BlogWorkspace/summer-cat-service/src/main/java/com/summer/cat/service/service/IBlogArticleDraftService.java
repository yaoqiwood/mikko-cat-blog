package com.summer.cat.service.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.summer.cat.entity.BlogArticleDraft;

import meme.cat.basic.service.BaseService;

/**
* <p>
	* 文章草稿表 服务类
	* </p>
*
* @author SummerCat
* @since 2020-04-21
*/
public interface IBlogArticleDraftService extends BaseService<BlogArticleDraft> {
    QueryWrapper<BlogArticleDraft> buildWrapper(BlogArticleDraft var);
}
