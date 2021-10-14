package com.sodas.sodaapi.system;

import com.sodas.sodaapi.system.domain.SysUser;
import com.sodas.sodaapi.system.factory.RemoteUserFallbackFactory;
import com.sodas.sodaapi.system.model.UserInfo;
import com.sodas.sodacommon.core.constant.SecurityConstants;
import com.sodas.sodacommon.core.constant.ServiceNameConstants;
import com.sodas.sodacommon.core.domain.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(contextId = "remoteUserService", value = ServiceNameConstants.SYSTEM_SERVICE, fallbackFactory = RemoteUserFallbackFactory.class)
public interface RemoteUserService {
    /**
     * 通过用户名查询用户信息
     *
     * @param username 用户名
     * @param from 请求来源
     * @return 结果
     */
    @GetMapping("/user/info/{username}")
    public R<UserInfo> getUserInfo(@PathVariable("username") String username, @RequestHeader(SecurityConstants.FROM) String from);

    /**
     * 注册用户信息
     *
     * @param sysUser 用户信息
     * @param from 请求来源
     * @return 结果
     */
    @PostMapping("/user/register")
    public R<Boolean> registerUserInfo(@RequestBody SysUser sysUser, @RequestHeader(SecurityConstants.FROM) String from);
}
