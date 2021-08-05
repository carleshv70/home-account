package com.chuix.home.account.dto.mapper;

import com.chuix.home.account.domain.entity.PaymentMethodEntity;
import com.chuix.home.account.dto.PaymentMethodDto;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-08-05T10:11:56+0200",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.3.1200.v20200916-0645, environment: Java 15.0.2 (Oracle Corporation)"
)
@Component
public class PaymentMethodMapperImpl implements PaymentMethodMapper {

    @Override
    public PaymentMethodDto mapToDto(PaymentMethodEntity entity) {
        if ( entity == null ) {
            return null;
        }

        PaymentMethodDto paymentMethodDto = new PaymentMethodDto();

        paymentMethodDto.setAccountNumber( entity.getAccountNumber() );
        paymentMethodDto.setBalance( entity.getBalance() );
        paymentMethodDto.setDatePreviousBalance( entity.getDatePreviousBalance() );
        paymentMethodDto.setName( entity.getName() );
        paymentMethodDto.setObservations( entity.getObservations() );
        paymentMethodDto.setPreviousBalance( entity.getPreviousBalance() );

        return paymentMethodDto;
    }

    @Override
    public PaymentMethodEntity mapToEntity(PaymentMethodDto dto) {
        if ( dto == null ) {
            return null;
        }

        PaymentMethodEntity paymentMethodEntity = new PaymentMethodEntity();

        paymentMethodEntity.setAccountNumber( dto.getAccountNumber() );
        paymentMethodEntity.setBalance( dto.getBalance() );
        paymentMethodEntity.setDatePreviousBalance( dto.getDatePreviousBalance() );
        paymentMethodEntity.setName( dto.getName() );
        paymentMethodEntity.setObservations( dto.getObservations() );
        paymentMethodEntity.setPreviousBalance( dto.getPreviousBalance() );

        return paymentMethodEntity;
    }
}
