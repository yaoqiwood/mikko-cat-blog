package com.summer.cat.output.temp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import meme.cat.basic.controller.BaseController;

import com.summer.cat.output.temp.entity.SysDict;
import com.summer.cat.output.temp.service.ISysDictService;


/**
* <p>
* 系统数据字典表 前端控制器
* </p>
*
* @author SummerCat
* @since 2020-04-18
*/
@RestController
@RequestMapping("/temp/sys-dict")
public class SysDictController extends BaseController<SysDict, ISysDictService> {
	public SysDictController() {
		super(SysDict.class);
	}
}
