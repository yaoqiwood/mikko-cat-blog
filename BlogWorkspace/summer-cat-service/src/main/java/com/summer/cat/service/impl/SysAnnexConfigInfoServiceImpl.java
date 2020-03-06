package com.summer.cat.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Strings;
import com.summer.cat.entity.SysAnnexConfigInfo;
import com.summer.cat.mapper.SysAnnexConfigInfoMapper;
import com.summer.cat.service.ISysAnnexConfigInfoService;

/**
 * <p>
 * 系统附件表 服务实现类
 * </p>
 *
 * @author summerCats
 * @since 2020-01-19
 */
@Service
public class SysAnnexConfigInfoServiceImpl extends ServiceImpl<SysAnnexConfigInfoMapper, SysAnnexConfigInfo>
        implements ISysAnnexConfigInfoService {

    @Override
    public QueryWrapper<SysAnnexConfigInfo> buildWrapper(SysAnnexConfigInfo item) {
        QueryWrapper<SysAnnexConfigInfo> wrapper = new QueryWrapper<>();
        if (!Strings.isNullOrEmpty(item.getSaciAnnexType())) {
            wrapper.eq("saci_annex_type", item.getSaciAnnexType());
        }
        return wrapper;
    }
}
