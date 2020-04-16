package com.summer.cat.service.service.basic;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.IService;

public interface BaseService<T> extends IService<T> {
    Wrapper<T> buildWrapper(T var);
}
