package com.summer.cat.output.temp.service.impl;

import com.summer.cat.output.temp.entity.Notice;
import com.summer.cat.output.temp.dao.NoticeMapper;
import com.summer.cat.output.temp.service.INoticeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;

/**
* <p>
	* 消息通知表 服务实现类
	* </p>
*
* @author SummerCat
* @since 2020-04-21
*/
@Service
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice> implements INoticeService {
	public QueryWrapper<Notice> buildWrapper(Notice var) {
		return null;
	}
}

