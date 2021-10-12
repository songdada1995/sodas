package com.sodas.sodacommon.security.exception;

import lombok.Getter;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

public class SodaAuth2Exception extends OAuth2Exception {

    @Getter
    private String errorCode;

    public SodaAuth2Exception(String msg) {
        super(msg);
    }

    public SodaAuth2Exception(String msg, String errorCode) {
        super(msg);
        this.errorCode = errorCode;
    }
}
