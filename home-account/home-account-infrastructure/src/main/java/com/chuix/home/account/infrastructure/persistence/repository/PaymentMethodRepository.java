package com.chuix.home.account.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chuix.home.account.infrastructure.persistence.entity.PaymentMethodEntity;

public interface PaymentMethodRepository extends JpaRepository<PaymentMethodEntity, Long> {

	PaymentMethodEntity findByAccountNumber(String accountNumber);
}
