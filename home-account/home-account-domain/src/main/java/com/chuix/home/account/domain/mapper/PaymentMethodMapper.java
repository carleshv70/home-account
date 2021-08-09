package com.chuix.home.account.domain.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.chuix.home.account.domain.entity.PaymentMethod;
import com.chuix.home.account.persistence.entity.PaymentMethodEntity;

@Mapper
public interface PaymentMethodMapper {
	
	PaymentMethodMapper INSTANCE = Mappers.getMapper(PaymentMethodMapper.class);

	PaymentMethod mapToEntity(PaymentMethodEntity entity);
	
	PaymentMethodEntity mapToJPA(PaymentMethod dto);
}
