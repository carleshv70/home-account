package com.chuix.home.account.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.chuix.home.account.domain.entity.PaymentMethod;
import com.chuix.home.account.dto.PaymentMethodDto;

@Mapper
public interface PaymentMethodMapper {
	
	PaymentMethodMapper INSTANCE = Mappers.getMapper(PaymentMethodMapper.class);

	PaymentMethodDto mapToDto(PaymentMethod entity);
	
	PaymentMethod mapToEntity(PaymentMethodDto dto);
}
