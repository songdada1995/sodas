package com.sodas.sodaapi.system.factory;

import com.sodas.sodaapi.system.RemoteUserService;
import com.sodas.sodaapi.system.domain.SysUser;
import com.sodas.sodaapi.system.model.UserInfo;
import com.sodas.sodacommon.core.domain.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * 用户服务降级处理
 */
@Slf4j
@Component
public class RemoteUserFallbackFactory implements FallbackFactory<RemoteUserService> {

    @Override
    public RemoteUserService create(Throwable throwable) {
        log.error("用户服务调用失败:{}", throwable.getMessage());
        return new RemoteUserService() {
            @Override
            public R<UserInfo> getUserInfo(String username, String source) {
                return R.fail("获取用户失败:" + throwable.getMessage());
            }

            @Override
            public R<Boolean> registerUserInfo(SysUser sysUser, String source) {
                return R.fail("注册用户失败:" + throwable.getMessage());
            }
        };
    }
}
