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
* 文章Tag表
* </p>
*
* @author SummerCat
* @since 2020-04-24
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("blog_article_tag")
public class BlogArticleTag implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
    * id
    */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
    * 文章id
    */
    @TableField("bat_blog_article_id")
    private Integer batBlogArticleId;

    /**
    * 标签id
    */
    @TableField("bat_blog_tag_id")
    private Integer batBlogTagId;

    /**
    * 标签名
    */
    @TableField("bat_blog_tag_name")
    private String batBlogTagName;

    /**
    * 创建时间
    */
    @TableField("bat_create_time")
    private Date batCreateTime;

    /**
    * 备注
    */
    @TableField("bat_remark")
    private String batRemark;

}
