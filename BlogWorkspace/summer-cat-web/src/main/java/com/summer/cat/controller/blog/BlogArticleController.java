package com.summer.cat.controller.blog;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.*;

import com.summer.cat.base.Constant;
import com.summer.cat.entity.BlogArticle;
import com.summer.cat.service.service.IBlogArticleService;
import com.summer.cat.util.LogUtil;
import com.summer.cat.util.Returns;
import com.summer.cat.vo.UserRoleVo;

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
public class BlogArticleController extends BaseController<BlogArticle, IBlogArticleService> {
    public BlogArticleController() {
        super(BlogArticle.class);
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
