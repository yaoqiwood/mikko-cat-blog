package com.summer.cat.service.service.impl;

import java.io.*;
import java.util.*;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Strings;
import com.summer.cat.entity.SysAnnexConfigInfo;
import com.summer.cat.enums.EnumSaciAnnexType;
import com.summer.cat.mapper.SysAnnexConfigInfoMapper;
import com.summer.cat.service.service.ISysAnnexConfigInfoService;
import com.summer.cat.service.system.SystemConfig;
import com.summer.cat.util.BufferCloseUtil;
import com.summer.cat.util.CatsException;
import com.summer.cat.util.FileUtils;
import com.summer.cat.util.SnowFlakeUtil;

import cn.hutool.core.io.FileTypeUtil;
import cn.hutool.core.io.FileUtil;

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

    /**
     * uploadImgFile
     * @param file
     * @param userNo
     */
    @Override
    public SysAnnexConfigInfo uploadImgFile(MultipartFile file, String userNo) throws IOException {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        String outFilePath = "";
        String outFileName = "";
        String contentPath = "";
        try {
            if (file.isEmpty()) {
                throw new CatsException("错误,文件为空");
            }
            int fileCheckSize = 10;
            String checkSizeUnit = "MB";
            if (FileUtils.isOutOfCheckSize(file.getSize(), 10, checkSizeUnit)) {
                throw new CatsException("错误，文件大小超过 " + fileCheckSize + checkSizeUnit + " 限制");
            }
            if (FileUtils.isImgSuffixNameError(file.getInputStream())) {
                throw new CatsException("错误，文件类型错误，仅支持 jpg,png,gif,webp");
            }

            byte[] data = new byte[1024];
            bis = new BufferedInputStream(file.getInputStream());
            outFilePath = SystemConfig.systemUploadDir + File.separator + SystemConfig.tempDir + File.separator;
            contentPath = File.separator + SystemConfig.tempDir + File.separator;
            outFileName = SnowFlakeUtil.getId() + "." + FileTypeUtil.getType(file.getInputStream());
            File outputDir = new File(outFilePath);
            boolean mkdirSuccess = false;
            if (!FileUtil.exist(outFilePath)) {
                mkdirSuccess = outputDir.mkdirs();
            }
            String outFilePathName = outFilePath + outFileName;
            File outFile = new File(outFilePathName);
            bos = new BufferedOutputStream(new FileOutputStream(outFile));
            int fileLen;
            while (-1 != (fileLen = bis.read(data))) {
                bos.write(data, 0, fileLen);
            }
            bos.flush();
        } finally {
            try {
                BufferCloseUtil.closeBufferInput(bis);
                BufferCloseUtil.closeBufferOutput(bos);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        SysAnnexConfigInfo sysAnnexConfigInfo = new SysAnnexConfigInfo();
        sysAnnexConfigInfo.setSaciAnnexType(EnumSaciAnnexType.TEMP_UPLOAD_IMG.getLabel());
        sysAnnexConfigInfo.setSaciStoragePath(contentPath);
        sysAnnexConfigInfo.setSaciOldAnnexName(outFileName);
        sysAnnexConfigInfo.setSaciCreateTime(new Date());
        sysAnnexConfigInfo.setSaciCreator(userNo);
        this.save(sysAnnexConfigInfo);
        return sysAnnexConfigInfo;
    }
}
