package com.summer.cat.mapper;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.summer.cat.dto.UserInfWithImgDto;
import com.summer.cat.dto.UserInfoProfileDto;
import com.summer.cat.entity.UserInf;

/**
 * <p>
 * 用户信息表 Mapper 接口
 * </p>
 *
 * @author mikko
 * @since 2021-12-20
 */
public interface UserInfMapper extends BaseMapper<UserInf> {
    /**
     * findProfileByUserNo
     *
     * @param userNo
     * @return
     */
    UserInfoProfileDto findProfileByUserNo(@Param("userNo") String userNo);

    /**
     * selectUserInfByRoleName
     * @param roleName
     * @return
     */
    UserInfWithImgDto selectUserInfByRoleName(@Param("roleName") String roleName);

}
