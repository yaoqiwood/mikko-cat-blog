package com.summer.cat.output.temp.service;

import com.summer.cat.output.temp.entity.Notice;
import meme.cat.basic.service.BaseService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

/**
* <p>
	* 消息通知表 服务类
	* </p>
*
* @author SummerCat
* @since 2020-04-21
*/
public interface INoticeService extends BaseService<Notice> {
	QueryWrapper<Notice> buildWrapper(Notice var);
}
