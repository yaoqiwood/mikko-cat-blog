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
* 消息通知表
* </p>
*
* @author SummerCat
* @since 2020-04-21
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("notice")
public class Notice implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
    * 主键
    */
    @TableId(value = "notice_id", type = IdType.AUTO)
    private Integer noticeId;

    /**
    * 标题
    */
    @TableField("title")
    private String title;

    /**
    * 类型 1:消息类型11;2:消息类型22;3:消息类型33;4:消息类型44;5:消息类型55
    */
    @TableField("type")
    private Integer type;

    /**
    * 创建时间
    */
    @TableField("create_time")
    private Date createTime;

    /**
    * 消息所有者
    */
    @TableField("mobile")
    private String mobile;

    /**
    * 关联的主题no
    */
    @TableField("theme_no")
    private String themeNo;

    /**
    * 是否已读 0 未读; 1 已读
    */
    @TableField("is_read")
    private Integer isRead;

}
