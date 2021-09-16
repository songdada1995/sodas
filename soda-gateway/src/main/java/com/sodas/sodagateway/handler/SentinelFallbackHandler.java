package com.sodas.sodagateway.handler;

import com.sodas.sodacommon.core.utils.ServletUtils;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebExceptionHandler;
import reactor.core.publisher.Mono;

public class SentinelFallbackHandler implements WebExceptionHandler {
    @Override
    public Mono<Void> handle(ServerWebExchange serverWebExchange, Throwable throwable) {
        return null;
    }

    private Mono<Void> writeResponse(ServerResponse response, ServerWebExchange exchange) {
        return ServletUtils.webFluxResponseWriter(exchange.getResponse(), "请求超过最大数，请稍后再试");
    }

}
