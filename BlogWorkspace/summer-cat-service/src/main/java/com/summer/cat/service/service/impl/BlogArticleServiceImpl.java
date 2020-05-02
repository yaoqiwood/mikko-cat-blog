package com.summer.cat.service.service.impl;

import java.util.*;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Strings;
import com.summer.cat.dto.BlogArticle4Search;
import com.summer.cat.entity.BlogArticle;
import com.summer.cat.entity.BlogArticleDraft;
import com.summer.cat.entity.BlogArticleTag;
import com.summer.cat.entity.BlogTag;
import com.summer.cat.enums.EnumArticleStatus;
import com.summer.cat.enums.EnumDraftStatus;
import com.summer.cat.mapper.BlogArticleMapper;
import com.summer.cat.service.service.*;
import com.summer.cat.util.CatsException;
import com.summer.cat.util.GsonUtil;
import com.summer.cat.vo.UserRoleVo;

/**
 * <p>
 * 文章表 服务实现类
 * </p>
 *
 * @author SummerCat
 * @since 2020-04-17
 */
@Service
public class BlogArticleServiceImpl extends ServiceImpl<BlogArticleMapper, BlogArticle> implements IBlogArticleService {
    final IBlogArticleTagService articleTagService;

    final IBlogTagService tagService;

    final IBlogHisTagService hisTagService;

    final IBlogArticleDraftService articleDraftService;

    public BlogArticleServiceImpl(IBlogArticleTagService articleTagService, IBlogTagService tagService,
            IBlogHisTagService hisTagService, IBlogArticleDraftService articleDraftService) {
        this.articleTagService = articleTagService;
        this.tagService = tagService;
        this.hisTagService = hisTagService;
        this.articleDraftService = articleDraftService;
    }

    @Override
    public QueryWrapper<BlogArticle> buildWrapper(BlogArticle var) {
        QueryWrapper<BlogArticle> queryWrapper = new QueryWrapper<>();
        if (!Strings.isNullOrEmpty(var.getBaTitle())) {
            queryWrapper.lambda().like(BlogArticle::getBaTitle, var.getBaTitle());
        }
        // 筛选非删除状态
        queryWrapper.lambda().ne(BlogArticle::getBaStatus, EnumArticleStatus.DELETED.getCode());
        return queryWrapper;
    }

    @Override
    public QueryWrapper<BlogArticle> buildWrapper4Search(BlogArticle4Search var) {
        QueryWrapper<BlogArticle> queryWrapper = this.buildWrapper(var);
        if (null != var.getBaCreateTimeBegin()) {
            queryWrapper.lambda().gt(BlogArticle::getBaCreateTime, var.getBaCreateTimeBegin());
        }
        if (null != var.getBaCreateTimeEnd()) {
            queryWrapper.lambda().le(BlogArticle::getBaCreateTime, var.getBaCreateTimeEnd());
        }
        return queryWrapper;
    }

