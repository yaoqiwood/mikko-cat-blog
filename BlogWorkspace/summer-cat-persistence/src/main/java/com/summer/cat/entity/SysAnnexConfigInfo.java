package com.summer.cat.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 系统附件表
 * </p>
 *
 * @author summerCats
 * @since 2020-01-19
 */
@TableName("sys_annex_config_info")
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


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSaciAnnexNum() {
        return saciAnnexNum;
    }

    public void setSaciAnnexNum(String saciAnnexNum) {
        this.saciAnnexNum = saciAnnexNum;
    }

    public String getSaciAnnexType() {
        return saciAnnexType;
    }

    public void setSaciAnnexType(String saciAnnexType) {
        this.saciAnnexType = saciAnnexType;
    }

    public String getSaciOldAnnexName() {
        return saciOldAnnexName;
    }

    public void setSaciOldAnnexName(String saciOldAnnexName) {
        this.saciOldAnnexName = saciOldAnnexName;
    }

    public String getSaciNewAnnexName() {
        return saciNewAnnexName;
    }

    public void setSaciNewAnnexName(String saciNewAnnexName) {
        this.saciNewAnnexName = saciNewAnnexName;
    }

    public String getSaciStoragePath() {
        return saciStoragePath;
    }

    public void setSaciStoragePath(String saciStoragePath) {
        this.saciStoragePath = saciStoragePath;
    }

    public Date getSaciCreateTime() {
        return saciCreateTime;
    }

    public void setSaciCreateTime(Date saciCreateTime) {
        this.saciCreateTime = saciCreateTime;
    }

    public String getSaciCreator() {
        return saciCreator;
    }

    public void setSaciCreator(String saciCreator) {
        this.saciCreator = saciCreator;
    }

    public Date getSaciUpdateTime() {
        return saciUpdateTime;
    }

    public void setSaciUpdateTime(Date saciUpdateTime) {
        this.saciUpdateTime = saciUpdateTime;
    }

    public String getSaciUpdater() {
        return saciUpdater;
    }

    public void setSaciUpdater(String saciUpdater) {
        this.saciUpdater = saciUpdater;
    }

    public String getSaciRemark() {
        return saciRemark;
    }

    public void setSaciRemark(String saciRemark) {
        this.saciRemark = saciRemark;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "SysAnnexConfigInfo{" +
        "id=" + id +
        ", saciAnnexNum=" + saciAnnexNum +
        ", saciAnnexType=" + saciAnnexType +
        ", saciOldAnnexName=" + saciOldAnnexName +
        ", saciNewAnnexName=" + saciNewAnnexName +
        ", saciStoragePath=" + saciStoragePath +
        ", saciCreateTime=" + saciCreateTime +
        ", saciCreator=" + saciCreator +
        ", saciUpdateTime=" + saciUpdateTime +
        ", saciUpdater=" + saciUpdater +
        ", saciRemark=" + saciRemark +
        "}";
    }
}
