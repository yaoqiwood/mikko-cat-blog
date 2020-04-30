package com.summer.cat.controller.blog;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.*;

import com.summer.cat.base.Constant;
import com.summer.cat.entity.BlogArticleDraft;
import com.summer.cat.service.service.IBlogArticleDraftService;
import com.summer.cat.util.Returns;
import com.summer.cat.vo.UserRoleVo;

import lombok.extern.slf4j.Slf4j;
import meme.cat.basic.controller.BaseController;

/**
* <p>
* 文章草稿表 前端控制器
* </p>
*
* @author SummerCat
* @since 2020-04-21
*/
@RestController
@RequestMapping("/blog/blog-article-draft")
@Slf4j
public class BlogArticleDraftController extends BaseController<BlogArticleDraft, IBlogArticleDraftService> {
    public BlogArticleDraftController() {
        super(BlogArticleDraft.class);
    }

    /**
     * 查找当前是否存在未发布文章草稿（新增时） 如果存在，则返回true并将该文章
     * 返回给前端 反之 则返回false
     * @param request
     * @return
     */
    @PostMapping(value = { "findDraftAddPassage" })
    @ResponseBody
    public Map<String, ?> findDraftAddPassage(HttpServletRequest request) {
        try {
            // TODO 后续修改为由redis 获取用户信息
            UserRoleVo userRoleVo = (UserRoleVo) request.getAttribute(Constant.CURRENT_USER_REQUEST_NAME);
            return Returns.mapOk(service.findDraftAddPassage(userRoleVo), Constant.ReturnsMessage.SUCCESS_MSG);
        } catch (Exception e) {
            log.error(Constant.ReturnsMessage.ERROR_MSG, e);
            return Returns.mapError(Constant.ReturnsMessage.ERROR_MSG + e.getMessage());
        }
    }

    /**
     * 新增文章时保存草稿信息
     * @param draft
     * @param request
     * @return
     */
    @PostMapping(value = { "saveAddDraft" })
    @ResponseBody
    public Map<String, ?> saveAddDraft(@RequestBody BlogArticleDraft draft, HttpServletRequest request) {
        try {
            // TODO 后续修改Redis
            UserRoleVo userRoleVo = (UserRoleVo) request.getAttribute(Constant.CURRENT_USER_REQUEST_NAME);
            service.saveAddDraft(draft, userRoleVo);
            return Returns.mapOk(Constant.ReturnsMessage.SUCCESS);
        } catch (Exception e) {
            log.error(Constant.ReturnsMessage.ERROR_MSG, e);
            return Returns.mapError(Constant.ReturnsMessage.ERROR_MSG + e.getMessage());
        }
    }
}
