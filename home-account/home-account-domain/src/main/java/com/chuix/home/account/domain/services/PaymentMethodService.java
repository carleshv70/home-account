package com.chuix.home.account.domain.services;

import java.util.List;

import com.chuix.home.account.domain.entity.PaymentMethod;
import com.chuix.home.account.domain.exception.BusinessException;

public interface PaymentMethodService {

	List<PaymentMethod> getPaymentMethods();

	PaymentMethod addPaymentMethod(PaymentMethod pm) throws BusinessException;
}
