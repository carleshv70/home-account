package com.chuix.home.account.controllers.api;

import static com.chuix.home.account.constants.ApplicationConstant.PATH_CREATE;
import static com.chuix.home.account.constants.ApplicationConstant.PATH_UPDATE;
import static com.chuix.home.account.constants.ApplicationConstant.PATH_DELETE;
import static com.chuix.home.account.constants.ApplicationConstant.PATH_READ;
import static com.chuix.home.account.constants.ApplicationConstant.PATH_LIST;
import static com.chuix.home.account.constants.ApplicationConstant.PATH_PAYMENT_METHOD;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.chuix.home.account.controllers.tools.Request;
import com.chuix.home.account.domain.entity.PaymentMethod;
import com.chuix.home.account.domain.exception.BusinessException;
import com.chuix.home.account.domain.services.PaymentMethodService;
import com.chuix.home.account.dto.PaymentMethodDto;
import com.chuix.home.account.dto.mapper.PaymentMethodDtoMapper;

@RestController
@RequestMapping(PATH_PAYMENT_METHOD)
public class PaymentMethodController {

	@Autowired
	private PaymentMethodDtoMapper mapper;

	@Autowired
	private PaymentMethodService serive;
	
	@Autowired
	private Request<PaymentMethodDto, PaymentMethod> request;
	
	private Function<PaymentMethod, PaymentMethodDto> mapperToDtoFunc;
	
	PaymentMethodController() {
		this.mapperToDtoFunc = (pm -> this.mapper.mapToDto(pm));
	}
	
	@GetMapping(PATH_LIST)
	@ResponseStatus(value = HttpStatus.OK)
	public Map<String, List<PaymentMethodDto>> getPaymentMethods() {
		
		return this.request.prepareResponseList(
				this.serive.getPaymentMethods(), 
				this.mapperToDtoFunc);
	}

	@PostMapping(PATH_CREATE)
	@ResponseStatus(value = HttpStatus.CREATED)
	public Map<String, PaymentMethodDto> addPaymentMethod(@Valid @RequestBody PaymentMethodDto pm) throws BusinessException {

			return this.request.prepareResponse(
					this.serive.addPaymentMethod(this.mapper.mapToEntity(pm)),
					this.mapperToDtoFunc
			);
	}
	
	@PutMapping(PATH_UPDATE)
	@ResponseStatus(value = HttpStatus.OK)
	public Map<String, PaymentMethodDto> updatePaymentMethod(@PathVariable @NotNull Long id, @Valid @RequestBody PaymentMethodDto pm) throws BusinessException {

		return this.request.prepareResponse(
				this.serive.updatedPaymentMethod(id, this.mapper.mapToEntity(pm)),
				this.mapperToDtoFunc
		);
}
	
	
	
}
