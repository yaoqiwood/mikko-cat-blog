package com.summer.cat.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.summer.cat.entity.InfoToUser;
import com.summer.cat.mapper.InfoToUserMapper;
import com.summer.cat.service.IInfoToUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户电话关系表 服务实现类
 * </p>
 *
 * @author liugh123
 * @since 2018-10-29
 */
@Service
public class InfoToUserServiceImpl extends ServiceImpl<InfoToUserMapper, InfoToUser> implements IInfoToUserService {

}
