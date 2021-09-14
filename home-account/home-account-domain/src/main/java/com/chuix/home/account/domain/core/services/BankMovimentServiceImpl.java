package com.chuix.home.account.domain.core.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.chuix.home.account.domain.api.BankMovimentService;
import com.chuix.home.account.domain.core.exception.BusinessException;
import com.chuix.home.account.domain.core.exception.BusinessExceptionEnum;
import com.chuix.home.account.domain.core.model.entity.MovimentBank;
import com.chuix.home.account.domain.core.port.persistence.BankMovimentPort;

public class BankMovimentServiceImpl implements BankMovimentService {
	
	@Autowired
	private BankMovimentPort port;
	

	@Override
	public List<MovimentBank> getAll() {
		return this.port.findAll();
	}

	@Override
	public MovimentBank getById(Long id) {
		return this.port.findById(id);
	}

	@Override
	public MovimentBank add(MovimentBank movimentBank) throws BusinessException {
		return this.port.save(movimentBank);
	}

	@Override
	public MovimentBank update(Long id, MovimentBank movimentBank) throws BusinessException {
		
		MovimentBank movimentBankDB = this.port.findById(id);
		
		// check if is null
		if (movimentBankDB == null) {
			throw new BusinessException(BusinessExceptionEnum.BE0002);
		}
		return this.port.save(movimentBank);
	}

	@Override
	public void deleteById(long Id) {
		// TODO Auto-generated method stub

	}

}
