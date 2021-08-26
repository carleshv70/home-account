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
	
	private String generateUrl(T entity, boolean view) {
		String res;
		if (view) {
			
			res = entity.getBaseUrl();

			
		} else {

			res = this.baseUrl() +
					ApplicationConstant.PATH_API_REST +
					entity.getBaseUrl();
			
		}
		return res;
	}
	
	private String addUpdateLink(T entity, boolean view) {
		return this.generateUrl(entity, view) +

				entity.getRelativePath(HttpMethodEnum.PUT) +
				(view? "/edit": "");
	}
		
	private String addDeleteLink(T entity, boolean view) {
		return this.generateUrl(entity, view) +
				entity.getRelativePath(HttpMethodEnum.DELETE) +
				(view? "/delete": "");
	}
	
	private String addReadLink(T entity, boolean view) {
		return this.generateUrl(entity, view) +
				entity.getRelativePath(HttpMethodEnum.GET) +
				(view? "/edit": "");
	}

	
	public void generateLinks(T entity) {
		for( HttpMethodEnum httpMethod : entity.getHttpMethods() ) {
			if (HttpMethodEnum.GET.equals(httpMethod)) {
				entity.getLinks().add(
						LinkDto.builder()
							.httpMethod(HttpMethodEnum.GET)
							.url(this.addReadLink(entity , false))
							.urlView(this.addReadLink(entity, true))
						.build()
				);
				
			}
			if (HttpMethodEnum.PUT.equals(httpMethod)) {
				entity.getLinks().add(
						LinkDto.builder()
							.httpMethod(HttpMethodEnum.PUT)
							.url(this.addUpdateLink(entity, false))
							.urlView(this.addUpdateLink(entity, true))
						.build()
				);
			}
			if (HttpMethodEnum.DELETE.equals(httpMethod)) {
				entity.getLinks().add(
						LinkDto.builder()
							.httpMethod(HttpMethodEnum.DELETE)
							.url(this.addDeleteLink(entity, false))
							.urlView(this.addDeleteLink(entity, true))
						.build()
				);
			}

		}
	}

	
	
	
}
