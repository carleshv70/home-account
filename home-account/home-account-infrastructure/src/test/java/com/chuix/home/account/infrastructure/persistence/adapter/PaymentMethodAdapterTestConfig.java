package com.chuix.home.account.infrastructure.persistence.adapter;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;

import com.chuix.home.account.domain.core.model.entity.PaymentMethod;
import com.chuix.home.account.infrastructure.persistence.entity.PaymentMethodEntity;
import com.chuix.home.account.infrastructure.persistence.mapper.PaymentMethodMapperImpl;

@Configuration
@Import({
	PaymentMethodAdapter.class,
	PaymentMethodMapperImpl.class
})
public class PaymentMethodAdapterTestConfig {

	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public List<PaymentMethodEntity> paymentMethodsEntity(){
		
		return Arrays.asList(this.paymentMethodEntity1(), this.paymentMethodEntity2());
	}

	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public PaymentMethodEntity paymentMethodEntity1() {
		return PaymentMethodEntity.builder()
				.accountNumber("111111111111111111111111111111")
				.name("Carles Huix Vidal")
				.balance(900d).build();
	}

	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public PaymentMethodEntity paymentMethodEntity2() {
		return PaymentMethodEntity.builder()
				.accountNumber("22222222222222222222222222222")
				.name("Carles Huix Vidal")
				.balance(800d).build();
	}
	
	
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
