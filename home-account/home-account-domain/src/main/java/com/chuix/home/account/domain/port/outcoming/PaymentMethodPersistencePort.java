package com.chuix.home.account.domain.port.outcoming;

import com.chuix.home.account.domain.entity.PaymentMethod;

public interface PaymentMethodPersistencePort extends PersistencePort<PaymentMethod> {
	
	PaymentMethod findByAccountNumber(String accountNumber);
}
