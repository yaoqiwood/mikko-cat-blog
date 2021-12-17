package com.summer.cat.service.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.summer.cat.entity.BlogHisTag;
import com.summer.cat.entity.BlogTag;
import com.summer.cat.mapper.BlogHisTagMapper;
import com.summer.cat.service.service.IBlogHisTagService;
import com.summer.cat.vo.UserRoleVo;

/**
 * <p>
 * 标签历史表 服务实现类
 * </p>
 *
 * @author SummerCat
 * @since 2020-04-23
 */
@Service
public class BlogHisTagServiceImpl extends ServiceImpl<BlogHisTagMapper, BlogHisTag> implements IBlogHisTagService {
    public QueryWrapper<BlogHisTag> buildWrapper(BlogHisTag var) {
        return null;
    }

    /**
     * 新增历史标签
     *
     * @param blogTagList
     * @param userRole
     */
    @Override
    public void addTagHisList(List<BlogTag> blogTagList, UserRoleVo userRole) {
        // TODO 以后增加删除100天前的历史tag
        for (BlogTag articleTag : blogTagList) {
            BlogHisTag blogHisTag = new BlogHisTag();
            blogHisTag.setBhtTagId(articleTag.getId());
            blogHisTag.setBhtTagName(articleTag.getBtTagName());
            blogHisTag.setBhtCreateTime(new Date());
            this.save(blogHisTag);
        }
    }
}
