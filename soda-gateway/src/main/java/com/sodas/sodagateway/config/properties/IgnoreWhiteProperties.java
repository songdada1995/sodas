package com.sodas.sodagateway.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * 放行白名单配置
 */
@Configuration
@RefreshScope
@ConfigurationProperties(prefix = "security.ignore")
public class IgnoreWhiteProperties {
    /**
     * 放行终端配置，网关不校验此处的终端
     */
    private List<String> clients = new ArrayList<>();

    public List<String> getClients()
    {
        return clients;
    }

    public void setClients(List<String> clients)
    {
        this.clients = clients;
    }
}
