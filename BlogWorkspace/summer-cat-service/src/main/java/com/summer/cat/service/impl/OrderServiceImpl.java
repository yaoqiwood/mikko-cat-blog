package com.summer.cat.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.summer.cat.entity.Order;
import com.summer.cat.enums.OrderAction;
import com.summer.cat.enums.OrderType;
import com.summer.cat.mapper.OrderMapper;
import com.summer.cat.model.OrderModel;
import com.summer.cat.service.IOrderService;
import com.summer.cat.service.handler.OrderHandler;

/**
 * <p>
 * 订单主表，当前表只保存流转中的订单信息 服务实现类
 * </p>
 *
 * @author summer
 * @since 2018-10-17
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

    @Override
    public Order handleOrder(OrderAction action, OrderType orderType, OrderModel orderDef) throws Exception {
        Order order = OrderHandler.handle(action, orderType, orderDef);
        return order;
    }

}
