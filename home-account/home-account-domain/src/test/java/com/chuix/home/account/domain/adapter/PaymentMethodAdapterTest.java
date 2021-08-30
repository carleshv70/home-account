package com.chuix.home.account.domain.adapter;

import static org.mockito.Mockito.calls;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.chuix.home.account.domain.entity.PaymentMethod;
import com.chuix.home.account.domain.mapper.PaymentMethodMapper;
import com.chuix.home.account.persistence.dao.PaymentMethodDao;
import com.chuix.home.account.persistence.entity.PaymentMethodEntity;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@SpringJUnitConfig(value = PaymentMethodAdapterTestConfig.class )
class PaymentMethodAdapterTest {

	@Autowired
	private PaymentMethodAdapter port;
	
	@Autowired
	private PaymentMethodMapper mapper;
	
	@MockBean
	private PaymentMethodDao pmDao;
	
	@Autowired
	@Qualifier("paymentMethods") 
	private List<PaymentMethodEntity> paymentMethodsEntity;

	private List<PaymentMethodEntity> pmsEntity;
	
	private List<PaymentMethod> pms;
	
	private InOrder ordered;
	

	@BeforeEach
	void setUp() throws Exception {
		this.pmsEntity = this.paymentMethodsEntity.stream()
				.map(pm -> pm.copy())
				.collect(Collectors.toList());
		
		this.pms = this.pmsEntity.stream()
				.map(this.mapper::mapToEntity)
				.collect(Collectors.toList());
		
		this.ordered = inOrder(this.pmDao);
	}

	@Test
	void findAll_returnPMs() {
		
		when(this.pmDao.findAll())
			.thenReturn(this.pmsEntity);
		
		List<PaymentMethod> result = this.port.findAll();
		
		Assertions.assertThat(result.size()).isEqualTo(this.pms.size());
		Assertions.assertThat(result).usingRecursiveComparison().isEqualTo(pms);
		
		this.ordered.verify(this.pmDao, calls(1)).findAll();
		this.ordered.verifyNoMoreInteractions();
	}

}
