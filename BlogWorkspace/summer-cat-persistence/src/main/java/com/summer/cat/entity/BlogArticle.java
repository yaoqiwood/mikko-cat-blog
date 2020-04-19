package com.summer.cat.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import meme.cat.basic.entity.BaseModel;

/**
 * <p>
 * 文章表
 * </p>
 *
 * @author SummerCat
 * @since 2020-04-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("blog_article")
public class BlogArticle extends BaseModel implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户编号
     */
    @TableField("ba_user_no")
    private String baUserNo;

    /**
     * 文章标题
     */
    @TableField("ba_title")
    private String baTitle;

    /**
     * 文章内容
     */
    @TableField("ba_content")
    private String baContent;

    /**
     * 查看次数累计
     */
    @TableField("ba_view_count")
    private Integer baViewCount;

    /**
     * 评论数
     */
    @TableField("ba_comment_count")
    private Integer baCommentCount;

    /**
     * 按赞总数
     */
    @TableField("ba_like_count")
    private Integer baLikeCount;

    /**
     * 是否被允许评论：0-否，1-是
     */
    @TableField("ba_block_comment")
    private Integer baBlockComment;

    /**
     * 文章概要
     */
    @TableField("ba_summary")
    private String baSummary;

    /**
     * 状态:0-不可查看，1-可查看，9-已删除
     */
    @TableField("ba_status")
    private Integer baStatus;

    /**
     * 创建时间
     */
    @TableField("ba_create_time")
    private Date baCreateTime;

    /**
     * 更新时间
     */
    @TableField("ba_update_time")
    private Date baUpdateTime;

    /**
     * 创建者编号
     */
    @TableField("ba_creator_no")
    private String baCreatorNo;

    /**
     * 更新人编号
     */
    @TableField("ba_updater_no")
    private String baUpdaterNo;

    /**
     * 备注
     */
    @TableField("ba_remark")
    private String baRemark;

}
