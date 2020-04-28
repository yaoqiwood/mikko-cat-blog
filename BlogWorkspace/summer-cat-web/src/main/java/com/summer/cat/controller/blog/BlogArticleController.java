package com.summer.cat.controller.blog;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.*;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.base.Strings;
import com.summer.cat.base.Constant;
import com.summer.cat.dto.BlogArticle4Search;
import com.summer.cat.entity.BlogArticle;
import com.summer.cat.service.service.IBlogArticleService;
import com.summer.cat.util.GsonUtil;
import com.summer.cat.util.LogUtil;
import com.summer.cat.util.Returns;
import com.summer.cat.vo.UserRoleVo;

import lombok.extern.slf4j.Slf4j;
import meme.cat.basic.controller.BaseController;

/**
* <p>
 * 文章表 前端控制器
 * </p>
*
* @author SummerCat
* @since 2020-04-17
*/
@RestController
@RequestMapping("/blog/blog-article")
@Slf4j
public class BlogArticleController extends BaseController<BlogArticle, IBlogArticleService> {
    public BlogArticleController() {
        super(BlogArticle.class);
    }

    /**
     * 附带高级搜索
     * @param page
     * @param rows
     * @param exampleJson
     * @return
     */
    @PostMapping(value = { "searchPassages" })
    @ResponseBody
    public Map<String, ? extends Object> searchPassages(@RequestParam long page, @RequestParam long rows,
            @RequestParam(required = false) String exampleJson) {
        try {
            BlogArticle4Search blogArticle4Search = new BlogArticle4Search();
            if (!Strings.isNullOrEmpty(exampleJson)) {
                blogArticle4Search = GsonUtil.gson2Bean(exampleJson, BlogArticle4Search.class);
            }
            QueryWrapper<BlogArticle> queryWrapper = null;
            if (null != blogArticle4Search) {
                queryWrapper = this.service.buildWrapper4Search(blogArticle4Search);
            }
            IPage<BlogArticle> rowItems = this.service.page(new Page<>(page, rows), queryWrapper);
            return Returns.mapOk(rowItems.getRecords(), rowItems.getTotal(), Constant.ReturnsMessage.SUCCESS_MSG);
        } catch (Exception e) {
            log.error(Constant.ReturnsMessage.ERROR_MSG, e);
            return Returns.mapError(Constant.ReturnsMessage.ERROR_MSG + e.getMessage());
        }
    }

    /**
     * 查找当前ID下的文章及Tags
     * @param id
     * @return
     */
    @PostMapping(value = { "findPassageAndTagsById" })
    @ResponseBody
    public Map<String, ?> findPassageAndTagsById(@RequestParam String id) {
        try {
            return Returns.mapOk(service.findPassageAndTagsById(id), Constant.ReturnsMessage.SUCCESS_MSG);
        } catch (Exception e) {
            log.error(Constant.ReturnsMessage.ERROR_MSG, e);
            return Returns.mapError(Constant.ReturnsMessage.ERROR_MSG + e.getMessage());
        }
    }

    /**
     * 创建博客博文
     * @param passageJSON
     * @param tagsJSON
     * @return
     */
    @PostMapping(value = { "createPassage" })
    @ResponseBody
    public Map<String, ? extends Object> createPassage(@RequestParam String passageJSON, String tagsJSON,
            HttpServletRequest request) {
        try {
            // TODO 后续使用redis替换
            UserRoleVo userRoleVo = (UserRoleVo) request.getAttribute(Constant.CURRENT_USER_REQUEST_NAME);
            this.service.createPassage(passageJSON, tagsJSON, userRoleVo);
            return Returns.mapOk(Constant.ReturnsMessage.SUCCESS);
        } catch (Exception e) {
            LogUtil.error(Constant.ReturnsMessage.ERROR_MSG, e);
            return Returns.mapError(Constant.ReturnsMessage.ERROR_MSG);
        }
    }

}
