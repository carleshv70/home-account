package com.chuix.home.account.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chuix.home.account.infrastructure.persistence.entity.MovementBankEntity;

public interface MovementBankRepository extends JpaRepository<MovementBankEntity, Long> {

}
