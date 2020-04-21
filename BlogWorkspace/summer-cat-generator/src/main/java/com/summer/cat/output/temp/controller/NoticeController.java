package com.summer.cat.output.temp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import meme.cat.basic.controller.BaseController;

import com.summer.cat.output.temp.entity.Notice;
import com.summer.cat.output.temp.service.INoticeService;


/**
* <p>
* 消息通知表 前端控制器
* </p>
*
* @author SummerCat
* @since 2020-04-21
*/
@RestController
@RequestMapping("/temp/notice")
public class NoticeController extends BaseController<Notice, INoticeService> {
	public NoticeController() {
		super(Notice.class);
	}
}
