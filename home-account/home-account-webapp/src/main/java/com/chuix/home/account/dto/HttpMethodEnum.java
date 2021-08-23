package com.chuix.home.account.dto;

public enum HttpMethodEnum {
	GET("GET"),
	POST("POST"),
	PUT("PUT"),
	DELETE("DELETE"),
	HEAD("HEAD"),
	OPTIONS("OPTIONS");

	private String value;
	
	HttpMethodEnum(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
	
	public HttpMethodEnum getFromValue(String strHttpMethod) {

		for(HttpMethodEnum httpMethod :HttpMethodEnum.values()) {
			if( httpMethod.getValue().equals(strHttpMethod)) {
				return httpMethod;
			}
		}
		return null;
	}

}
