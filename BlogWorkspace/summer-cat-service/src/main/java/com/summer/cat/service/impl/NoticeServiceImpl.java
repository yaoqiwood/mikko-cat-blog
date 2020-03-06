package com.summer.cat.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.summer.cat.base.BusinessException;
import com.summer.cat.entity.Notice;
import com.summer.cat.entity.User;
import com.summer.cat.mapper.NoticeMapper;
import com.summer.cat.service.INoticeService;
import com.summer.cat.util.ComUtil;

/**
 * <p>
 * 消息通知表 服务实现类
 * </p>
 *
 * @author liugh123
 * @since 2018-07-27
 */
@Service
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice> implements INoticeService {

    @Override
    public void insertByThemeNo(String themeNo, String mobile) {
        Notice notice = Notice.builder().themeNo(themeNo).type(1).title("测试通知1111111111")
                // 未读
                .mobile(mobile).createTime(System.currentTimeMillis()).isRead(0).build();
        this.save(notice);
    }

    @Override
    public void deleteByNotices(User user) throws Exception {
        List<Notice> notices = this.list(new QueryWrapper<Notice>().eq("mobile", user.getMobile()));
        if (ComUtil.isEmpty(notices)) {
            throw new BusinessException("当前用户不存在消息");
        } else {
            for (Notice notice : notices) {
                // this.deleteById(notice.getNoticeId());
                this.removeById(notice.getNoticeId());
            }
        }
    }

    @Override
    public void read(JSONObject requestJson) throws Exception {
        // Notice notice = this.(requestJson.getString("noticeId"));
        Notice notice = this.getById(requestJson.getString("noticeId"));
        if (ComUtil.isEmpty(notice)) {
            throw new BusinessException("消息不存在");
        }
        // 已读
        notice.setIsRead(requestJson.getInteger("isRead"));
        this.updateById(notice);
    }
}
