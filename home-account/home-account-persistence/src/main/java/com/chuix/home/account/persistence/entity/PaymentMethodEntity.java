package com.chuix.home.account.persistence.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Payment_methods")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentMethodEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "Este campo debe estar informado")
	@Size(min = 20, max = 34)
	@Column(nullable = false, unique = true)
	private String accountNumber;

	@NotEmpty(message = "Este campo no puede estar vacio")
	@Column(nullable = false)
	private String name;
	
	private String observations;
	
	@NotNull(message = "Este campo tiene que estar informado")
	@Column(nullable = false)
	private Double balance;

	private Double previousBalance;
	private LocalDate datePreviousBalance;
}
