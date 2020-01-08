package com.summer.cat.service.handler;

import com.summer.cat.service.processor.ActionProcessor;
import com.summer.cat.entity.Order;
import com.summer.cat.enums.OrderAction;
import com.summer.cat.enums.OrderType;
import com.summer.cat.model.OrderModel;
import org.springframework.stereotype.Component;

/**
 * @author summer
 * @since 2018-10-17
 */
@Component("ProductOrderHandler")
public class ProductOrderHandler extends OrderHandler {

	@Override
	public Order handleInternal(OrderAction action, OrderType orderType, OrderModel orderDef, Order currentOrder) throws Exception {
		return  ActionProcessor.process(action,orderType,orderDef,currentOrder);
	}
}
