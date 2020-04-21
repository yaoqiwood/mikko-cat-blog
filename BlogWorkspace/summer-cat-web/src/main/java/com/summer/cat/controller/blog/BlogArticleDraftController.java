package com.summer.cat.controller.blog;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.summer.cat.entity.BlogArticleDraft;
import com.summer.cat.service.service.IBlogArticleDraftService;

import meme.cat.basic.controller.BaseController;

/**
* <p>
* 文章草稿表 前端控制器
* </p>
*
* @author SummerCat
* @since 2020-04-21
*/
@RestController
@RequestMapping("/blog/blog-article-draft")
public class BlogArticleDraftController extends BaseController<BlogArticleDraft, IBlogArticleDraftService> {
    public BlogArticleDraftController() {
        super(BlogArticleDraft.class);
    }
}
