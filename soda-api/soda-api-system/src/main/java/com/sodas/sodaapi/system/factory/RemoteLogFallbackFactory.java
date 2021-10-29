package com.sodas.sodaapi.system.factory;

import com.sodas.sodaapi.system.RemoteLogService;
import com.sodas.sodaapi.system.domain.SysLogininfor;
import com.sodas.sodaapi.system.domain.SysOperLog;
import com.sodas.sodacommon.core.domain.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * 日志服务降级处理
 */
@Slf4j
@Component
public class RemoteLogFallbackFactory implements FallbackFactory<RemoteLogService> {

    @Override
    public RemoteLogService create(Throwable throwable) {
        log.error("日志服务调用失败:{}", throwable.getMessage());
        return new RemoteLogService() {
            @Override
            public R<Boolean> saveLog(SysOperLog sysOperLog) {
                return null;
            }

            @Override
            public R<Boolean> saveLogininfor(String username, String status, String message) {
                return null;
            }
        };
    }
}
