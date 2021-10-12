package com.sodas.sodacommon.security.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sodas.sodacommon.security.component.SodaAuth2ExceptionSerializer;
import org.springframework.http.HttpStatus;

@JsonSerialize(using = SodaAuth2ExceptionSerializer.class)
public class UnauthorizedException extends SodaAuth2Exception {

    public UnauthorizedException(String msg, Throwable t) {
        super(msg);
    }

    @Override
    public String getOAuth2ErrorCode() {
        return "unauthorized";
    }

    @Override
    public int getHttpErrorCode() {
        return HttpStatus.UNAUTHORIZED.value();
    }
}
