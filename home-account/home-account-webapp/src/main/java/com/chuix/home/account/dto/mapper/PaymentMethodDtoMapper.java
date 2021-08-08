package com.chuix.home.account.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.chuix.home.account.domain.entity.PaymentMethodEntity;
import com.chuix.home.account.dto.PaymentMethodDto;

@Mapper
public interface PaymentMethodDtoMapper {
	
	PaymentMethodDtoMapper INSTANCE = Mappers.getMapper(PaymentMethodDtoMapper.class);

	PaymentMethodDto mapToDto(PaymentMethodEntity entity);
	
	PaymentMethodEntity mapToEntity(PaymentMethodDto dto);
}
