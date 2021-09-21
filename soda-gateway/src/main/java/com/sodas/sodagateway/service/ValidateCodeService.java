package com.sodas.sodagateway.service;

import com.sodas.sodacommon.core.exception.CaptchaException;
import com.sodas.sodacommon.core.web.domain.AjaxResult;

import java.io.IOException;

public interface ValidateCodeService {
    /**
     * 生成验证码
     */
    public AjaxResult createCapcha() throws IOException, CaptchaException;

    /**
     * 校验验证码
     */
    public void checkCapcha(String key, String value) throws CaptchaException;
}
