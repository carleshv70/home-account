package com.chuix.home.account.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.chuix.home.account.domain.entity.PaymentMethodEntity;
import com.chuix.home.account.dto.PaymentMethodDto;

@Mapper
public interface PaymentMethodMapper {
	
	PaymentMethodMapper INSTANCE = Mappers.getMapper(PaymentMethodMapper.class);

	PaymentMethodDto mapToDto(PaymentMethodEntity entity);
	
	PaymentMethodEntity mapToEntity(PaymentMethodDto dto);
}
