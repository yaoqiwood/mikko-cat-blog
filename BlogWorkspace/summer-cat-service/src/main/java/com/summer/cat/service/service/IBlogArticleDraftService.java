package com.summer.cat.service.service;

import java.util.Map;

import com.summer.cat.entity.BlogArticleDraft;
import com.summer.cat.vo.UserRoleVo;

import meme.cat.basic.service.BaseService;

/**
* <p>
	* 文章草稿表 服务类
	* </p>
*
* @author SummerCat
* @since 2020-04-21
*/
public interface IBlogArticleDraftService extends BaseService<BlogArticleDraft> {
    /**
     * 查找新增文章时当前用户下是否存在已有保存的草稿
     * @param userRoleVo
     * @return
     */
    Map<String, Object> findDraftAddPassage(UserRoleVo userRoleVo);

    /**
     * 查找编辑模式下是否存在已有的草稿
     * @param id
     * @return
     */
    Map<String, Object> findDraftOnEdit(String id);

    /**
     * 新增文章时保存草稿信息
     * @param draft
     * @param userRoleVo
     * @return
     */
    void saveAddDraft(BlogArticleDraft draft, UserRoleVo userRoleVo);

    /**
     * 编辑文章时保存草稿信息
     * @param draft
     * @param userRoleVo
     */
    void saveEditDraft(BlogArticleDraft draft, UserRoleVo userRoleVo);
}
