package com.chuix.home.account.controllers.api;

import static com.chuix.home.account.constants.ApplicationConstant.PATH_API_REST;
import static com.chuix.home.account.constants.ApplicationConstant.PATH_LIST;
import static com.chuix.home.account.constants.ApplicationConstant.PATH_PAYMENT_METHOD;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;

import com.chuix.home.account.domain.entity.PaymentMethod;
import com.chuix.home.account.domain.services.PaymentMethodService;
import com.chuix.home.account.dto.PaymentMethodDto;
import com.chuix.home.account.dto.mapper.PaymentMethodDtoMapper;

@WebMvcTest(controllers = PaymentMethodController.class)
@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@SpringJUnitConfig(value = PaymentMethodControllerTestConfig.class )
@AutoConfigureMockMvc(addFilters = false)
class PaymentMethodControllerTest {
	
//	@Autowired
//	private PaymentMethodController controller;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private PaymentMethodDtoMapper mapper;
	
	@Autowired
	@Qualifier("paymentMethodsDto")
	private List<PaymentMethodDto> paymentMethodsDto;
	
	private List<PaymentMethodDto> pmsDto;

	@Autowired
	@Qualifier("paymentMethods")
	private List<PaymentMethod> paymentMethods;

	private List<PaymentMethod> pms;
	
	private InOrder ordered;

	
	@MockBean
	private PaymentMethodService service;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		
		this.pms = this.paymentMethods.stream()
				.map(pm -> pm.copy())
				.collect(Collectors.toList());
		
		this.pmsDto = this.paymentMethodsDto.stream()
				.map(pm -> pm.copy())
				.collect(Collectors.toList());
		
		this.ordered = inOrder(this.service);
	}
	
	@Test
	void testShouldFetchAllPaymentMethos() throws Exception {
		
		when(this.service.getPaymentMethods()).thenReturn(this.pms);
		
		this.mockMvc.perform(get(PATH_API_REST + PATH_PAYMENT_METHOD + PATH_LIST))
			.andExpect(status().isOk());
		
		
	}
	

}
