package com.sodas.sodagateway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class SodaGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SodaGatewayApplication.class, args);
		log.info(">>>>> 网关模块启动成功 <<<<<");
	}

}
