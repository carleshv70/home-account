package com.chuix.home.account.infrastructure.persistence.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import com.chuix.home.account.domain.core.model.entity.MovimentBank;
import com.chuix.home.account.infrastructure.persistence.entity.BankMovementEntity;

@Mapper(componentModel = "spring",
	uses = { PaymentMethodMapper.class }
)
public interface BankMovementMapper {

	BankMovementMapper INSTANCE = Mappers.getMapper(BankMovementMapper.class);

	MovimentBank from(BankMovementEntity jpaEntity);
	
	@Mapping(target = "createAt", ignore = true)
	BankMovementEntity from(MovimentBank businessEntity);
	
	@Mapping(target = "createAt", ignore = true)
	void update(@MappingTarget BankMovementEntity jpaEntity, MovimentBank businessEntity);

}
