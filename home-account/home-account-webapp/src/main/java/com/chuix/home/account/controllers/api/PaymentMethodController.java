package com.chuix.home.account.controllers.api;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chuix.home.account.domain.services.PaymentMethodService;
import com.chuix.home.account.dto.PaymentMethodDto;
import com.chuix.home.account.dto.mapper.PaymentMethodMapper;

@RestController
@RequestMapping("/api/medios-pago")
public class PaymentMethodController {
	
	@Autowired
	private PaymentMethodMapper mapper;
	
	@Autowired
	private PaymentMethodService serive;

	@GetMapping("/list")
	public ResponseEntity<?> getPaymentMethods() {
		
		List<PaymentMethodDto> pms = this.serive.getPaymentMethods().stream()
				.map(pm -> this.mapper.mapToDto(pm))
				.collect(Collectors.toList());
		
		return new ResponseEntity<List<PaymentMethodDto>>(pms, HttpStatus.OK);
	}
}