    /**
     * 创建博文 增加tagList 关联之间关系 存放用户历史tag 成功保存后删除当前用户下的关联草稿
     *
     * @param passageJSON
     * @param tagsJSON
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createPassage(String passageJSON, String tagsJSON, UserRoleVo userRoleVo) {
        if (Strings.isNullOrEmpty(passageJSON)) {
            throw new CatsException("文章数据不可为空");
        }
        BlogArticle blogArticle = GsonUtil.gson2Bean(passageJSON, BlogArticle.class);
        List<BlogTag> blogTagList = new ArrayList<>();
        if (!Strings.isNullOrEmpty(tagsJSON)) {
            blogTagList = GsonUtil.gson2List(tagsJSON, BlogTag.class);
        }
        blogArticle.setId(null);
        blogArticle.setBaSummary(
                blogArticle.getBaContent().substring(0, Math.min(blogArticle.getBaContent().length(), 100)));
        blogArticle.setBaCreateTime(new Date());
        this.save(blogArticle);
        for (BlogTag blogTag : blogTagList) {
            tagService.insertTagByIgnoreIfExistTagName(blogTag);
            // tag 关联
            BlogArticleTag articleTag = new BlogArticleTag();
            articleTag.setBatBlogTagId(blogTag.getId());
            articleTag.setBatBlogArticleId(blogArticle.getId());
            articleTag.setBatBlogTagName(blogTag.getBtTagName());
            articleTag.setBatCreateTime(new Date());
            articleTagService.save(articleTag);
        }
        hisTagService.addTagHisList(blogTagList, userRoleVo);
        // 删除草稿
        QueryWrapper<BlogArticleDraft> draftQueryWrapper = new QueryWrapper<>();
        draftQueryWrapper.lambda().eq(BlogArticleDraft::getBadCreator, userRoleVo.getUserNo());
        draftQueryWrapper.lambda().eq(BlogArticleDraft::getBadStatus, EnumDraftStatus.DRAFT.getCode());

        BlogArticleDraft articleDraft4Update = new BlogArticleDraft();
        articleDraft4Update.setBadUpdater(userRoleVo.getUserNo());
        articleDraft4Update.setBadUpdateTime(new Date());
        articleDraft4Update.setBadStatus(EnumDraftStatus.RELEASED.getCode());
        articleDraftService.update(articleDraft4Update, draftQueryWrapper);
    }

    /**
     * 更新博文（更新前先删除）更新标签 更新文章状态 删除相关草稿（改状态）
     *
     * @param passageJSON
     * @param tagsJSON
     * @param userRoleVo
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updatePassage(String passageJSON, String tagsJSON, UserRoleVo userRoleVo) {
        if (Strings.isNullOrEmpty(passageJSON)) {
            throw new CatsException("文章数据不可为空");
        }
        BlogArticle blogArticle = GsonUtil.gson2Bean(passageJSON, BlogArticle.class);
        List<BlogTag> articleTagList = new ArrayList<>();
        if (!Strings.isNullOrEmpty(tagsJSON)) {
            articleTagList = GsonUtil.gson2List(tagsJSON, BlogTag.class);
        }
        blogArticle.setBaUpdaterNo(userRoleVo.getUserNo());
        blogArticle.setBaUpdateTime(new Date());
        this.updateById(blogArticle);

        // 开始更新tags
        for (BlogTag blogTag : articleTagList) {
            this.tagService.insertTagByIgnoreIfExistTagName(blogTag);
        }
        QueryWrapper<BlogArticleTag> tagArticleQueryWrapper = new QueryWrapper<>();
        tagArticleQueryWrapper.lambda().eq(BlogArticleTag::getBatBlogArticleId, blogArticle.getId());
        articleTagService.remove(tagArticleQueryWrapper);

        for (BlogTag blogTag : articleTagList) {
            BlogArticleTag articleTag = new BlogArticleTag();
            articleTag.setBatBlogArticleId(blogArticle.getId());
            articleTag.setBatBlogTagName(blogTag.getBtTagName());
            articleTag.setBatBlogTagId(blogTag.getId());
            articleTag.setBatCreateTime(new Date());
            articleTagService.save(articleTag);
        }

        // 删除草稿
        QueryWrapper<BlogArticleDraft> draftQueryWrapper = new QueryWrapper<>();
        draftQueryWrapper.lambda().eq(BlogArticleDraft::getBadBlogArticleId, blogArticle.getId());
        articleDraftService.remove(draftQueryWrapper);
    }

    /**
     * 查找文章以及tags
     *
     * @param id
     * @return
     */
    @Override
    public Map<String, Object> findPassageAndTagsById(String id) {
        Map<String, Object> blogArticleAndTagListMap = new HashMap<>(16);
        BlogArticle blogArticle = this.getById(id);
        List<BlogTag> tagList = tagService.selectTagsByArticleId(id);
        blogArticleAndTagListMap.put("blogArticle", blogArticle);
        blogArticleAndTagListMap.put("tagList", tagList);
        return blogArticleAndTagListMap;
    }

}
