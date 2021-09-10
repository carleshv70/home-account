package com.chuix.home.account.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {
	
	@Value("${server.address}")
	private String host;

	@Value("${server.port}")
	private String port;


	@Bean
	public Enviroment getEnviroment() {
		
			
		return Enviroment.builder().host(host).port(port).build();
	}
}
