package com.chuix.home.account.domain.adapter;

import java.util.List;

import com.chuix.home.account.domain.entity.PaymentMethod;

public interface PaymentMethodAdapter {
	
	List<PaymentMethod> findAll();
	
	PaymentMethod findByAccountNumber(String accountNumber);
	
	PaymentMethod save(PaymentMethod paymentMethod);
}
