package com.chuix.home.account.controllers.view;

import static com.chuix.home.account.constants.ApplicationConstant.PATH_LIST_VIEW;
import static com.chuix.home.account.constants.ApplicationConstant.PATH_PAYMENT_METHOD;
import static com.chuix.home.account.constants.ApplicationConstant.PATH_UPDATE_VIEW;
import static com.chuix.home.account.constants.ApplicationConstant.PATH_CREATE_VIEW;
import static com.chuix.home.account.constants.ApplicationConstant.PATH_DELETE_VIEW;

import java.util.function.Function;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chuix.home.account.controllers.tools.Link;
import com.chuix.home.account.controllers.tools.Request;
import com.chuix.home.account.domain.entity.PaymentMethod;
import com.chuix.home.account.domain.exception.BusinessException;
import com.chuix.home.account.domain.services.PaymentMethodService;
import com.chuix.home.account.dto.HttpMethodEnum;
import com.chuix.home.account.dto.PaymentMethodDto;
import com.chuix.home.account.dto.mapper.PaymentMethodDtoMapper;


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
	
	@Autowired
	private Link link;
	
	PaymentMethodViewController() {
		this.mapperToDtoFunc = (pm -> this.mapper.mapToDto(pm));
	}
	

	@GetMapping(PATH_LIST_VIEW)
	public String interpretText(Model model) {

		model.addAttribute(
				"pms", 		
				this.request.prepareListView(
					this.serive.getPaymentMethods(), 
					this.mapperToDtoFunc
				)
		);
		model.addAttribute("url_new", PATH_PAYMENT_METHOD+PATH_CREATE_VIEW);
		return "paymentmethod";

	}
	
	@GetMapping(PATH_UPDATE_VIEW)
	public String updatePaymentMethod(@PathVariable @NotNull Long id, Model model) throws BusinessException  {

		PaymentMethodDto pmDto = this.request
				.prepareView(
						this.serive.getPaymentMethod(id), 
						this.mapperToDtoFunc);
		
		model.addAttribute("pm", pmDto);
		model.addAttribute("url", pmDto.getUrl(HttpMethodEnum.PUT.getValue(), true));
		
		return "paymentmethod_edit";
	}
	
	@PostMapping(PATH_UPDATE_VIEW)
	public String updatePaymentMethod(
			@Valid @ModelAttribute("pm") PaymentMethodDto pmDto, 
			BindingResult result, 
			Model model 
		) throws BusinessException {
	
		if( result.hasErrors()) {
			model.addAttribute("pm", pmDto);
			return "paymentmethod_edit";
		} 
		
		PaymentMethodDto pmUpdatedDto = this.request
				.prepareView(
						this.serive.updatedPaymentMethod(
								pmDto.getId(), 
								this.mapper.mapToEntity(pmDto)
						),
						this.mapperToDtoFunc);
		
		model.addAttribute("pm", pmUpdatedDto);
		
		return "redirect:" + PATH_PAYMENT_METHOD + PATH_LIST_VIEW;
	}
	
	@GetMapping(PATH_CREATE_VIEW)
	public String addPaymentMethod(Model model) {
		model.addAttribute("pm", new PaymentMethodDto());
		model.addAttribute("url", PATH_PAYMENT_METHOD + PATH_CREATE_VIEW);
		return "paymentmethod_edit";
	}
	
	@PostMapping(PATH_CREATE_VIEW)
	public String addPaymentMethod(
			@Valid @ModelAttribute("pm") PaymentMethodDto pmDto, 
			BindingResult result, 
			Model model 
		) throws BusinessException {
	
		if( result.hasErrors()) {
			model.addAttribute("pm", pmDto);
			return "paymentmethod_edit";
		} 
		
		PaymentMethodDto pmUpdatedDto = this.request
				.prepareView(
						this.serive.addPaymentMethod(this.mapper.mapToEntity(pmDto)), 
						this.mapperToDtoFunc);
		
		model.addAttribute("pm", pmUpdatedDto);
		
		return "redirect:" + PATH_PAYMENT_METHOD + PATH_LIST_VIEW;
	}
	
	@GetMapping(PATH_DELETE_VIEW)
	public String addPaymentMethod(@PathVariable Long id) throws BusinessException {
		this.serive.deletePaymentMethod(id);
		return "redirect:" + PATH_PAYMENT_METHOD + PATH_LIST_VIEW;
	}

	

}
