package com.chuix.home.account.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public interface BaseDto {
	
	public Long getId();
	public List<LinkDto> getLinks();
	
	@JsonIgnore
	public String getKey();
	
	@JsonIgnore
	public String getKeyList();
	
	@JsonIgnore
	public String getBaseUrl();
	
	public String getRelativePath(HttpMethodEnum httpMethod);
	

	@JsonIgnore
	default HttpMethodEnum[] getHttpMethods() {

		return new HttpMethodEnum[] { HttpMethodEnum.GET, HttpMethodEnum.PUT, HttpMethodEnum.DELETE

		};

	}

	
}
