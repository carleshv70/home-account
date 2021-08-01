package com.chuix.home.account.domain.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.chuix.home.account.domain.entity.BasquetEntity;
import com.chuix.home.account.domain.entity.FutbolEntity;
import com.chuix.home.account.domain.entity.SportEnity;
import com.chuix.home.account.domain.entity.TenisEntity;
import com.google.gson.Gson;

@Service
public class EventServiceImpl implements EventService {

	private List<SportEnity> typeEvents = new ArrayList<>();
	
	public EventServiceImpl() {
		this.configTypesEvent();
	}
	
	private void configTypesEvent() {
		typeEvents.add(new TenisEntity() );
		typeEvents.add(new BasquetEntity());
		typeEvents.add(new FutbolEntity() );
	}
	
	public SportEnity CheckString(String inputText) throws IllegalArgumentException {
		
		for( SportEnity event: this.typeEvents) {
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
	
	private String StringToJSON(SportEnity event) {
		final Gson gson = new Gson();
		return gson.toJson(event);
		 
	}
}
