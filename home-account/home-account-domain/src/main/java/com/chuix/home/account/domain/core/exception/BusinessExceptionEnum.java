package com.chuix.home.account.domain.core.exception;

/*
 * If begin with AE mean -> Application error
 * If begin with BE mean -> Business error
 * 
 */

public enum BusinessExceptionEnum {
	AE0001(1, "AE0001", "No ha sisdo posible persistir el estado del registro"),
	AE0002(2, "AE0002", "No ha sisdo posible recuperar la información solicitada."),
	BE0001(3, "BE0001", "Ya existe este registro"),
	BE0002(4, "BE0002", "No existe un medio de pago con este Id"),
	BE0003(5, "BE0003", "La petición realizada no es correcta");

	private int id;
	private String code;
	private String description;

	BusinessExceptionEnum(int id, String code, String description) {
		this.id = id;
		this.code = code;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public String getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}
}
