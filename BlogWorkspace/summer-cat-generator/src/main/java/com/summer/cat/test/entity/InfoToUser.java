package com.summer.cat.test.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户账号关系表
 * </p>
 *
 * @author SummerCat
 * @since 2020-03-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class InfoToUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "info_to_user_id", type = IdType.AUTO)
    private Integer infoToUserId;

    /**
     * 用户账号
     */
    private String identityInfo;

    /**
     * 用户主键
     */
    private String userNo;

    /**
     * 登录类型:0 用户名登录 1手机登录 2 邮箱登录
     */
    private Integer identityType;


}
