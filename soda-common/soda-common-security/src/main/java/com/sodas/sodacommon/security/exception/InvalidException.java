package com.sodas.sodacommon.security.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sodas.sodacommon.security.component.SodaAuth2ExceptionSerializer;
import org.springframework.http.HttpStatus;

@JsonSerialize(using = SodaAuth2ExceptionSerializer.class)
public class InvalidException extends SodaAuth2Exception {

    public InvalidException(String msg, Throwable t) {
        super(msg);
    }

    @Override
    public String getOAuth2ErrorCode() {
        return "invalid_exception";
    }

    @Override
    public int getHttpErrorCode() {
        return HttpStatus.FORBIDDEN.value();
    }

}
