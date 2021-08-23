package com.chuix.home.account.controllers.view;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chuix.home.account.controllers.tools.Request;
import com.chuix.home.account.domain.entity.PaymentMethod;
import com.chuix.home.account.domain.services.PaymentMethodService;
import com.chuix.home.account.dto.PaymentMethodDto;
import com.chuix.home.account.dto.mapper.PaymentMethodDtoMapper;

import static com.chuix.home.account.constants.ApplicationConstant.PATH_CREATE;
import static com.chuix.home.account.constants.ApplicationConstant.PATH_UPDATE;
import static com.chuix.home.account.constants.ApplicationConstant.PATH_DELETE;
import static com.chuix.home.account.constants.ApplicationConstant.PATH_READ;
import static com.chuix.home.account.constants.ApplicationConstant.PATH_LIST;
import static com.chuix.home.account.constants.ApplicationConstant.PATH_PAYMENT_METHOD;
import static com.chuix.home.account.constants.ApplicationConstant.PATH_API_REST;


@Controller
@RequestMapping(PATH_PAYMENT_METHOD)
public class PaymentMethodViewController {

	@Autowired
	private PaymentMethodDtoMapper mapper;

	@Autowired
	private PaymentMethodService serive;

	@Autowired
	private Request<PaymentMethodDto, PaymentMethod> request;
	
	private Function<PaymentMethod, PaymentMethodDto> mapperToDtoFunc;
	
	PaymentMethodViewController() {
		this.mapperToDtoFunc = (pm -> this.mapper.mapToDto(pm));
	}

	
	@GetMapping(PATH_LIST)
	public String interpretText(Model model) {

		model.addAttribute(
				"pms", 		
				this.request.prepareListView(
					this.serive.getPaymentMethods(), 
					this.mapperToDtoFunc
				)
		);
		return "paymentmethod";

	}

}
