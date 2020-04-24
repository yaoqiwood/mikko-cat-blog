package com.summer.cat.output.temp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import meme.cat.basic.controller.BaseController;

import com.summer.cat.output.temp.entity.BlogArticleTag;
import com.summer.cat.output.temp.service.IBlogArticleTagService;


/**
* <p>
* 文章Tag表 前端控制器
* </p>
*
* @author SummerCat
* @since 2020-04-24
*/
@RestController
@RequestMapping("/temp/blog-article-tag")
public class BlogArticleTagController extends BaseController<BlogArticleTag, IBlogArticleTagService> {
	public BlogArticleTagController() {
		super(BlogArticleTag.class);
	}
}
