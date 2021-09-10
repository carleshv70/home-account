package com.chuix.home.account.domain.port;

import com.chuix.home.account.domain.entity.PaymentMethod;

public interface PaymentMethodPort extends Port<PaymentMethod> {
	
	PaymentMethod findByAccountNumber(String accountNumber);
}
