package com.summer.cat.controller;


import com.summer.cat.annotation.Pass;
import com.summer.cat.base.Constant;
import com.summer.cat.entity.Menu;
import com.summer.cat.service.IMenuService;
import com.summer.cat.util.LogUtil;
import com.summer.cat.util.Returns;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author summerCat
 * @since 2018-05-03
 */
@RestController
@RequestMapping("/permission")
//不加入swagger ui里
@ApiIgnore
public class MenuController {
    @Autowired
    private IMenuService menuService;

    @RequestMapping(value = "getMenu.action")
    @Pass
    @ResponseBody
    public Map<String, ? extends Object> getMenu() {
        try {
            List<Menu> menuList = menuService.getAllMenu(Constant.ROOT_MENU);
            return Returns.mapOk(menuList, Constant.ReturnsMessage.SUCCESS_MSG);
        } catch (Exception e) {
            LogUtil.error(Constant.ReturnsMessage.ERROR_MSG, e);
            return Returns.mapError(Constant.ReturnsMessage.ERROR_MSG + e.getMessage());
        }
    }
}

