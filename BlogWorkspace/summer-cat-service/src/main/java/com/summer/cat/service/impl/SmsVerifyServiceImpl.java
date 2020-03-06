package com.summer.cat.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.summer.cat.base.BusinessException;
import com.summer.cat.base.PublicResultConstant;
import com.summer.cat.base.SmsSendResponse;
import com.summer.cat.entity.SmsVerify;
import com.summer.cat.mapper.SmsVerifyMapper;
import com.summer.cat.service.ISmsVerifyService;
import com.summer.cat.util.ComUtil;
import com.summer.cat.util.GenerationSequenceUtil;
import com.summer.cat.util.SmsSendUtil;
import com.summer.cat.util.StringUtil;

/**
 * <p>
 * 验证码发送记录 服务实现类
 * </p>
 *
 * @author liugh123
 * @since 2018-06-25
 */
@Service
public class SmsVerifyServiceImpl extends ServiceImpl<SmsVerifyMapper, SmsVerify> implements ISmsVerifyService {

    @Override
    public List<SmsVerify> getByMobileAndCaptchaAndType(String mobile, String captcha, int type) {
        QueryWrapper<SmsVerify> smsQuery = new QueryWrapper<>();
        // smsQuery.where("mobile={0} and sms_verify={1} and sms_type = {2}", mobile,
        // captcha, type);
        Map<String, String> compareMap = new HashMap<>();
        compareMap.put("mobile", mobile);
        compareMap.put("sms_verify", captcha);
        compareMap.put("sms_type", String.valueOf(type));
        smsQuery.allEq(compareMap);
        // smsQuery.orderBy("create_time", false);
        smsQuery.orderByDesc("create_time");
        return this.list(smsQuery);
    }

    @Override
    public SmsVerify addAndGetMobileAndCaptcha(String smsType, String mobile) throws Exception {
        if (!StringUtil.checkMobileNumber(mobile)) {
            throw new BusinessException(PublicResultConstant.MOBILE_ERROR);
        }
        String randNum = GenerationSequenceUtil.getRandNum(4);
        SmsSendResponse smsSendResponse = SmsSendUtil.sendMessage(mobile, "校验码: " + randNum + "。您正在进行"
                + SmsSendUtil.SMSType.getSMSType(smsType).toString() + "的操作,请在5分钟内完成验证，注意保密哦！");
        SmsVerify smsVerify = SmsVerify.builder().smsId(smsSendResponse.getMsgId()).mobile(mobile).smsVerify(randNum)
                .smsType(SmsSendUtil.SMSType.getType(smsType)).createTime(System.currentTimeMillis()).build();
        this.save(smsVerify);
        return smsVerify;
    }

    @Override
    public void captchaCheck(String mobile, String smsType, String captcha) throws Exception {
        if (!StringUtil.checkMobileNumber(mobile)) {
            throw new BusinessException(PublicResultConstant.MOBILE_ERROR);
        }
        List<SmsVerify> smsVerifies = this.getByMobileAndCaptchaAndType(mobile, captcha,
                SmsSendUtil.SMSType.getType(smsType));
        if (ComUtil.isEmpty(smsVerifies)) {
            throw new BusinessException(PublicResultConstant.VERIFY_PARAM_ERROR);
        }
        if (SmsSendUtil.isCaptchaPassTime(smsVerifies.get(0).getCreateTime())) {
            throw new BusinessException(PublicResultConstant.VERIFY_PARAM_PASS);
        }
    }
}
