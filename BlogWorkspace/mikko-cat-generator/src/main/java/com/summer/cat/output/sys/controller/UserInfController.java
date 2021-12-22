package com.summer.cat.output.sys.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import meme.cat.basic.controller.BaseController;

import com.summer.cat.output.sys.entity.UserInf;
import com.summer.cat.output.sys.service.IUserInfService;


/**
* <p>
* 用户信息表 前端控制器
* </p>
*
* @author mikko
* @since 2021-12-22
*/
@RestController
@RequestMapping("/sys/user-inf")
public class UserInfController extends BaseController<UserInf, IUserInfService> {
	public UserInfController() {
		super(UserInf.class);
	}
}
