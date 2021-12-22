package com.summer.cat.output.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import meme.cat.basic.entity.BaseModel;

/**
* <p>
* 用户信息表
* </p>
*
* @author mikko
* @since 2021-12-22
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("user_inf")
public class UserInf implements Serializable {

private static final long serialVersionUID = 1L;

	/**
	* id
	*/
	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;

	/**
	* 用户编号
	*/
	@TableField("user_no")
	private String userNo;

	/**
	* 用户博客短语介绍
	*/
	@TableField("user_introduce_word")
	private String userIntroduceWord;

	/**
	* 用户博客标题
	*/
	@TableField("user_blog_title_word")
	private String userBlogTitleWord;

	/**
	* 用户博客IMG
	*/
	@TableField("user_blog_profile_img_name")
	private String userBlogProfileImgName;

	/**
	* 用户信息框背景图片
	*/
	@TableField("user_blog_inf_frame_background_img")
	private String userBlogInfFrameBackgroundImg;

	/**
	* 创建人
	*/
	@TableField("ui_creator")
	private String uiCreator;

	/**
	* 创建时间
	*/
	@TableField("ui_create_time")
	private Date uiCreateTime;

	/**
	* 更新人
	*/
	@TableField("ui_updater")
	private String uiUpdater;

	/**
	* 更新时间
	*/
	@TableField("ui_update_time")
	private Date uiUpdateTime;


}
