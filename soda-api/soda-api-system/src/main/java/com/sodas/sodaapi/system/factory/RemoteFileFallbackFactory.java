package com.sodas.sodaapi.system.factory;

import com.sodas.sodaapi.system.RemoteFileService;
import com.sodas.sodaapi.system.domain.SysFile;
import com.sodas.sodacommon.core.domain.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件服务降级处理
 */
@Slf4j
@Component
public class RemoteFileFallbackFactory implements FallbackFactory<RemoteFileService> {

    @Override
    public RemoteFileService create(Throwable cause) {
        log.error("文件服务调用失败:{}", cause.getMessage());
        return new RemoteFileService() {
            @Override
            public R<SysFile> upload(MultipartFile file) {
                return R.fail("上传文件失败:" + cause.getMessage());
            }
        };
    }
}
