package com.chuix.home.account.domain.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chuix.home.account.domain.entity.PaymentMethod;
import com.chuix.home.account.domain.exception.BusinessException;
import com.chuix.home.account.domain.exception.BusinessExceptionEnum;
import com.chuix.home.account.domain.mapper.PaymentMethodMapper;
import com.chuix.home.account.persistence.dao.PaymentMethodDao;

@Service
public class PaymentMethodService {

	@Autowired
	private PaymentMethodMapper mapper;

	@Autowired
	private PaymentMethodDao pmDao;

	public List<PaymentMethod> getPaymentMethods() {
		List<PaymentMethod> paymentMethods = new ArrayList<>();
		PaymentMethod pm = new PaymentMethod();
		pm.setAccountNumber("01234567890123456789012");
		pm.setName("Carles");
		pm.setBalance(1500d);
		paymentMethods.add(pm);
		return paymentMethods;
	}

	public PaymentMethod addPaymentMethod(PaymentMethod pm) throws BusinessException {

		// Check if exist
		if (getPaymentMethodByAccountNumber(pm.getAccountNumber()) != null) {
			throw new BusinessException(BusinessExceptionEnum.BE0001);
		}
		return this.save(pm);
	}

	private PaymentMethod getPaymentMethodByAccountNumber(String accountNumber) throws BusinessException {
		PaymentMethod pm;
		try {
			pm = this.mapper.mapToEntity(this.pmDao.findByAccountNumber(accountNumber));
		} catch (Exception ex) {
			throw new BusinessException(BusinessExceptionEnum.AE0002, ex, ex.getMessage());
		}
		return pm;
	}
	
	private PaymentMethod save(PaymentMethod pm) throws BusinessException {
		PaymentMethod pmSaved;
		try {
			pmSaved = this.mapper.mapToEntity(this.pmDao.save(this.mapper.mapToJPA(pm)));	
		}
		catch( Exception ex) {
			throw new BusinessException(BusinessExceptionEnum.AE0001, ex, ex.getMessage());
		}
		return pmSaved;

	}
	
	
	

}
