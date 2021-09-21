package com.sodas.sodagateway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@Slf4j
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class SodaGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SodaGatewayApplication.class, args);
		log.info(">>>>> soda 网关模块启动成功 <<<<<");
	}

}
