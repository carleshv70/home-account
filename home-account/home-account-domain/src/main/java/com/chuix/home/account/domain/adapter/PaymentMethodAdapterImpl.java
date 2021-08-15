package com.chuix.home.account.domain.adapter;

import java.util.List;
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

	public List<PaymentMethod> findAll() {

		return this.pmDao.findAll().stream().map(this.mapper::mapToEntity).collect(Collectors.toList());
	}

	public PaymentMethod findByAccountNumber(String accountNumber) {

		return this.mapper.mapToEntity(this.pmDao.findByAccountNumber(accountNumber));
	}

	public PaymentMethod save(PaymentMethod paymentMethod) {
		PaymentMethodEntity pmJPA = this.mapper.mapToJPA(paymentMethod);
		PaymentMethodEntity pmJPASaved = this.pmDao.save(pmJPA);
		
		return this.mapper.mapToEntity(pmJPASaved);

	}

}
