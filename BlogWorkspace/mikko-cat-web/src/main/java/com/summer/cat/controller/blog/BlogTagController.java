package com.summer.cat.controller.blog;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.summer.cat.entity.BlogTag;
import com.summer.cat.service.service.IBlogTagService;

import meme.cat.basic.controller.BaseController;

/**
* <p>
* Tag表 前端控制器
* </p>
*
* @author SummerCat
* @since 2020-04-23
*/
@RestController
@RequestMapping("/blog/blog-tag")
public class BlogTagController extends BaseController<BlogTag, IBlogTagService> {
    public BlogTagController() {
        super(BlogTag.class);
    }

}
