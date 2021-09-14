package com.chuix.home.account.domain.core.model.entity;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentMethod {
	
	private Long id;
	
	@NotNull(message = "Este campo debe estar informado")
	@Size(min = 20, max = 34)
	private String accountNumber;

	@NotEmpty(message = "Este campo no puede estar vacio")
	private String name;
	
	private String observations;
	
	@NotNull(message = "Este campo tiene que estar informado")
	private Double balance;

	private LocalDate createAt;
	private LocalDate deleteAt;
	
	private Double previousBalance;
	private LocalDate datePreviousBalance;
	
	public PaymentMethod copy() {
		return PaymentMethod.builder()
				.id(this.getId())
				.accountNumber(this.getAccountNumber())
				.balance(this.getBalance())
				.datePreviousBalance(this.getDatePreviousBalance())
				.deleteAt(this.getDeleteAt())
				.name(this.getName())
				.observations(this.getObservations())
				.previousBalance(this.getPreviousBalance())
				.build();
	}
}
