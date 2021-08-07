package com.chuix.home.account.domain.mapper;

import com.chuix.home.account.domain.entity.PaymentMethodEntity;
import com.chuix.home.account.persistence.entity.PaymentMethodJPA;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-08-06T07:51:15+0200",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.3.1200.v20200916-0645, environment: Java 15.0.2 (Oracle Corporation)"
)
public class PaymentMethodMapperImpl implements PaymentMethodMapper {

    @Override
    public PaymentMethodEntity mapToEntity(PaymentMethodJPA entity) {
        if ( entity == null ) {
            return null;
        }

        PaymentMethodEntity paymentMethodEntity = new PaymentMethodEntity();

        paymentMethodEntity.setAccountNumber( entity.getAccountNumber() );
        paymentMethodEntity.setBalance( entity.getBalance() );
        paymentMethodEntity.setDatePreviousBalance( entity.getDatePreviousBalance() );
        paymentMethodEntity.setId( entity.getId() );
        paymentMethodEntity.setName( entity.getName() );
        paymentMethodEntity.setObservations( entity.getObservations() );
        paymentMethodEntity.setPreviousBalance( entity.getPreviousBalance() );

        return paymentMethodEntity;
    }

    @Override
    public PaymentMethodJPA mapToJPA(PaymentMethodEntity dto) {
        if ( dto == null ) {
            return null;
        }

        PaymentMethodJPA paymentMethodJPA = new PaymentMethodJPA();

        paymentMethodJPA.setAccountNumber( dto.getAccountNumber() );
        paymentMethodJPA.setBalance( dto.getBalance() );
        paymentMethodJPA.setDatePreviousBalance( dto.getDatePreviousBalance() );
        paymentMethodJPA.setId( dto.getId() );
        paymentMethodJPA.setName( dto.getName() );
        paymentMethodJPA.setObservations( dto.getObservations() );
        paymentMethodJPA.setPreviousBalance( dto.getPreviousBalance() );

        return paymentMethodJPA;
    }
}
