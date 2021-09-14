package com.chuix.home.account.domain.services;


import static org.mockito.Mockito.calls;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.chuix.home.account.domain.api.PaymentMethodService;
import com.chuix.home.account.domain.core.exception.BusinessException;
import com.chuix.home.account.domain.core.exception.BusinessExceptionEnum;
import com.chuix.home.account.domain.core.model.entity.PaymentMethod;
import com.chuix.home.account.domain.core.port.persistence.PaymentMethodPort;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@SpringJUnitConfig(value = PaymentMethodServiceTestConfig.class )
class PaymentMethodServiceTest {
	
	@Autowired
	private PaymentMethodService service;
	
	@MockBean
	private PaymentMethodPort port;
	
	@Autowired
	@Qualifier("paymentMethods") 
	private List<PaymentMethod> paymentMethods;

	private List<PaymentMethod> pms;
	
	private InOrder ordered;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		this.pms = this.paymentMethods.stream()
					.map(pm -> pm.copy())
					.collect(Collectors.toList());
		
		 this.ordered = inOrder(this.port);
	}

	@Test
	void testGetPaymentMethod_returnOK( ) {

		
		when(this.port.findAll()).thenReturn(pms);
		
		List<PaymentMethod> result = this.service.getPaymentMethods();
		
		ordered.verify(this.port).findAll();
		Assertions.assertThat(result.size()).isEqualTo(this.paymentMethods.size());
	}

	@Test
	void testAddPaymentMethod_withExistPM_shouldReturnException() {
		
		String descError = BusinessExceptionEnum.BE0001.getDescription();
		
		PaymentMethod pm = PaymentMethod.builder()
				.balance(100d)
				.accountNumber("111111111111111111111")
				.build();
		
		when(this.port.findByAccountNumber(ArgumentMatchers.anyString()))
			.thenReturn(this.pms.get(0));

		Assertions.assertThatThrownBy(() -> this.service.addPaymentMethod(pm))
			.isInstanceOf(BusinessException.class)
			.hasMessageContaining(descError);

		
		// check that the method isn't called
		this.ordered.verify(this.port,calls(1))
			.findByAccountNumber(ArgumentMatchers.anyString());
		this.ordered.verifyNoMoreInteractions();
	}
	
	@Test
	void testAddPaymentMethod_withValidPM_shouldReturnNewPM() throws BusinessException {
		
		PaymentMethod pm = this.pms.get(0);
		
		when(this.port.findByAccountNumber(ArgumentMatchers.anyString()))
			.thenReturn(null);
		when(this.port.save(ArgumentMatchers.any(PaymentMethod.class)))
			.thenReturn(pm);

		PaymentMethod result = this.service.addPaymentMethod(pm);
		
		Assertions.assertThat(result).isEqualTo(pm);

		
		// check that the method isn't called
		this.ordered.verify(this.port,calls(1))
			.findByAccountNumber(ArgumentMatchers.anyString());
		this.ordered.verify(this.port, calls(1)).save(ArgumentMatchers.any(PaymentMethod.class));
		this.ordered.verifyNoMoreInteractions();
	}
	
	
	
}
