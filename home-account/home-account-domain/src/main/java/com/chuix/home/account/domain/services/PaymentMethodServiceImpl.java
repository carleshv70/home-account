package com.chuix.home.account.domain.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chuix.home.account.domain.entity.PaymentMethod;
import com.chuix.home.account.domain.exception.BusinessException;
import com.chuix.home.account.domain.exception.BusinessExceptionEnum;
import com.chuix.home.account.domain.mapper.PaymentMethodMapper;
import com.chuix.home.account.persistence.dao.PaymentMethodDao;

@Service
public class PaymentMethodServiceImpl  implements PaymentMethodService{

	@Autowired
	private PaymentMethodMapper mapper;

	@Autowired
	private PaymentMethodDao pmDao;

	public List<PaymentMethod> getPaymentMethods() {
		
		return this.pmDao.findAll().stream()
				.map(this.mapper::mapToEntity).collect(Collectors.toList());
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
