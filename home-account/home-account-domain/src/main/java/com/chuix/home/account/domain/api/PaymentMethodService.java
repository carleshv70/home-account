package com.chuix.home.account.domain.api;

import java.util.List;

import com.chuix.home.account.domain.core.exception.BusinessException;
import com.chuix.home.account.domain.core.model.entity.PaymentMethod;

public interface PaymentMethodService {

	List<PaymentMethod> getPaymentMethods();

	PaymentMethod addPaymentMethod(PaymentMethod pm) throws BusinessException;
	
	PaymentMethod updatedPaymentMethod(Long id, PaymentMethod pm) throws BusinessException;
	
	void deletePaymentMethod(Long id)  throws BusinessException;
	
	PaymentMethod getPaymentMethod(Long id)  throws BusinessException;
}
