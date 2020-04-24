package com.summer.cat.service.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.summer.cat.entity.BlogArticleTag;
import com.summer.cat.mapper.BlogArticleTagMapper;
import com.summer.cat.service.service.IBlogArticleTagService;

/**
* <p>
	* 文章Tag表 服务实现类
	* </p>
*
* @author SummerCat
* @since 2020-04-23
*/
@Service
public class BlogArticleTagServiceImpl extends ServiceImpl<BlogArticleTagMapper, BlogArticleTag>
        implements IBlogArticleTagService {
    public QueryWrapper<BlogArticleTag> buildWrapper(BlogArticleTag var) {
        return null;
    }
}
