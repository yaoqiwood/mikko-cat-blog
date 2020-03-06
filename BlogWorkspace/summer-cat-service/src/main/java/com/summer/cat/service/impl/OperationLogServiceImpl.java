package com.summer.cat.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.summer.cat.entity.OperationLog;
import com.summer.cat.mapper.OperationLogMapper;
import com.summer.cat.service.IOperationLogService;

/**
 * <p>
 * 操作日志 服务实现类
 * </p>
 *
 * @author liugh123
 * @since 2018-05-08
 */
@Service
public class OperationLogServiceImpl extends ServiceImpl<OperationLogMapper, OperationLog>
        implements IOperationLogService {

}
