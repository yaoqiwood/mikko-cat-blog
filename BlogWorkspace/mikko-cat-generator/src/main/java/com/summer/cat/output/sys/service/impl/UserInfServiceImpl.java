package com.summer.cat.output.sys.service.impl;

import com.summer.cat.output.sys.entity.UserInf;
import com.summer.cat.output.sys.dao.UserInfMapper;
import com.summer.cat.output.sys.service.IUserInfService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;

/**
* <p>
	* 用户信息表 服务实现类
	* </p>
*
* @author mikko
* @since 2021-12-22
*/
@Service
public class UserInfServiceImpl extends ServiceImpl<UserInfMapper, UserInf> implements IUserInfService {

	/**
	* 用于构造搜索接口的条件
	* @param var
	* @return
	*/
	@Override
	public QueryWrapper<UserInf> buildWrapper(UserInf var) {
		return null;
	}
}

