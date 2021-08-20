package com.chuix.home.account.config.info;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Enviroment {

	private String host;
	
	private String port;
}
