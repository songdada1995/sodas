package com.sodas.sodaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SodaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SodaServerApplication.class, args);
	}

}
