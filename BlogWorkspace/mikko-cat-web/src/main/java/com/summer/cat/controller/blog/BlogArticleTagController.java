package com.summer.cat.controller.blog;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.summer.cat.entity.BlogArticleTag;
import com.summer.cat.service.service.IBlogArticleTagService;

import meme.cat.basic.controller.BaseController;

/**
* <p>
* 文章Tag表 前端控制器
* </p>
*
* @author SummerCat
* @since 2020-04-23
*/
@RestController
@RequestMapping("/blog/blog-article-tag")
public class BlogArticleTagController extends BaseController<BlogArticleTag, IBlogArticleTagService> {
    public BlogArticleTagController() {
        super(BlogArticleTag.class);
    }
}
