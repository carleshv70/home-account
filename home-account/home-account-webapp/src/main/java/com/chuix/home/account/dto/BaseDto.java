package com.chuix.home.account.dto;

import java.util.List;
import java.util.Optional;

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
	
	default String getUrl(String httpMethod, boolean view) {
		Optional<LinkDto> optLink = this.getLinks().stream()
				.filter(link -> {
					
					HttpMethodEnum h = HttpMethodEnum.valueOf(httpMethod);
					return link.getHttpMethod().equals(h);
				}).findFirst();
		
		if ( !optLink.isPresent()) {
			return this.getBaseUrl() + "404.html";
		}
		
		LinkDto linkDto = optLink.get();
		
		return view? linkDto.getUrlView(): linkDto.getUrl();
	}

	
}
