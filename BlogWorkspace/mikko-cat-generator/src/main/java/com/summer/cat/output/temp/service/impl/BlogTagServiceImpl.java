package com.summer.cat.output.temp.service.impl;

import com.summer.cat.output.temp.entity.BlogTag;
import com.summer.cat.output.temp.dao.BlogTagMapper;
import com.summer.cat.output.temp.service.IBlogTagService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;

/**
* <p>
	* Tag表 服务实现类
	* </p>
*
* @author SummerCat
* @since 2020-04-28
*/
@Service
public class BlogTagServiceImpl extends ServiceImpl<BlogTagMapper, BlogTag> implements IBlogTagService {
	public QueryWrapper<BlogTag> buildWrapper(BlogTag var) {
		return null;
	}
}

