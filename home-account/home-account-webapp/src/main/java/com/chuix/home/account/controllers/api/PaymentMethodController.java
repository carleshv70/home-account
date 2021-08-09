package com.chuix.home.account.controllers.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chuix.home.account.domain.exception.BusinessException;
import com.chuix.home.account.domain.services.PaymentMethodService;
import com.chuix.home.account.dto.PaymentMethodDto;
import com.chuix.home.account.dto.mapper.PaymentMethodDtoMapper;

@RestController
@RequestMapping("/api/medios-pago")
public class PaymentMethodController {
	
	@Autowired
	private PaymentMethodDtoMapper mapper;

	@Autowired
	private PaymentMethodService serive;

	@GetMapping("/")
	public ResponseEntity<?> getPaymentMethods() {

		List<PaymentMethodDto> pms = this.serive.getPaymentMethods().stream().map(pm -> this.mapper.mapToDto(pm))
				.collect(Collectors.toList());

		return new ResponseEntity<List<PaymentMethodDto>>(pms, HttpStatus.OK);
	}

	@PostMapping("/")
	public ResponseEntity<Map<String,Object>> addPaymentMethod(@Valid @RequestBody PaymentMethodDto pm) {
		
		Map<String,Object> response = new HashMap<>();
		PaymentMethodDto pmAdded; 
		
		try {
			pmAdded = 
				this.mapper.mapToDto(
					this.serive.addPaymentMethod(
							this.mapper.mapToEntity(pm)
						)
				);
			response.put("PaymentMethod", pmAdded);
		} catch (BusinessException ex) {
			response.put("Error", ex.toString());
		} 
		
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
	}
}
