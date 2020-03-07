package com.summer.cat.test.service.impl;

import com.summer.cat.test.entity.InfoToUser;
import com.summer.cat.test.dao.InfoToUserMapper;
import com.summer.cat.test.service.IInfoToUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户账号关系表 服务实现类
 * </p>
 *
 * @author SummerCat
 * @since 2020-03-06
 */
@Service
public class InfoToUserServiceImpl extends ServiceImpl<InfoToUserMapper, InfoToUser> implements IInfoToUserService {

}
