package com.chuix.home.account.controllers.tools;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chuix.home.account.dto.BaseDto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
@Data
public class Request<T extends BaseDto, T2> {

	private Map<String, T> response = new HashMap<>();
	private Map<String, List<T>> responseList = new HashMap<>();
	private Map<String, String> links = new HashMap<>();

	@Autowired
	private Link<T> link;

	public Map<String, List<T>> prepareResponseList(List<T2> items, Function<T2, T> func) {

		this.responseList.clear();
		
		if(!items.isEmpty()) {
			
			List<T> itemsDto = items.stream()
					.map(item -> {
						T itemDto = func.apply(item);
						this.link.generateLinks(itemDto);
						return itemDto;
			}).collect(Collectors.toList());
			
			String key = itemsDto.get(0).getKeyList();
			this.responseList.put(key, itemsDto);
		}
		return responseList;
	}
	
	public Map<String, T> prepareResponse(T2 item, Function<T2, T> func) {
		this.response.clear();
		T itemDto = func.apply(item);
		this.link.generateLinks(itemDto);
		this.response.put(itemDto.getKey(), itemDto);
		return this.response;
	}
}
