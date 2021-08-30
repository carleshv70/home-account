package com.chuix.home.account.domain.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;

import com.chuix.home.account.domain.entity.PaymentMethod;

@Configuration
@Import(value = { PaymentMethod.class, PaymentMethodServiceImpl.class })
public class PaymentMethodServiceTestConfig {

	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public List<PaymentMethod> paymentMethods(){
		
		return Arrays.asList(this.paymentMethod1(), this.paymentMethod2());
	}

	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public PaymentMethod paymentMethod1() {
		return PaymentMethod.builder()
				.accountNumber("111111111111111111111111111111")
				.name("Carles Huix Vidal")
				.balance(900d).build();
	}

	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public PaymentMethod paymentMethod2() {
		return PaymentMethod.builder()
				.accountNumber("22222222222222222222222222222")
				.name("Carles Huix Vidal")
				.balance(800d).build();
	}

}
