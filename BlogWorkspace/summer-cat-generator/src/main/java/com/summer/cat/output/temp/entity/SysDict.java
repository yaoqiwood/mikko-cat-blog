package com.summer.cat.output.temp.entity;

import com.baomidou.mybatisplus.annotation.TableName;
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
* 系统数据字典表
* </p>
*
* @author SummerCat
* @since 2020-04-18
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_dict")
public class SysDict implements Serializable {

private static final long serialVersionUID = 1L;

	/**
	* id
	*/
	@TableId("id")
	private Integer id;

	/**
	* 代码
	*/
	@TableField("sd_code")
	private String sdCode;

	/**
	* 名称
	*/
	@TableField("sd_name")
	private String sdName;

	/**
	* 描述
	*/
	@TableField("sd_desc")
	private String sdDesc;

	/**
	* 状态（1:展示可编辑，2:展示不可编辑，3:不展示
	*/
	@TableField("sd_status")
	private String sdStatus;

	/**
	* 创建时间
	*/
	@TableField("sd_create_time")
	private Date sdCreateTime;

	/**
	* 创建人
	*/
	@TableField("sd_creator")
	private String sdCreator;

	/**
	* 更新时间
	*/
	@TableField("sd_update_time")
	private Date sdUpdateTime;

	/**
	* 更新人
	*/
	@TableField("sd_updater")
	private String sdUpdater;

	/**
	* 备注
	*/
	@TableField("sd_remark")
	private String sdRemark;


}
