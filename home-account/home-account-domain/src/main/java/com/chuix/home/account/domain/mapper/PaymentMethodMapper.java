package com.chuix.home.account.domain.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import com.chuix.home.account.domain.entity.PaymentMethod;
import com.chuix.home.account.persistence.entity.PaymentMethodEntity;

@Mapper(componentModel = "spring")
public interface PaymentMethodMapper {
	
	PaymentMethodMapper INSTANCE = Mappers.getMapper(PaymentMethodMapper.class);

	PaymentMethod mapToEntity(PaymentMethodEntity entity);
	
	@Mapping(target = "createAt", ignore = true)
	PaymentMethodEntity mapToJPA(PaymentMethod dto);
	
	@Mapping(target = "createAt", ignore = true)
	void update(@MappingTarget PaymentMethodEntity entity, PaymentMethod dto);
}
