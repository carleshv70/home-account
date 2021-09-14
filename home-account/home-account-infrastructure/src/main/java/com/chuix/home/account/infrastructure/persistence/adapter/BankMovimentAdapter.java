package com.chuix.home.account.infrastructure.persistence.adapter;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chuix.home.account.domain.core.model.entity.MovimentBank;
import com.chuix.home.account.domain.core.port.persistence.BankMovimentPort;
import com.chuix.home.account.infrastructure.persistence.entity.BankMovementEntity;
import com.chuix.home.account.infrastructure.persistence.mapper.BankMovementMapper;
import com.chuix.home.account.infrastructure.persistence.repository.BankMovementRepository;

@Component
public class BankMovimentAdapter implements BankMovimentPort {
	
	@Autowired
	private BankMovementRepository repository;
	
	@Autowired
	private BankMovementMapper mapper;
	

	@Override
	public List<MovimentBank> findAll() {

		return this.repository.findAll().stream()
				.map( this.mapper::from)
				.collect(Collectors.toList());
	}

	@Override
	public MovimentBank findById(Long id) {
		Optional<BankMovementEntity> optBankMovementEntity = this.repository.findById(id);
		if (!optBankMovementEntity.isPresent()) {
			return null;
		}
		return this.mapper.from( optBankMovementEntity.get() );
	}

	@Override
	public MovimentBank save(MovimentBank businessEntity) 
	{
		BankMovementEntity bankMovementDB = null;
		
		if( businessEntity.getId() != null ) {
			Optional<BankMovementEntity> optBankMovimentEntity = this.repository.findById(businessEntity.getId()); 
			
			if (optBankMovimentEntity.isPresent()) {
				
				bankMovementDB = optBankMovimentEntity.get();
				this.mapper.update(bankMovementDB, businessEntity);
			}
		}
		
		if (bankMovementDB == null) {

			bankMovementDB = this.mapper.from(businessEntity);
		}
		
		BankMovementEntity bankMovementSaved = this.repository.save(bankMovementDB);
		
		return this.mapper.from(bankMovementSaved);

	}

}
