package com.sodas.sodaauth.handler;

import com.sodas.sodaapi.system.model.LoginUser;
import com.sodas.sodacommon.core.utils.ServletUtils;
import com.sodas.sodacommon.security.handler.AbstractAuthenticationSuccessEventHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 认证成功处理
 */
@Component
@Slf4j
public class AuthenticationSuccessEventHandler extends AbstractAuthenticationSuccessEventHandler {

    @Override
    public void handle(Authentication authentication) {
        HttpServletRequest request = ServletUtils.getRequest();

        String url = request.getRequestURI();

        if (authentication.getPrincipal() instanceof LoginUser) {
            LoginUser user = (LoginUser) authentication.getPrincipal();

            String username = user.getUsername();

            log.info("用户：{} 授权成功，url：{}", username, url);
        }
    }
}
