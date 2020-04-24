package com.summer.cat.controller.blog;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.summer.cat.entity.BlogHisTag;
import com.summer.cat.service.service.IBlogHisTagService;

import meme.cat.basic.controller.BaseController;

/**
* <p>
* 标签历史表 前端控制器
* </p>
*
* @author SummerCat
* @since 2020-04-23
*/
@RestController
@RequestMapping("/blog/blog-his-tag")
public class BlogHisTagController extends BaseController<BlogHisTag, IBlogHisTagService> {
    public BlogHisTagController() {
        super(BlogHisTag.class);
    }
}
