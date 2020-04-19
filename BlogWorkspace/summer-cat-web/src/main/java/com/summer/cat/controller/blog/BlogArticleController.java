package com.summer.cat.controller.blog;

import meme.cat.basic.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.summer.cat.entity.BlogArticle;
import com.summer.cat.service.service.IBlogArticleService;

/**
* <p>
 * 文章表 前端控制器
 * </p>
*
* @author SummerCat
* @since 2020-04-17
*/
@RestController
@RequestMapping("/blogManager/blog-article")
public class BlogArticleController extends BaseController<BlogArticle, IBlogArticleService> {

    public BlogArticleController() {
        super(BlogArticle.class);
    }

    public void trya() {
        BlogArticle blogArticle = new BlogArticle();
    }

}
