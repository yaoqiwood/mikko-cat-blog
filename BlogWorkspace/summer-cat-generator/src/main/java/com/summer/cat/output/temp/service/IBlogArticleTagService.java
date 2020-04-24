package com.summer.cat.output.temp.service;

import com.summer.cat.output.temp.entity.BlogArticleTag;
import meme.cat.basic.service.BaseService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

/**
* <p>
	* 文章Tag表 服务类
	* </p>
*
* @author SummerCat
* @since 2020-04-24
*/
public interface IBlogArticleTagService extends BaseService<BlogArticleTag> {
	QueryWrapper<BlogArticleTag> buildWrapper(BlogArticleTag var);
}
