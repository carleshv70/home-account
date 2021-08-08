package com.chuix.home.account.domain.exception;

/*
 * If begin with AE mean -> Application error
 * If begin with BE mean -> Business error
 * 
 */

public enum BusinessExceptionEnum {
	AE0001(1, "AE0001", "No ha sisdo posible persistir el estado del registro"),
	AE0002(1, "AE0002", "No ha sisdo posible recuperar la información solicitada."),
	BE0001(1, "BE0001", "Ya existe este registro");

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

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
