package com.chuix.home.account.application.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LinkDto {

	private HttpMethodEnum httpMethod;
	private String url;
	
	@JsonIgnore
	private String urlView;
}
