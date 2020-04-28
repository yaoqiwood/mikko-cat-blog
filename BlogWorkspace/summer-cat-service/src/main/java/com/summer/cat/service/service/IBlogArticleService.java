package com.summer.cat.service.service;

import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.summer.cat.dto.BlogArticle4Search;
import com.summer.cat.entity.BlogArticle;
import com.summer.cat.vo.UserRoleVo;

import meme.cat.basic.service.BaseService;

/**
* <p>
	* 文章表 服务类
	* </p>
*
* @author SummerCat
* @since 2020-04-17
*/
public interface IBlogArticleService extends BaseService<BlogArticle> {

    QueryWrapper<BlogArticle> buildWrapper(BlogArticle var);

    QueryWrapper<BlogArticle> buildWrapper4Search(BlogArticle4Search var);

    /**
     * 创建博文
     * @param passageJSON
     * @param tagsJSON
     */
    void createPassage(String passageJSON, String tagsJSON, UserRoleVo userRoleVo);

    /**
     * 查找文章以及tags
     * @param id
     * @return
     */
    Map<String, Object> findPassageAndTagsById(String id);
}
