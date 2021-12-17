package com.summer.cat.output.temp.service;

import com.summer.cat.output.temp.entity.BlogTag;
import meme.cat.basic.service.BaseService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

/**
* <p>
	* Tag表 服务类
	* </p>
*
* @author SummerCat
* @since 2020-04-28
*/
public interface IBlogTagService extends BaseService<BlogTag> {
	QueryWrapper<BlogTag> buildWrapper(BlogTag var);
}
