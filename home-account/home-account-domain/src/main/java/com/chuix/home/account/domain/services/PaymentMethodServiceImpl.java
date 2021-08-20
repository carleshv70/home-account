package com.chuix.home.account.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chuix.home.account.domain.adapter.PaymentMethodAdapter;
import com.chuix.home.account.domain.entity.PaymentMethod;
import com.chuix.home.account.domain.exception.BusinessException;
import com.chuix.home.account.domain.exception.BusinessExceptionEnum;

@Service
public class PaymentMethodServiceImpl implements PaymentMethodService {

	@Autowired
	private PaymentMethodAdapter port;

	public List<PaymentMethod> getPaymentMethods() {

		return this.port.findAll();
	}

	public PaymentMethod addPaymentMethod(PaymentMethod pm) throws BusinessException {

		// Check if exist
		if (getPaymentMethodByAccountNumber(pm.getAccountNumber()) != null) {

			throw new BusinessException(BusinessExceptionEnum.BE0001);
		}
		return this.save(pm);
	}
	
	@Override
	public PaymentMethod updatedPaymentMethod(Long id, PaymentMethod pm) throws BusinessException {

		PaymentMethod pmDB = this.port.findById(id);

		// check if is null
		if (pmDB == null) {
			throw new BusinessException(BusinessExceptionEnum.BE0002);
		}

		if (!pm.getId().equals(id)) {
			throw new BusinessException(BusinessExceptionEnum.BE0003);
		}
		return this.port.save(pm);
	}

	@Override
	public void updatedPaymentMethod(Long id) {
		// TODO Auto-generated method stub

	}
	

	private PaymentMethod getPaymentMethodByAccountNumber(String accountNumber) throws BusinessException {

		PaymentMethod pm;

		try {
			pm = this.port.findByAccountNumber(accountNumber);
		} catch (Exception ex) {
			throw new BusinessException(BusinessExceptionEnum.AE0002, ex, ex.getMessage());
		}
		return pm;
	}

	private PaymentMethod save(PaymentMethod pm) throws BusinessException {
		PaymentMethod pmSaved;
		try {
			pmSaved = this.port.save(pm);
		} catch (Exception ex) {
			throw new BusinessException(BusinessExceptionEnum.AE0001, ex, ex.getMessage());
		}
		return pmSaved;

	}



}
