package com.summer.cat.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
* <p>
* 标签历史表
* </p>
*
* @author SummerCat
* @since 2020-04-23
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("blog_his_tag")
public class BlogHisTag implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
    * id
    */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
    * 用户Id
    */
    @TableField("bht_user_id")
    private Integer bhtUserId;

    /**
    * 标签id
    */
    @TableField("bht_tag_id")
    private Integer bhtTagId;

    /**
    * 标签名
    */
    @TableField("bht_tag_name")
    private String bhtTagName;

    /**
    * 创建时间
    */
    @TableField("bht_create_time")
    private Date bhtCreateTime;

    /**
    * 备注
    */
    @TableField("bht_remark")
    private String bhtRemark;

}
