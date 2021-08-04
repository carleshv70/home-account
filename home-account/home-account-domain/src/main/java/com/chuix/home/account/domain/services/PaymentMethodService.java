package com.chuix.home.account.domain.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.chuix.home.account.domain.entity.PaymentMethodEntity;

@Service
public class PaymentMethodService {

	public List<PaymentMethodEntity> getPaymentMethods() {
		List<PaymentMethodEntity> paymentMethods = new ArrayList<>();
		PaymentMethodEntity pm = new PaymentMethodEntity();
		pm.setAccountNumber("01234567890123456789012");
		pm.setName("Carles");
		pm.setBalance(1500d);
		paymentMethods.add(pm);
		return paymentMethods;
	}
}
