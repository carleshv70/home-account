package com.chuix.home.account.application.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.chuix.home.account.application.dto.PaymentMethodDto;
import com.chuix.home.account.domain.entity.PaymentMethod;

@Mapper(
		componentModel = "spring",
		unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface PaymentMethodDtoMapper {

	
	PaymentMethodDtoMapper INSTANCE = Mappers.getMapper(PaymentMethodDtoMapper.class);

	PaymentMethodDto mapToDto(PaymentMethod entity);
	
	PaymentMethod mapToEntity(PaymentMethodDto dto);
}
