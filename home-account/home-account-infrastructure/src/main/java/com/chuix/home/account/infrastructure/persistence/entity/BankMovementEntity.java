package com.chuix.home.account.infrastructure.persistence.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Where;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "movement_bank")
@Where(clause = "delete_at is null ")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BankMovementEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "Este campo debe estar informado")
	private PaymentMethodEntity paymentMethod;

	@NotNull(message = "Este campo debe estar informado")
	private Character movimentType;  
	
	@NotNull(message = "Este campo debe estar informado")
	private Double amount;
	
	@NotNull(message = "Este campo debe estar informado")
	private LocalDate date;
	
	@Column(name = "create_at")
	private LocalDate createAt;
	
	@Column(name = "delete_at")
	private LocalDate deleteAt;
	
	@PrePersist
	public void prePersist() {
		this.createAt = LocalDate.now();
	}

	
	
}
