package com.chuix.home.account.infrastructure.persistence.adapter;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chuix.home.account.domain.entity.PaymentMethod;
import com.chuix.home.account.domain.port.outcoming.PaymentMethodPersistencePort;
import com.chuix.home.account.infrastructure.persistence.entity.PaymentMethodEntity;
import com.chuix.home.account.infrastructure.persistence.mapper.PaymentMethodMapper;
import com.chuix.home.account.infrastructure.persistence.repository.PaymentMethodRepository;

@Component
public class PaymentMethodAdapterImpl implements PaymentMethodPersistencePort {

	@Autowired
	private PaymentMethodMapper mapper;

	@Autowired
	private PaymentMethodRepository pmDao;

	@Override
	public List<PaymentMethod> findAll() {

		return this.pmDao.findAll().stream().map(this.mapper::mapToEntity).collect(Collectors.toList());
	}

	@Override
	public PaymentMethod findByAccountNumber(String accountNumber) {

		return this.mapper.mapToEntity(this.pmDao.findByAccountNumber(accountNumber));
	}

	@Override
	public PaymentMethod save(PaymentMethod pm) {
		PaymentMethodEntity pmJpaDB = null;
	
		if( pm.getId() != null ) {
			Optional<PaymentMethodEntity> optPmJPA = this.pmDao.findById(pm.getId()); 
			
			if (optPmJPA.isPresent()) {
				
				pmJpaDB = optPmJPA.get();
				this.mapper.update(pmJpaDB, pm);
			}
		}
		
		if (pmJpaDB == null) {

			pmJpaDB = this.mapper.mapToJPA(pm);
		}
		
		PaymentMethodEntity pmJPASaved = this.pmDao.save(pmJpaDB);
		
		return this.mapper.mapToEntity(pmJPASaved);
	}

	@Override
	public PaymentMethod findById(Long id) {
		Optional< PaymentMethodEntity > optPmDB = this.pmDao.findById(id);
		
		return optPmDB.isPresent() ? this.mapper.mapToEntity(optPmDB.get()) : null;
	}

}
