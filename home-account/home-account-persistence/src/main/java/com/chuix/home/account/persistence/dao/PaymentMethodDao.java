package com.chuix.home.account.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chuix.home.account.persistence.entity.PaymentMethodJPA;

public interface PaymentMethodDao extends JpaRepository<PaymentMethodJPA, Long> {

	PaymentMethodJPA findByAccountNumber(String accountNumber);
}
