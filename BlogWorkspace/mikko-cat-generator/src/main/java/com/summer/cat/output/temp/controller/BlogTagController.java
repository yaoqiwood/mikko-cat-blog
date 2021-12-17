package com.summer.cat.output.temp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import meme.cat.basic.controller.BaseController;

import com.summer.cat.output.temp.entity.BlogTag;
import com.summer.cat.output.temp.service.IBlogTagService;


/**
* <p>
* Tag表 前端控制器
* </p>
*
* @author SummerCat
* @since 2020-04-28
*/
@RestController
@RequestMapping("/temp/blog-tag")
public class BlogTagController extends BaseController<BlogTag, IBlogTagService> {
	public BlogTagController() {
		super(BlogTag.class);
	}
}
