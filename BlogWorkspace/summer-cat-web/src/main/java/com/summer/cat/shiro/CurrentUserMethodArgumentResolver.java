package com.summer.cat.shiro;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.summer.cat.annotation.CurrentUser;
import com.summer.cat.base.Constant;
import com.summer.cat.entity.User;
import com.summer.cat.exception.UnauthorizedException;

/**
 *  增加方法注入，将含有 @CurrentUser 注解的方法参数注入当前登录用户
 * @author summer
 * @since 2018-05-03
 */
public class CurrentUserMethodArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().isAssignableFrom(User.class)
                && parameter.hasParameterAnnotation(CurrentUser.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
            NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        User user = (User) webRequest.getAttribute(Constant.CURRENT_USER_REQUEST_NAME, RequestAttributes.SCOPE_REQUEST);
        if (user == null) {
            throw new UnauthorizedException("获取用户信息失败");
        }
        return user;
    }
}
