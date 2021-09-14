package com.chuix.home.account.application.rest.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.chuix.home.account.application.dto.PaymentMethodDto;
import com.chuix.home.account.application.dto.mapper.PaymentMethodDtoMapperImpl;
import com.chuix.home.account.config.Enviroment;
import com.chuix.home.account.domain.core.model.entity.PaymentMethod;


@Configuration
@Import(PaymentMethodDtoMapperImpl.class)
@ComponentScan(basePackages = {
			"com.chuix.home.account"
		})
@EnableWebMvc
public class PaymentMethodControllerTestConfig {

	@Value("${server.address}")
	private String host;

	@Value("${server.port}")
	private String port;
	
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
	
	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public List<PaymentMethodDto> paymentMethodsDto(){
		
		return Arrays.asList(this.paymentMethodDto1(), this.paymentMethodDto2());
	}

	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public PaymentMethodDto paymentMethodDto1() {
		return PaymentMethodDto.builder()
				.accountNumber("111111111111111111111111111111")
				.name("Carles Huix Vidal")
				.balance(900d).build();
	}

	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public PaymentMethodDto paymentMethodDto2() {
		return PaymentMethodDto.builder()
				.accountNumber("22222222222222222222222222222")
				.name("Carles Huix Vidal")
				.balance(800d).build();
	}
	
}
