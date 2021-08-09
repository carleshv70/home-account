package com.chuix.home.account.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.chuix.home.account.domain.entity.PaymentMethod;
import com.chuix.home.account.dto.PaymentMethodDto;

@Mapper
public interface PaymentMethodDtoMapper {
	
	PaymentMethodDtoMapper INSTANCE = Mappers.getMapper(PaymentMethodDtoMapper.class);

	PaymentMethodDto mapToDto(PaymentMethod entity);
	
	PaymentMethod mapToEntity(PaymentMethodDto dto);
}
