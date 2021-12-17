package com.summer.cat.service.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Strings;
import com.summer.cat.entity.BlogArticleDraft;
import com.summer.cat.enums.EnumDraftStatus;
import com.summer.cat.mapper.BlogArticleDraftMapper;
import com.summer.cat.service.service.IBlogArticleDraftService;
import com.summer.cat.vo.UserRoleVo;

/**
* <p>
	* 文章草稿表 服务实现类
	* </p>
*
* @author SummerCat
* @since 2020-04-21
*/
@Service
public class BlogArticleDraftServiceImpl extends ServiceImpl<BlogArticleDraftMapper, BlogArticleDraft>
        implements IBlogArticleDraftService {

    @Override
    public QueryWrapper<BlogArticleDraft> buildWrapper(BlogArticleDraft var) {
        QueryWrapper<BlogArticleDraft> wrapper = new QueryWrapper<>();
        if (!Strings.isNullOrEmpty(var.getBadCreator())) {
            wrapper.lambda().eq(BlogArticleDraft::getBadCreator, var.getBadBlogArticleId());
        }
        return wrapper;
    }

    /**
     * 查找新增文章时当前用户下是否存在已有保存的草稿
     * @param userRoleVo
     * @return
     */
    @Override
    public Map<String, Object> findDraftAddPassage(UserRoleVo userRoleVo) {
        BlogArticleDraft draft4Search = new BlogArticleDraft();
        draft4Search.setBadCreator(userRoleVo.getUserNo());
        BlogArticleDraft articleDraft4Ret = this.getAddDraft(userRoleVo);
        Map<String, Object> returnMap = new HashMap<>(16);
        if (null != articleDraft4Ret) {
            returnMap.put("hasDraft", true);
            returnMap.put("draft", articleDraft4Ret);
        } else {
            returnMap.put("hasDraft", false);
        }
        return returnMap;
    }

    /**
     * 查找编辑模式下是否存在已有的草稿
     * @param articleId
     * @return
     */
    @Override
    public Map<String, Object> findDraftOnEdit(String articleId) {
        QueryWrapper<BlogArticleDraft> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(BlogArticleDraft::getBadBlogArticleId, articleId);
        queryWrapper.lambda().eq(BlogArticleDraft::getBadStatus, EnumDraftStatus.DRAFT.getCode());
        BlogArticleDraft articleDraft = this.getOne(queryWrapper);
        Map<String, Object> map = new HashMap<>(16);
        if (null != articleDraft) {
            map.put("hasDraft", true);
            map.put("draft", articleDraft);
        } else {
            map.put("hasDraft", false);
        }
        return map;
    }

    /**
     * 新增文章时保存草稿信息
     * 是否有id 有则更新 无则设定草稿状态未发布 set User信息
     * @param draft
     * @param userRoleVo
     * @return
     */
    @Override
    public void saveAddDraft(BlogArticleDraft draft, UserRoleVo userRoleVo) {
        BlogArticleDraft draft4Check = this.getAddDraft(userRoleVo);
        if (null == draft4Check) {
            draft.setId(null);
            draft.setBadCreator(userRoleVo.getUserNo());
            draft.setBadStatus(EnumDraftStatus.DRAFT.getCode());
            draft.setBadCreateTime(new Date());
        } else {
            draft.setId(draft4Check.getId());
            draft.setBadUpdater(userRoleVo.getUserNo());
            draft.setBadUpdateTime(new Date());
        }
        this.saveOrUpdate(draft);
    }

    /**
     * 编辑文章时保存草稿信息
     * @param draft
     * @param userRoleVo
     */
    @Override
    public void saveEditDraft(BlogArticleDraft draft, UserRoleVo userRoleVo) {
        if (null == draft.getId()) {
            draft.setBadStatus(EnumDraftStatus.DRAFT.getCode());
            draft.setBadCreator(userRoleVo.getUserNo());
            draft.setBadCreateTime(new Date());
        } else {
            draft.setBadUpdater(userRoleVo.getUserNo());
            draft.setBadUpdateTime(new Date());
        }
        this.saveOrUpdate(draft);
    }

    private BlogArticleDraft getAddDraft(UserRoleVo userRoleVo) {
        QueryWrapper<BlogArticleDraft> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(BlogArticleDraft::getBadCreator, userRoleVo.getUserNo());
        queryWrapper.lambda().eq(BlogArticleDraft::getBadStatus, EnumDraftStatus.DRAFT.getCode());
        queryWrapper.lambda().isNull(BlogArticleDraft::getBadBlogArticleId);
        return this.getOne(queryWrapper);
    }
}
