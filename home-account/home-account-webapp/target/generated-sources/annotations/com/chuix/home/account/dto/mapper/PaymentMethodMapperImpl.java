package com.chuix.home.account.dto.mapper;

import com.chuix.home.account.domain.entity.PaymentMethodEntity;
import com.chuix.home.account.dto.PaymentMethodDto;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-08-06T07:50:34+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_271 (Oracle Corporation)"
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
        paymentMethodDto.setName( entity.getName() );
        paymentMethodDto.setObservations( entity.getObservations() );
        paymentMethodDto.setBalance( entity.getBalance() );
        paymentMethodDto.setPreviousBalance( entity.getPreviousBalance() );
        paymentMethodDto.setDatePreviousBalance( entity.getDatePreviousBalance() );

        return paymentMethodDto;
    }

    @Override
    public PaymentMethodEntity mapToEntity(PaymentMethodDto dto) {
        if ( dto == null ) {
            return null;
        }

        PaymentMethodEntity paymentMethodEntity = new PaymentMethodEntity();

        paymentMethodEntity.setAccountNumber( dto.getAccountNumber() );
        paymentMethodEntity.setName( dto.getName() );
        paymentMethodEntity.setObservations( dto.getObservations() );
        paymentMethodEntity.setBalance( dto.getBalance() );
        paymentMethodEntity.setPreviousBalance( dto.getPreviousBalance() );
        paymentMethodEntity.setDatePreviousBalance( dto.getDatePreviousBalance() );

        return paymentMethodEntity;
    }
}
