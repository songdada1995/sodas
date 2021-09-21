package com.sodas.sodagateway.handler;

import com.sodas.sodacommon.core.exception.CaptchaException;
import com.sodas.sodacommon.core.web.domain.AjaxResult;
import com.sodas.sodagateway.service.ValidateCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.io.IOException;

/**
 * 验证码获取
 */
@Component
public class ValidateCodeHandler implements HandlerFunction<ServerResponse> {

    private ValidateCodeService validateCodeService;

    @Autowired
    public ValidateCodeHandler(ValidateCodeService validateCodeService) {
        this.validateCodeService = validateCodeService;
    }

    @Override
    public Mono<ServerResponse> handle(ServerRequest serverRequest) {
        AjaxResult ajax;
        try {
            ajax = validateCodeService.createCapcha();
        } catch (CaptchaException | IOException e) {
            return Mono.error(e);
        }
        return ServerResponse.status(HttpStatus.OK).body(BodyInserters.fromValue(ajax));
    }

}
