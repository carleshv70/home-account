package com.chuix.home.account.domain.entity;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovimentBank {

	private Long id;

	@NotNull(message = "Este campo debe estar informado")
	private PaymentMethod paymentMethod;

	@NotNull(message = "Este campo debe estar informado")
	private Character movimentType;  
	
	@NotNull(message = "Este campo debe estar informado")
	private Double amount;
	
	@NotNull(message = "Este campo debe estar informado")
	private LocalDate date;
	
	private LocalDate createAt;
	
	private LocalDate deleteAt;

	
}
