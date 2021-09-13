package com.chuix.home.account.infrastructure.persistence.adapter;

import static org.mockito.Mockito.calls;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;

import org.assertj.core.api.Assertions;
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

import com.chuix.home.account.domain.entity.PaymentMethod;
import com.chuix.home.account.domain.port.outcoming.PaymentMethodPersistencePort;
import com.chuix.home.account.infrastructure.persistence.entity.PaymentMethodEntity;
import com.chuix.home.account.infrastructure.persistence.mapper.PaymentMethodMapper;
import com.chuix.home.account.infrastructure.persistence.repository.PaymentMethodRepository;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@SpringJUnitConfig(value = PaymentMethodAdapterTestConfig.class )
class PaymentMethodAdapterTest {

	@Autowired
	private PaymentMethodPersistencePort port;
	
	@Autowired
	private PaymentMethodMapper mapper;
	
	@MockBean
	private PaymentMethodRepository pmDao;
	
	@Autowired
	@Qualifier("paymentMethodsEntity") 
	private List<PaymentMethodEntity> paymentMethodsEntity;

	private List<PaymentMethodEntity> pmsEntity;
	
	@Autowired
	@Qualifier("paymentMethods") 
	private List<PaymentMethod> paymentMethods;

	
	private List<PaymentMethod> pms;
	
	private InOrder ordered;
	

	@BeforeEach
	void setUp() throws Exception {
		this.pmsEntity = this.paymentMethodsEntity.stream()
				.map(pm -> pm.copy())
				.collect(Collectors.toList());
		
		this.pms = this.paymentMethods.stream()
				.map(pm -> pm.copy())
				.collect(Collectors.toList());
		
		this.ordered = inOrder(this.pmDao);
	}

	@Test
	void testFindAll_returnPMs() {
		
		when(this.pmDao.findAll())
			.thenReturn(this.pmsEntity);
		
		List<PaymentMethod> result = this.port.findAll();
		
		Assertions.assertThat(result.size()).isEqualTo(this.pms.size());
		Assertions.assertThat(result).usingRecursiveComparison().isEqualTo(pms);

		this.ordered.verify(this.pmDao, calls(1)).findAll();
		this.ordered.verifyNoMoreInteractions();
	}
	
	@Test
	void testSave_withNewPM_shouldReturnPMAdded() {
		
		PaymentMethodEntity pme = PaymentMethodEntity.builder()
				.accountNumber("44444444444444444444")
				.name("Carles")
				.balance(150d)
				.build();
		
		when(this.pmDao.save(ArgumentMatchers.any(PaymentMethodEntity.class)))
			.thenReturn(pme);
		
		PaymentMethod pmAdded = this.port.save( 
				this.paymentMethods.get(0)
		);
		
		Assertions.assertThat(pmAdded).usingRecursiveComparison().isEqualTo(this.mapper.mapToEntity(pme));
		this.ordered.verify(this.pmDao, calls(1)).save(ArgumentMatchers.any(PaymentMethodEntity.class));
		this.ordered.verifyNoMoreInteractions();
	}
	
	

}
