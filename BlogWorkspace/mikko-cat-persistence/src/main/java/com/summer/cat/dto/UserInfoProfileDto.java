package com.summer.cat.dto;

import lombok.Data;

import java.util.Date;

/**
 *
 */
@Data
public class UserInfoProfileDto {
    
    private Integer id;
    private String userNo;
    private String saciAnnexType;
    private String saciOldAnnexName;
    private String saciNewAnnexName;
    private String saciStoragePath;
    private String saciCreator;
    private Date saciCreateTime;
}
