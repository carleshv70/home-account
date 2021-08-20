package com.chuix.home.account.domain.adapter;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chuix.home.account.domain.entity.PaymentMethod;
import com.chuix.home.account.domain.mapper.PaymentMethodMapper;
import com.chuix.home.account.persistence.dao.PaymentMethodDao;
import com.chuix.home.account.persistence.entity.PaymentMethodEntity;

@Component
public class PaymentMethodAdapterImpl implements PaymentMethodAdapter {

	@Autowired
	private PaymentMethodMapper mapper;

	@Autowired
	private PaymentMethodDao pmDao;

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
		PaymentMethodEntity pmJPA = null;
	
		if( pm.getId() != null ) {
			Optional<PaymentMethodEntity> optPmJPA = this.pmDao.findById(pm.getId()); 
			
			if (optPmJPA.isPresent()) {
				
				pmJPA = optPmJPA.get();

				pmJPA.setAccountNumber(pm.getAccountNumber());
				pmJPA.setBalance(pm.getBalance());
				pmJPA.setDatePreviousBalance(pm.getDatePreviousBalance());
				pmJPA.setName(pm.getName());
				pmJPA.setObservations(pm.getObservations());
				pmJPA.setPreviousBalance(pm.getPreviousBalance());
			}
		}
		
		if (pmJPA == null) {

			pmJPA = PaymentMethodEntity.builder()
				.accountNumber(pm.getAccountNumber())
				.balance(pm.getBalance())
				.datePreviousBalance(pm.getDatePreviousBalance())
				.name(pm.getName())
				.observations(pm.getObservations())
				.previousBalance(pm.getPreviousBalance())
				.build();
			
		}
		
		PaymentMethodEntity pmJPASaved = this.pmDao.save(pmJPA);
		
		return this.mapper.mapToEntity(pmJPASaved);
	}

	@Override
	public PaymentMethod findById(Long id) {
		Optional< PaymentMethodEntity > optPmDB = this.pmDao.findById(id);
		
		return optPmDB.isPresent() ? this.mapper.mapToEntity(optPmDB.get()) : null;
	}

}
