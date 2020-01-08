package com.summer.cat.mapper;

import com.summer.cat.entity.Order;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 订单主表，当前表只保存流转中的订单信息 Mapper 接口
 * </p>
 *
 * @author liugh123
 * @since 2018-10-17
 */
public interface OrderMapper extends BaseMapper<Order> {

}
