package com.summer.cat.output.temp.service.impl;

import com.summer.cat.output.temp.entity.BlogArticleTag;
import com.summer.cat.output.temp.dao.BlogArticleTagMapper;
import com.summer.cat.output.temp.service.IBlogArticleTagService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;

/**
* <p>
	* 文章Tag表 服务实现类
	* </p>
*
* @author SummerCat
* @since 2020-04-24
*/
@Service
public class BlogArticleTagServiceImpl extends ServiceImpl<BlogArticleTagMapper, BlogArticleTag> implements IBlogArticleTagService {
	public QueryWrapper<BlogArticleTag> buildWrapper(BlogArticleTag var) {
		return null;
	}
}

