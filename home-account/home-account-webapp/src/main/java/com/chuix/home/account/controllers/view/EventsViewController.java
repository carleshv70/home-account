package com.chuix.home.account.controllers.view;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chuix.home.account.domain.dto.FilterDto;
import com.chuix.home.account.domain.services.EventService;

@Controller
@RequestMapping("/")
public class EventsViewController {

	@Autowired
	private EventService service;

	@GetMapping("/events/check-text")
	public String interpretText(Model model, @RequestParam  Optional<String> inputText) {
		
		FilterDto filter = new FilterDto();
		
		if (inputText.isPresent() && inputText.get() != null) {
			
			filter.setInputText(inputText.get());

			try {
				String event = this.service.CheckStringView(inputText.get());
				filter.setResponse(event);
				
				model.addAttribute("data", filter);
				model.addAttribute("isJSON", true);
				model.addAttribute("result", true);

			}
			catch(IllegalArgumentException ex ) {
				model.addAttribute("result", false);
				model.addAttribute("error", ex.getMessage());
			}
			
			
		} else  {
			model.addAttribute("isJSON", false);
			model.addAttribute("result", true);
		}
		return "checktext";
		
	}

}
