package com.summer.cat.output.temp.service.impl;

import com.summer.cat.output.temp.entity.SysDict;
import com.summer.cat.output.temp.dao.SysDictMapper;
import com.summer.cat.output.temp.service.ISysDictService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;

/**
* <p>
	* 系统数据字典表 服务实现类
	* </p>
*
* @author SummerCat
* @since 2020-04-18
*/
@Service
public class SysDictServiceImpl extends ServiceImpl<SysDictMapper, SysDict> implements ISysDictService {
	public QueryWrapper<SysDict> buildWrapper(SysDict var) {
		return null;
	}
}

