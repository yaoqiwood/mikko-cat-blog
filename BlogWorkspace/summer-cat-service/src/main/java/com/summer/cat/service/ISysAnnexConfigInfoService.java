package com.summer.cat.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.summer.cat.entity.SysAnnexConfigInfo;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 系统附件表 服务类
 * </p>
 *
 * @author summerCats
 * @since 2020-01-19
 */
public interface ISysAnnexConfigInfoService extends IService<SysAnnexConfigInfo> {
    public Wrapper<SysAnnexConfigInfo> buildWrapper(SysAnnexConfigInfo item);
}
