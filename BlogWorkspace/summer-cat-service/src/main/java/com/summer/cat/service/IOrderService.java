package com.summer.cat.service;

import com.summer.cat.entity.Order;
import com.baomidou.mybatisplus.service.IService;
import com.summer.cat.enums.OrderAction;
import com.summer.cat.enums.OrderType;
import com.summer.cat.model.OrderModel;

/**
 * <p>
 * 订单主表，当前表只保存流转中的订单信息 服务类
 * </p>
 *
 * @author liugh123
 * @since 2018-10-17
 */
public interface IOrderService extends IService<Order> {

    Order handleOrder(OrderAction action, OrderType orderType, OrderModel orderDef) throws Exception;

}
