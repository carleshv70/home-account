package com.chuix.home.account.domain.services;

import com.chuix.home.account.domain.dto.IEventDto;

public interface EventService {
	
	IEventDto CheckString(String inputText);
	
	String CheckStringView(String inputText);

}
