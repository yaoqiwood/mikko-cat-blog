package com.summer.cat.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.google.common.base.Strings;
import com.summer.cat.entity.SysAnnexConfigInfo;
import com.summer.cat.mapper.SysAnnexConfigInfoMapper;
import com.summer.cat.service.ISysAnnexConfigInfoService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统附件表 服务实现类
 * </p>
 *
 * @author summerCats
 * @since 2020-01-19
 */
@Service
public class SysAnnexConfigInfoServiceImpl extends ServiceImpl<SysAnnexConfigInfoMapper, SysAnnexConfigInfo> implements ISysAnnexConfigInfoService {


    @Override
    public Wrapper<SysAnnexConfigInfo> buildWrapper(SysAnnexConfigInfo item) {
        EntityWrapper<SysAnnexConfigInfo> wrapper = new EntityWrapper<>();
        if (!Strings.isNullOrEmpty(item.getSaciAnnexType())) {
            wrapper.eq("saci_annex_type", item.getSaciAnnexType());
        }
        return wrapper;
    }
}
