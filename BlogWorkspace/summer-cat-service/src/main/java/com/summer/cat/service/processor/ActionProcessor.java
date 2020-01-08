package com.summer.cat.service.processor;

import com.summer.cat.base.BusinessException;
import com.summer.cat.service.SpringContextBeanService;
import com.summer.cat.entity.Order;
import com.summer.cat.enums.OrderAction;
import com.summer.cat.enums.OrderType;
import com.summer.cat.model.OrderModel;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;

/**
 * @author summer
 * @since 2018-10-17
 */
public abstract class ActionProcessor {

    private static final String BEAN_NAME_SUFIX = "Processor";

    private static ActionProcessor getProcessor(OrderAction action, OrderType orderType) throws Exception{
        String beanName = action.name() + orderType.name() + BEAN_NAME_SUFIX;
        ActionProcessor processor = null;
        try{
            processor = SpringContextBeanService.getBean(beanName);
        }catch (NoSuchBeanDefinitionException e){
            throw new BusinessException("未找到对应的流程处理器:" + beanName);
        }
        return processor;
    }

    public static Order process(OrderAction action, OrderType orderType, OrderModel orderDef, Order currentOrder) throws Exception{
        return getProcessor(action,orderType).process(orderDef,currentOrder);
    }

    /**
     * 处理订单,不同的ActionProcessor实现类实现此方法
     * @param orderDef
     * @throws Exception
     */
    public  abstract Order process(OrderModel orderDef,Order currentOrder) throws Exception;


}
