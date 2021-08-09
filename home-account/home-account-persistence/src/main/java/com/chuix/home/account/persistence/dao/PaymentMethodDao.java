package com.chuix.home.account.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chuix.home.account.persistence.entity.PaymentMethodEntity;

public interface PaymentMethodDao extends JpaRepository<PaymentMethodEntity, Long> {

	PaymentMethodEntity findByAccountNumber(String accountNumber);
}
