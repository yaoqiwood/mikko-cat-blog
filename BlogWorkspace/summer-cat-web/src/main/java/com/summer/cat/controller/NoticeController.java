package com.summer.cat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.alibaba.fastjson.JSONObject;
import com.summer.cat.annotation.CurrentUser;
import com.summer.cat.annotation.ValidationParam;
import com.summer.cat.base.PublicResultConstant;
import com.summer.cat.config.ResponseHelper;
import com.summer.cat.config.ResponseModel;
import com.summer.cat.entity.User;
import com.summer.cat.service.INoticeService;

import springfox.documentation.annotations.ApiIgnore;

/**
 * <p>
 * 消息通知表 前端控制器
 * </p>
 *
 * @author summer
 * @since 2018-07-27
 */
@RestController
@RequestMapping("/notice")
@ApiIgnore
public class NoticeController {

    @Autowired
    private INoticeService noticeService;

    /**
     * 获取自己的消息列表

     * @return
     * @throws Exception
     */
    @GetMapping("/infoList")
    // public ResponseModel<Page<Notice>> findInfoList(@CurrentUser User user,
    // @RequestParam(name = "pageIndex", defaultValue = "1", required = false)
    // Integer pageIndex,
    // @RequestParam(name = "pageSize", defaultValue = "10", required = false)
    // Integer pageSize) throws Exception {
    //
    // return ResponseHelper.buildResponseModel(noticeService.page(new
    // Page<>(pageIndex, pageSize),
    // new QueryWrapper<>().eq("mobile", user.getMobile())));
    // }

    /**
     * 删除全部消息
     * @return
     * @throws Exception
     */
    @DeleteMapping
    public ResponseModel findInfoList(@CurrentUser User user) throws Exception {
        noticeService.deleteByNotices(user);
        return ResponseHelper.buildResponseModel(PublicResultConstant.SUCCEED);
    }

    /**
     * 消息改变为已读
     * @param requestJson
     * @return
     * @throws Exception
     */
    @PostMapping("/read")
    public ResponseModel read(@ValidationParam("noticeId,isRead") @RequestBody JSONObject requestJson)
            throws Exception {
        noticeService.read(requestJson);
        return ResponseHelper.buildResponseModel(PublicResultConstant.SUCCEED);
    }

    /**
     * 未读消息总数
     * @return
     * @throws Exception
     */
    // @GetMapping("/noReadCount")
    // public ResponseModel getNoRead(@CurrentUser User user) throws Exception {
    // return ResponseHelper.buildResponseModel(noticeService
    // .selectList(new EntityWrapper<Notice>().where("mobile = {0} and is_read = 0",
    // user.getMobile()))
    // .size());
    // }

}
