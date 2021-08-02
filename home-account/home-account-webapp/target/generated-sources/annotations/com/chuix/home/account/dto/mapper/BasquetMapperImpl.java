package com.chuix.home.account.dto.mapper;

import com.chuix.home.account.domain.entity.BasquetEntity;
import com.chuix.home.account.dto.BasquetDto;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-08-02T07:47:42+0200",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.3.1200.v20200916-0645, environment: Java 15.0.2 (Oracle Corporation)"
)
public class BasquetMapperImpl implements BasquetMapper {

    @Override
    public BasquetEntity mapDtoToEntity(BasquetDto entity) {
        if ( entity == null ) {
            return null;
        }

        BasquetEntity basquetEntity = new BasquetEntity();

        basquetEntity.setCurrentPeriod( entity.getCurrentPeriod() );
        basquetEntity.setTeamAName( entity.getTeamAName() );
        basquetEntity.setTeamAScore( entity.getTeamAScore() );
        basquetEntity.setTeamBName( entity.getTeamBName() );
        basquetEntity.setTeamBScore( entity.getTeamBScore() );

        return basquetEntity;
    }
}
