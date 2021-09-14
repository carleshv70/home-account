package com.chuix.home.account.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chuix.home.account.infrastructure.persistence.entity.BankMovementEntity;

public interface BankMovementRepository extends JpaRepository<BankMovementEntity, Long> {

}
