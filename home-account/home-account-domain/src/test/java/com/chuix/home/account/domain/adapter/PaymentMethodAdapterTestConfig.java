package com.chuix.home.account.domain.adapter;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;

import com.chuix.home.account.domain.mapper.PaymentMethodMapperImpl;
import com.chuix.home.account.persistence.entity.PaymentMethodEntity;

@Configuration
@Import({
	PaymentMethodAdapterImpl.class,
	PaymentMethodMapperImpl.class
})
public class PaymentMethodAdapterTestConfig {

	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public List<PaymentMethodEntity> paymentMethods(){
		
		return Arrays.asList(this.paymentMethod1(), this.paymentMethod2());
	}

	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public PaymentMethodEntity paymentMethod1() {
		return PaymentMethodEntity.builder()
				.accountNumber("111111111111111111111111111111")
				.name("Carles Huix Vidal")
				.balance(900d).build();
	}

	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public PaymentMethodEntity paymentMethod2() {
		return PaymentMethodEntity.builder()
				.accountNumber("22222222222222222222222222222")
				.name("Carles Huix Vidal")
				.balance(800d).build();
	}
	
}
