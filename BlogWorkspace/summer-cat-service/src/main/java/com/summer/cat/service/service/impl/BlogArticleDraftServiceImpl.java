package com.summer.cat.service.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.summer.cat.entity.BlogArticleDraft;
import com.summer.cat.mapper.BlogArticleDraftMapper;
import com.summer.cat.service.service.IBlogArticleDraftService;

/**
* <p>
	* 文章草稿表 服务实现类
	* </p>
*
* @author SummerCat
* @since 2020-04-21
*/
@Service
public class BlogArticleDraftServiceImpl extends ServiceImpl<BlogArticleDraftMapper, BlogArticleDraft>
        implements IBlogArticleDraftService {
    public QueryWrapper<BlogArticleDraft> buildWrapper(BlogArticleDraft var) {
        return null;
    }
}
