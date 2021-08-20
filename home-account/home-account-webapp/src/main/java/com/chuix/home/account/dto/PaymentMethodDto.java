package com.chuix.home.account.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.chuix.home.account.constants.ApplicationConstant;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class PaymentMethodDto implements BaseDto {
	
	private Long id;
	
	@NotNull(message = "Este campo debe estar informado")
	@Size(min = 20, max = 34)
	private String accountNumber;

	@NotEmpty(message = "Este campo no puede estar vacio")
	private String name;
	
	private String observations;
	
	@NotNull(message = "Este campo tiene que estar informado")
	private Double balance;

	private Double previousBalance;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate datePreviousBalance;
	
	private List<LinkDto> links;
	
	public PaymentMethodDto() {
		this.links = new ArrayList<>();
	}


	// information necessary to generate response
	@Override
	public String getKey() { return "paymentMethod"; }

	@Override
	public String getKeyList() { return "paymentMethods"; }

	
	// this method is necessary to create links 
	@Override
	public String getBaseUrl() {

		return 	String.format(
				ApplicationConstant.PATHERN_ROUTE_PAYMENT_METHOD, 
				ApplicationConstant.PATH_PAYMENT_METHOD
		);
	}

	// this method is necessary to create links
	@Override
	public String getRelativePath(HttpMethodEnum httpMethod) {
	
		if (HttpMethodEnum.PUT.equals(httpMethod)) {
			return String.format( ApplicationConstant.PATHERN_ROUTE_PAYMENT_METHOD_UPDATE, this.getId() );
		}
		if (HttpMethodEnum.DELETE.equals(httpMethod)) {
			return String.format( ApplicationConstant.PATHERN_ROUTE_PAYMENT_METHOD_DELETE, this.getId() );
		}
		return String.format( ApplicationConstant.PATHERN_ROUTE_PAYMENT_METHOD_READ, this.getId() );

	}


}
