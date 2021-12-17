package com.summer.cat.output.temp.entity;

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
* Tag表
* </p>
*
* @author SummerCat
* @since 2020-04-28
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("blog_tag")
public class BlogTag implements Serializable {

private static final long serialVersionUID = 1L;

	/**
	* id
	*/
	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;

	/**
	* 标签名
	*/
	@TableField("bt_tag_name")
	private String btTagName;

	/**
	* 颜色
	*/
	@TableField("bt_tag_color")
	private String btTagColor;

	/**
	* 创建时间
	*/
	@TableField("bt_create_time")
	private Date btCreateTime;

	/**
	* 更新时间
	*/
	@TableField("bt_update_time")
	private Date btUpdateTime;

	/**
	* 创建人
	*/
	@TableField("bt_creator")
	private String btCreator;

	/**
	* 更新人
	*/
	@TableField("bt_updater")
	private String btUpdater;

	/**
	* 备注
	*/
	@TableField("bt_remark")
	private String btRemark;


}
