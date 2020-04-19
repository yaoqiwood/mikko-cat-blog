package com.summer.cat.service.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.summer.cat.entity.BlogArticle;
import com.summer.cat.mapper.BlogArticleMapper;
import com.summer.cat.service.service.IBlogArticleService;

/**
* <p>
	* 文章表 服务实现类
	* </p>
*
* @author SummerCat
* @since 2020-04-17
*/
@Service
public class BlogArticleServiceImpl extends ServiceImpl<BlogArticleMapper, BlogArticle> implements IBlogArticleService {
    @Override
    public QueryWrapper<BlogArticle> buildWrapper(BlogArticle var) {
        return null;
    }
}
