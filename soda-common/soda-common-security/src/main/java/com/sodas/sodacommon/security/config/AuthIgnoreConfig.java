package com.sodas.sodacommon.security.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * 忽略服务间认证
 */
@Configuration
@ConfigurationProperties(prefix = "security.oauth2.ignore")
public class AuthIgnoreConfig {

    private List<String> urls = new ArrayList<>();

    public List<String> getUrls()
    {
        return urls;
    }

    public void setUrls(List<String> urls)
    {
        this.urls = urls;
    }

}
