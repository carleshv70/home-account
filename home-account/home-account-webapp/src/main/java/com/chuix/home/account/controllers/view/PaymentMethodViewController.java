package com.chuix.home.account.controllers.view;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chuix.home.account.domain.services.PaymentMethodService;
import com.chuix.home.account.dto.PaymentMethodDto;
import com.chuix.home.account.dto.mapper.PaymentMethodMapper;

@Controller
@RequestMapping("/medios-pago")
public class PaymentMethodViewController {

	@Autowired
	private PaymentMethodMapper mapper;

	@Autowired
	private PaymentMethodService serive;

	@GetMapping("/")
	public String interpretText(Model model) {

		List<PaymentMethodDto> pms = this.serive.getPaymentMethods().stream().map(pm -> this.mapper.mapToDto(pm))
				.collect(Collectors.toList());

		model.addAttribute("pms", pms);

		return "paymentmethod";

	}

}
