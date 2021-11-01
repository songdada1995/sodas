package com.sodas.sodaapi.system;

import com.sodas.sodaapi.system.factory.RemoteUserFallbackFactory;
import com.sodas.sodaapi.system.model.UserInfo;
import com.sodas.sodacommon.core.constant.ServiceNameConstants;
import com.sodas.sodacommon.core.domain.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(contextId = "remoteUserService", value = ServiceNameConstants.SYSTEM_SERVICE, fallbackFactory = RemoteUserFallbackFactory.class)
public interface RemoteUserService {
    /**
     * 通过用户名查询用户信息
     *
     * @param username 用户名
     * @return 结果
     */
    @GetMapping("/user/info/{username}")
    public R<UserInfo> getUserInfo(@PathVariable("username") String username);
}
