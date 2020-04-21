package com.summer.cat.controller.blog;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.summer.cat.entity.BlogArticle;
import com.summer.cat.service.service.IBlogArticleService;

import meme.cat.basic.controller.BaseController;

/**
* <p>
 * 文章表 前端控制器
 * </p>
*
* @author SummerCat
* @since 2020-04-17
*/
@RestController
@RequestMapping("/blog/blog-article")
public class BlogArticleController extends BaseController<BlogArticle, IBlogArticleService> {
    public BlogArticleController() {
        super(BlogArticle.class);
    }

}
