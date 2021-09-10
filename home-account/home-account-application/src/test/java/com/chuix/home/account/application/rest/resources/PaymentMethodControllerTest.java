package com.chuix.home.account.application.rest.resources;

import static com.chuix.home.account.constants.ApplicationConstant.PATH_API_REST;
import static com.chuix.home.account.constants.ApplicationConstant.PATH_LIST;
import static com.chuix.home.account.constants.ApplicationConstant.PATH_PAYMENT_METHOD;
import static com.chuix.home.account.constants.ApplicationConstant.PATH_CREATE;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.chuix.home.account.application.dto.PaymentMethodDto;
import com.chuix.home.account.application.dto.mapper.PaymentMethodDtoMapper;
import com.chuix.home.account.application.rest.resources.PaymentMethodController;
import com.chuix.home.account.domain.api.PaymentMethodService;
import com.chuix.home.account.domain.entity.PaymentMethod;
import com.chuix.home.account.domain.exception.BusinessException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
	
	private ObjectMapper objectMapper;

	
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
		this.objectMapper = new ObjectMapper();
	}
	
	@Test
	void testShouldFetchAllPaymentMethos() throws Exception {
		
		when(this.service.getPaymentMethods()).thenReturn(this.pms);
		
		this.mockMvc.perform(
				MockMvcRequestBuilders
					.get(PATH_API_REST + PATH_PAYMENT_METHOD + PATH_LIST)
					.accept(MediaType.APPLICATION_JSON))
					.andDo(MockMvcResultHandlers.print())
					.andExpect(status().isOk())
					.andExpect(MockMvcResultMatchers.jsonPath("$.paymentMethods").exists())
					.andExpect(MockMvcResultMatchers.jsonPath("$.paymentMethods[*].id").isNotEmpty());
		
		this.ordered.verify(this.service).getPaymentMethods();
		this.ordered.verifyNoMoreInteractions();
	}
	
	@Test
	void testAddPaymentMethod_shouldBeCreated() throws Exception {
		when(this.service.addPaymentMethod(ArgumentMatchers.any(PaymentMethod.class)))
			.thenReturn(this.pms.get(0));
		
		PaymentMethodDto pmNew = PaymentMethodDto.builder()
				.accountNumber("123456789012345678901234")
				.name("Carles Huix")
				.balance(150.45d)
				.build();
				
		//String JsonBody = JSONValue.toJSONString(pmNew);
		
		this.mockMvc.perform(
					MockMvcRequestBuilders.post(PATH_API_REST + PATH_PAYMENT_METHOD + PATH_CREATE)
					.content(this.objectMapper.writeValueAsString(pmNew))
					.contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON))
					.andDo(MockMvcResultHandlers.print())
					.andExpect(status().isCreated())
					.andExpect(MockMvcResultMatchers.jsonPath("$.paymentMethod").exists());

		this.ordered.verify(this.service).addPaymentMethod(ArgumentMatchers.any(PaymentMethod.class));
		this.ordered.verifyNoMoreInteractions();
	}
	

}
