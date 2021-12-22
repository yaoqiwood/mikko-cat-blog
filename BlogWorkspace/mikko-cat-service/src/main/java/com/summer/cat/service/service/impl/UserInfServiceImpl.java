package com.summer.cat.service.service.impl;

import java.io.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.summer.cat.base.Constant;
import com.summer.cat.dto.UserInfWithImgDto;
import com.summer.cat.dto.UserInfoProfileDto;
import com.summer.cat.entity.UserInf;
import com.summer.cat.mapper.UserInfMapper;
import com.summer.cat.mapper.UserMapper;
import com.summer.cat.service.service.IUserInfService;
import com.summer.cat.util.BufferCloseUtil;
import com.summer.cat.util.CatsException;
import com.summer.cat.util.FileUtils;

import cn.hutool.core.codec.Base64Encoder;
import cn.hutool.core.io.FileUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author mikko
 * @since 2021-12-20
 */
@Service
@Slf4j
public class UserInfServiceImpl extends ServiceImpl<UserInfMapper, UserInf> implements IUserInfService {

    private UserMapper userMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    /**
     * 用于构造搜索接口的条件
     *
     * @param var
     * @return
     */
    @Override
    public QueryWrapper<UserInf> buildWrapper(UserInf var) {
        return null;
    }

    /**
     * findProfileByUserNo
     *
     * @param userNo
     * @return
     */
    @Override
    public UserInfoProfileDto findProfileByUserNo(String userNo) {
        return this.baseMapper.findProfileByUserNo(userNo);
    }

    /**
     * 查找管理员号
     * @return
     */
    @Override
    public String selectAdminNoByUserRole() {
        return userMapper.selectUserNoByUserRole(Constant.RoleType.SYS_ASMIN_ROLE);
    }

    /**
     * 读取用户博客（admin）主页信息框背景等
     * @param systemUploadDir
     * @return
     * @throws IOException
     */
    @Override
    public UserInfWithImgDto loadUserInfWithImg(String systemUploadDir) throws IOException {
        UserInfWithImgDto userInfWithImgDto = this.baseMapper.selectUserInfByRoleName(Constant.RoleType.SYS_ASMIN_ROLE);
        String path = systemUploadDir + userInfWithImgDto.getSaciStoragePath()
                + userInfWithImgDto.getSaciNewAnnexName();
        BufferedInputStream bis = null;
        byte[] data = null;
        if (!FileUtil.exist(path)) {
            log.error("错误，不存在此文件，路径：\n" + path);
            throw new CatsException("错误，不存在此文件，路径：\n" + path);
        }
        File file = new File(path);
        if (!FileUtils.isImage(file)) {
            log.error("错误，不是一个图片文件：\n" + path);
            throw new CatsException("错误，不是一个图片文件，路径：\n" + path);
        }
        try {
            bis = new BufferedInputStream(new FileInputStream(file));
            data = new byte[bis.available()];
            int readData = bis.read(data);
            String base64Code = Base64Encoder.encode(data);
            userInfWithImgDto.setInfFrameBackgroundImgBase64Code(base64Code);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            BufferCloseUtil.closeBufferInput(bis);
        }
        userInfWithImgDto.setSaciStoragePath(null);
        userInfWithImgDto.setSaciNewAnnexName(null);
        return userInfWithImgDto;
    }
}
