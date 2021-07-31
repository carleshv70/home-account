package com.chuix.home.account.controllers.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chuix.home.account.domain.dto.IEventDto;
import com.chuix.home.account.domain.services.EventService;

@RestController
@RequestMapping("/api")
public class EventsController {
	
	@Autowired
	private EventService service;
	
	@GetMapping("/events/check-string")
	public ResponseEntity<?> interpretText(@RequestParam  String inputText ) {
		
		Map<String, Object> response = new HashMap<>();
		
		IEventDto event = this.service.CheckString(inputText);
		
		response.put("Output:", event);
		return new ResponseEntity<IEventDto>(event, HttpStatus.OK);
	}
	

}
