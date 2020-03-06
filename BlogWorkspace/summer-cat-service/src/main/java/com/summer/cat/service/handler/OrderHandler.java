package com.summer.cat.service.handler;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.summer.cat.base.BusinessException;
import com.summer.cat.entity.Order;
import com.summer.cat.enums.OrderAction;
import com.summer.cat.enums.OrderStatus;
import com.summer.cat.enums.OrderType;
import com.summer.cat.mapper.OrderMapper;
import com.summer.cat.model.OrderModel;
import com.summer.cat.service.SpringContextBeanService;
import com.summer.cat.util.ComUtil;

/**
 * @author summer
 * @since 2018-10-17
 */
public abstract class OrderHandler {

    public static OrderHandler getHandler(OrderType orderType) throws Exception {
        if (ComUtil.isEmpty(orderType)) {
            throw new BusinessException("订单类型未找到");
        }
        String beanName = orderType.name() + OrderHandler.class.getSimpleName();
        OrderHandler handler = null;
        try {
            handler = SpringContextBeanService.getBean(beanName);
        } catch (NoSuchBeanDefinitionException e) {
            throw new BusinessException("未找到对应的订单处理器:" + beanName);
        }
        return handler;
    }

    public static Order handle(OrderAction action, OrderType orderType, OrderModel orderDef) throws Exception {
        return getHandler(orderType).doHandle(action, orderType, orderDef);
    }

    @Autowired
    private OrderMapper orderMapper;

    public Order doHandle(OrderAction action, OrderType orderType, OrderModel orderModel) throws Exception {
        if (ComUtil.isEmpty(action) || ComUtil.isEmpty(orderType) || ComUtil.isEmpty(orderModel)
                || ComUtil.isEmpty(orderModel.getOrderNo())) {
            throw new BusinessException("数据验证失败");
        }
        Order order = new Order();
        order.setOrderNo(orderModel.getOrderNo());
        QueryWrapper<Order> wrapper = new QueryWrapper<>();
        wrapper.eq("order_no", orderModel.getOrderNo());
        Order currentOrder = orderMapper.selectOne(wrapper);
        if (ComUtil.isEmpty(currentOrder))
            throw new BusinessException("未查询到数据");
        OrderStatus nextStatus = orderType.getStatusHolder().getByAction(action);
        OrderStatus prevStatus = orderType.getStatusHolder().getByName(currentOrder.getOrderStatus());

        if (!prevStatus.canTransformTo(nextStatus))
            throw new BusinessException("订单不能由" + prevStatus.getName() + "转变为" + nextStatus.getName());
        orderModel.setOrderStatus(nextStatus.getName());
        return this.handleInternal(action, orderType, orderModel, currentOrder);
    }

    public abstract Order handleInternal(OrderAction action, OrderType orderType, OrderModel orderDef,
            Order currentOrder) throws Exception;

}
