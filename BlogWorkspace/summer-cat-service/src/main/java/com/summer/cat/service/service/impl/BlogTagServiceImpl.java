package com.summer.cat.service.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.summer.cat.entity.BlogTag;
import com.summer.cat.mapper.BlogTagMapper;
import com.summer.cat.service.service.IBlogTagService;

/**
* <p>
	* Tag表 服务实现类
	* </p>
*
* @author SummerCat
* @since 2020-04-23
*/
@Service
public class BlogTagServiceImpl extends ServiceImpl<BlogTagMapper, BlogTag> implements IBlogTagService {
    public QueryWrapper<BlogTag> buildWrapper(BlogTag var) {
        return null;
    }
}
