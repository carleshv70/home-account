package com.chuix.home.account.dto.mapper;

import org.mapstruct.Mapper;

import com.chuix.home.account.domain.entity.BasquetEntity;
import com.chuix.home.account.dto.BasquetDto;

@Mapper
public interface BasquetMapper {
	
		BasquetEntity mapDtoToEntity(BasquetDto entity);
}
