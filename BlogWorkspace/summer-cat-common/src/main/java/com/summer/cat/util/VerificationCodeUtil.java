package com.summer.cat.util;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.ShearCaptcha;

public class VerificationCodeUtil {
    /**
     * 制造验证码对象
     * @return
     */
    public static ShearCaptcha createShearCaptcha() {
        ShearCaptcha shearCaptcha = CaptchaUtil.createShearCaptcha(200, 100, 4, 4);
        return shearCaptcha;
    }

    /**
     * 返回四字验证码字符串
     * @return
     */
    public static String createShearCaptchaStringCode() {
        return createShearCaptcha().getCode();
    }

}
