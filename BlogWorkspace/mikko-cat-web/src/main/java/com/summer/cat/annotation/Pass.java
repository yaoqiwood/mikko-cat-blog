package com.summer.cat.annotation;


import java.lang.annotation.*;

/**
 * 在Controller方法上加入该注解不会验证身份
 * @author : summer
 * @date : 2018/05/08
 */
@Target( { ElementType.METHOD } )
@Retention( RetentionPolicy.RUNTIME )
@Documented
public @interface Pass {

}