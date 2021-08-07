package com.chuix.home.account.domain.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.chuix.home.account.domain.entity.PaymentMethodEntity;
import com.chuix.home.account.persistence.entity.PaymentMethodJPA;

@Mapper
public interface PaymentMethodMapper {
	
	PaymentMethodMapper INSTANCE = Mappers.getMapper(PaymentMethodMapper.class);

	PaymentMethodEntity mapToEntity(PaymentMethodJPA entity);
	
	PaymentMethodJPA mapToJPA(PaymentMethodEntity dto);
}
