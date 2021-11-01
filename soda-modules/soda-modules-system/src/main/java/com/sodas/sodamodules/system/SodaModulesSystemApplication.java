package com.sodas.sodamodules.system;

import com.sodas.sodacommon.security.annotation.EnableCustomConfig;
import com.sodas.sodacommon.security.annotation.EnableSodaFeignClients;
import com.sodas.sodacommon.swagger.annotation.EnableCustomSwagger2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@Slf4j
@EnableCustomConfig
@EnableCustomSwagger2
@EnableSodaFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class SodaModulesSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(SodaModulesSystemApplication.class, args);
		log.info(">>>>> soda 系统模块启动成功 <<<<<");
    }

}
