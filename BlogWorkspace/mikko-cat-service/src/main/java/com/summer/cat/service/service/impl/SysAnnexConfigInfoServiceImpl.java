package com.summer.cat.service.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Strings;
import com.summer.cat.entity.SysAnnexConfigInfo;
import com.summer.cat.enums.EnumSaciAnnexType;
import com.summer.cat.mapper.SysAnnexConfigInfoMapper;
import com.summer.cat.service.service.ISysAnnexConfigInfoService;

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

    /**
     * 获取所有Menhara图片的Id
     * @return
     */
    @Override
    public List<Map<String, Integer>> getMenharaItems() {
        SysAnnexConfigInfo sysAnnexConfigInfo4Search = new SysAnnexConfigInfo();
        sysAnnexConfigInfo4Search.setSaciAnnexType(EnumSaciAnnexType.MENHARA.getLabel());
        List<SysAnnexConfigInfo> sysAnnexConfigInfoList = this.list(this.buildWrapper(sysAnnexConfigInfo4Search));
        List<Map<String, Integer>> menharaIdList = new ArrayList<>();
        for (SysAnnexConfigInfo item : sysAnnexConfigInfoList) {
            Map<String, Integer> mapInteger = new HashMap<>();
            mapInteger.put("id", item.getId());
            menharaIdList.add(mapInteger);
        }
        return menharaIdList;
    }
}
