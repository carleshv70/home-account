package com.chuix.home.account.controllers.tools;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chuix.home.account.config.info.Enviroment;
import com.chuix.home.account.constants.ApplicationConstant;
import com.chuix.home.account.dto.BaseDto;
import com.chuix.home.account.dto.HttpMethodEnum;
import com.chuix.home.account.dto.LinkDto;

import lombok.Data;
import lombok.RequiredArgsConstructor;


@Component
@RequiredArgsConstructor
@Data
public class Link<T extends BaseDto> {
	
	@Autowired
	private Enviroment enviroment;
	
	
	
	public String baseUrl() {
		return String.format(
				ApplicationConstant.PATHERN_ROUTE_BASE,
				this.enviroment.getHost(),
				this.enviroment.getPort()
		);
	}
	
	private String generateUrl(T entity) {
		return this.baseUrl() + entity.getBaseUrl();
	}
	
	private String addUpdateLink(T entity) {
		return this.generateUrl(entity) +
				entity.getRelativePath(HttpMethodEnum.PUT);
	}
		
	private String addDeleteLink(T entity) {
		return this.generateUrl(entity) +
				entity.getRelativePath(HttpMethodEnum.DELETE);
	}
	
	private String addReadLink(T entity) {
		return this.generateUrl(entity) +
				entity.getRelativePath(HttpMethodEnum.GET);
	}

	
	public void generateLinks(T entity) {
		for( HttpMethodEnum httpMethod : entity.getHttpMethods() ) {
			if (HttpMethodEnum.GET.equals(httpMethod)) {
				entity.getLinks().add(
						LinkDto.builder()
							.httpMethod(HttpMethodEnum.GET)
							.url(this.addReadLink(entity))
						.build()
				);
				
			}
			if (HttpMethodEnum.PUT.equals(httpMethod)) {
				entity.getLinks().add(
						LinkDto.builder()
							.httpMethod(HttpMethodEnum.PUT)
							.url(this.addUpdateLink(entity))
						.build()
				);
			}
			if (HttpMethodEnum.DELETE.equals(httpMethod)) {
				entity.getLinks().add(
						LinkDto.builder()
							.httpMethod(HttpMethodEnum.DELETE)
							.url(this.addDeleteLink(entity))
						.build()
				);
			}

		}
	}

	
	
	
}
