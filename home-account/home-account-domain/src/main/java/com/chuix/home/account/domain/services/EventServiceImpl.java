package com.chuix.home.account.domain.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.chuix.home.account.domain.dto.BasquetEventDto;
import com.chuix.home.account.domain.dto.FutbolEventDto;
import com.chuix.home.account.domain.dto.IEventDto;
import com.chuix.home.account.domain.dto.TenisEventDto;
import com.google.gson.Gson;

@Service
public class EventServiceImpl implements EventService {

	private List<IEventDto> typeEvents = new ArrayList<>();
	
	public EventServiceImpl() {
		this.configTypesEvent();
	}
	
	private void configTypesEvent() {
		typeEvents.add(new TenisEventDto() );
		typeEvents.add(new BasquetEventDto());
		typeEvents.add(new FutbolEventDto() );
	}
	
	public IEventDto CheckString(String inputText) throws IllegalArgumentException {
		
		for( IEventDto event: this.typeEvents) {
			if(event.checkTemplate(inputText)) {
				event.setFromText(inputText);
				return event;		
			}
		}
		throw new IllegalArgumentException("La cadena de entrada no tiene un formato correcto"); 
	}
	
	public String CheckStringView(String inputText) throws IllegalArgumentException {
		return StringToJSON(this.CheckString(inputText));
	}
	
	private String StringToJSON(IEventDto event) {
		final Gson gson = new Gson();
		return gson.toJson(event);
		 
	}
}
