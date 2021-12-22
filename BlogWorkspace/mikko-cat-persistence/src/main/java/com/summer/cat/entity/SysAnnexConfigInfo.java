package com.summer.cat.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 系统附件表
 * </p>
 *
 * @author summerCats
 * @since 2020-01-19
 */
@EqualsAndHashCode(callSuper = true)
@TableName("sys_annex_config_info")
@Data
public class SysAnnexConfigInfo extends Model<SysAnnexConfigInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 附件编号（业务编号）
     */
    @TableField("saci_annex_num")
    private String saciAnnexNum;

    /**
     * 业务类型
     */
    @TableField("saci_annex_type")
    private String saciAnnexType;

    /**
     * 旧附件名称
     */
    @TableField("saci_old_annex_name")
    private String saciOldAnnexName;

    /**
     * 新附件名称
     */
    @TableField("saci_new_annex_name")
    private String saciNewAnnexName;

    /**
     * 存储路径
     */
    @TableField("saci_storage_path")
    private String saciStoragePath;

    /**
     * 创建时间
     */
    @TableField("saci_create_time")
    private Date saciCreateTime;

    /**
     * 创建人
     */
    @TableField("saci_creator")
    private String saciCreator;

    /**
     * 更新时间
     */
    @TableField("saci_update_time")
    private Date saciUpdateTime;

    /**
     * 更新人
     */
    @TableField("saci_updater")
    private String saciUpdater;

    /**
     * 备注
     */
    @TableField("saci_remark")
    private String saciRemark;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "SysAnnexConfigInfo{" + "id=" + id + ", saciAnnexNum=" + saciAnnexNum + ", saciAnnexType="
                + saciAnnexType + ", saciOldAnnexName=" + saciOldAnnexName + ", saciNewAnnexName=" + saciNewAnnexName
                + ", saciStoragePath=" + saciStoragePath + ", saciCreateTime=" + saciCreateTime + ", saciCreator="
                + saciCreator + ", saciUpdateTime=" + saciUpdateTime + ", saciUpdater=" + saciUpdater + ", saciRemark="
                + saciRemark + "}";
    }
}
