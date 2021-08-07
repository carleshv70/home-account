package com.chuix.home.account.domain.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chuix.home.account.domain.entity.PaymentMethodEntity;
import com.chuix.home.account.domain.mapper.PaymentMethodMapper;
import com.chuix.home.account.persistence.dao.PaymentMethodDao;

@Service
public class PaymentMethodService {
	
	@Autowired
	private PaymentMethodMapper mapper;
	
	@Autowired
	private PaymentMethodDao pmDao;

	public List<PaymentMethodEntity> getPaymentMethods() {
		List<PaymentMethodEntity> paymentMethods = new ArrayList<>();
		PaymentMethodEntity pm = new PaymentMethodEntity();
		pm.setAccountNumber("01234567890123456789012");
		pm.setName("Carles");
		pm.setBalance(1500d);
		paymentMethods.add(pm);
		return paymentMethods;
	}
	
	public PaymentMethodEntity addPaymentMethod(PaymentMethodEntity pm) {
		
		try {
			PaymentMethodEntity pmDB = this.mapper.mapToEntity( this.pmDao.findByAccountNumber(pm.getAccountNumber()));			
		}
		catch( jpaEx)

		
		if (pmDB != null) {
			throw new 
		}
		
		return null;
		
	}
}
