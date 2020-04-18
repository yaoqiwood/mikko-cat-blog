package com.summer.cat.output.temp.service;

import com.summer.cat.output.temp.entity.SysDict;
import meme.cat.basic.service.BaseService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

/**
* <p>
	* 系统数据字典表 服务类
	* </p>
*
* @author SummerCat
* @since 2020-04-18
*/
public interface ISysDictService extends BaseService<SysDict> {
	QueryWrapper<SysDict> buildWrapper(SysDict var);
}
