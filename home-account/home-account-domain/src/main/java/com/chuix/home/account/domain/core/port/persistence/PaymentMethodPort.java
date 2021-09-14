package com.chuix.home.account.domain.core.port.persistence;

import com.chuix.home.account.domain.core.model.entity.PaymentMethod;

public interface PaymentMethodPort extends BasePort<PaymentMethod> {
	
	PaymentMethod findByAccountNumber(String accountNumber);
}
