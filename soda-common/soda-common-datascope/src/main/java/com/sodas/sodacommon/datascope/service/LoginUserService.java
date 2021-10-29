package com.sodas.sodacommon.datascope.service;

import com.sodas.sodaapi.system.RemoteUserService;
import com.sodas.sodaapi.system.model.UserInfo;
import com.sodas.sodacommon.core.domain.R;
import com.sodas.sodacommon.core.utils.StringUtils;
import com.sodas.sodacommon.security.utils.SecurityUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LoginUserService {

    @Autowired
    private RemoteUserService remoteUserService;

    public UserInfo getLoginUser() {
        String username = SecurityUtils.getUsername();
        R<UserInfo> userResult = remoteUserService.getUserInfo(username);
        if (StringUtils.isNull(userResult) || StringUtils.isNull(userResult.getData())) {
            log.info("数据权限范围查询用户：{} 不存在.", username);
            return null;
        }
        return userResult.getData();
    }

}
