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
* 文章草稿表
* </p>
*
* @author SummerCat
* @since 2020-04-21
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("blog_article_draft")
public class BlogArticleDraft implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
    * id
    */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
    * 文章表id
    */
    @TableField("bad_blog_article_id")
    private Integer badBlogArticleId;

    /**
    * 草稿标题
    */
    @TableField("bad_title")
    private String badTitle;

    /**
    * 草稿内容
    */
    @TableField("bad_content")
    private String badContent;

    /**
    * 草稿状态：released-已发布 draft-未发布
    */
    @TableField("bad_status")
    private String badStatus;

    /**
    * 创建时间
    */
    @TableField("bad_create_time")
    private Date badCreateTime;

    /**
    * 更新时间
    */
    @TableField("bad_update_time")
    private Date badUpdateTime;

    /**
    * 创建人ID
    */
    @TableField("bad_creator")
    private String badCreator;

    /**
    * 更新人
    */
    @TableField("bad_updater")
    private String badUpdater;

    /**
    * 备注
    */
    @TableField("bad_remark")
    private String badRemark;

}
