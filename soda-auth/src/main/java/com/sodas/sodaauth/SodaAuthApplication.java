package com.sodas.sodaauth;

import com.sodas.sodacommon.security.annotation.EnableSodaFeignClients;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@EnableSodaFeignClients
@SpringBootApplication
public class SodaAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(SodaAuthApplication.class, args);
		log.info(">>>>> soda 认证授权中心启动成功 <<<<<");
	}

}
