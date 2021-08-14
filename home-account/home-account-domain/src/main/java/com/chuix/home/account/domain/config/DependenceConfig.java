package com.chuix.home.account.domain.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.chuix.home.account.domain.mapper.PaymentMethodMapper;
import com.chuix.home.account.domain.mapper.PaymentMethodMapperImpl;

@Configuration
@EnableJpaRepositories(basePackages = "com.chuix.home.account.persistence")
@EntityScan(basePackages = {
		"com.chuix.home.account.persistence.entity"
})
public class DependenceConfig {
	
//	@Bean
//	public PaymentMethodMapper getPaymentMethodMapper() {
//		return new PaymentMethodMapperImpl();
//	}

}
