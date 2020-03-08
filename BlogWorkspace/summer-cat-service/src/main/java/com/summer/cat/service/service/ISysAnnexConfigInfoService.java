package com.summer.cat.service.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.summer.cat.entity.SysAnnexConfigInfo;

/**
 * <p>
 * 系统附件表 服务类
 * </p>
 *
 * @author summerCats
 * @since 2020-01-19
 */
public interface ISysAnnexConfigInfoService extends IService<SysAnnexConfigInfo> {
    public QueryWrapper<SysAnnexConfigInfo> buildWrapper(SysAnnexConfigInfo item);
}
