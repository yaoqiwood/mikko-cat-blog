package com.summer.cat.dto;

import java.util.Date;

import com.summer.cat.entity.BlogArticle;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class BlogArticle4Search extends BlogArticle {
    // 创建开始时间
    private Date baCreateTimeBegin;

    // 创建结束时间
    private Date baCreateTimeEnd;
}
