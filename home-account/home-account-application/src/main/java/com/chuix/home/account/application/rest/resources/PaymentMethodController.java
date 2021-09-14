package com.chuix.home.account.application.rest.resources;

import static com.chuix.home.account.constants.ApplicationConstant.PATH_CREATE;
import static com.chuix.home.account.constants.ApplicationConstant.PATH_UPDATE;
import static com.chuix.home.account.constants.ApplicationConstant.PATH_DELETE;
import static com.chuix.home.account.constants.ApplicationConstant.PATH_READ;
import static com.chuix.home.account.constants.ApplicationConstant.PATH_LIST;
import static com.chuix.home.account.constants.ApplicationConstant.PATH_PAYMENT_METHOD;
import static com.chuix.home.account.constants.ApplicationConstant.PATH_API_REST;


import java.util.List;
import java.util.Map;
import java.util.function.Function;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.chuix.home.account.application.dto.PaymentMethodDto;
import com.chuix.home.account.application.dto.mapper.PaymentMethodDtoMapper;
import com.chuix.home.account.application.tools.Request;
import com.chuix.home.account.domain.api.PaymentMethodService;
import com.chuix.home.account.domain.core.exception.BusinessException;
import com.chuix.home.account.domain.core.model.entity.PaymentMethod;

@RestController
@RequestMapping(PATH_API_REST + PATH_PAYMENT_METHOD)
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
		
		return this.request.prepareListApi(
				this.serive.getPaymentMethods(), 
				this.mapperToDtoFunc);
	}

	@GetMapping(PATH_READ)
	@ResponseStatus(value = HttpStatus.OK)
	public Map<String, PaymentMethodDto> readPaymentMethod(@PathVariable @NotNull Long id) throws BusinessException {

		return this.request.prepareApi(
				this.serive.getPaymentMethod(id),
				this.mapperToDtoFunc
		);
	}
	
	@PostMapping(PATH_CREATE)
	@ResponseStatus(value = HttpStatus.CREATED)
	public Map<String, PaymentMethodDto> addPaymentMethod(@Valid @RequestBody PaymentMethodDto pm) throws BusinessException {

			return this.request.prepareApi(
					this.serive.addPaymentMethod(this.mapper.mapToEntity(pm)),
					this.mapperToDtoFunc
			);
	}
	
	@PutMapping(PATH_UPDATE)
	@ResponseStatus(value = HttpStatus.OK)
	public Map<String, PaymentMethodDto> updatePaymentMethod(@PathVariable @NotNull Long id, @Valid @RequestBody PaymentMethodDto pm) throws BusinessException {

		return this.request.prepareApi(
				this.serive.updatedPaymentMethod(id, this.mapper.mapToEntity(pm)),
				this.mapperToDtoFunc
		);
	}
	
	@DeleteMapping(PATH_DELETE)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void deletePaymentMethod(@PathVariable @NotNull Long id) throws BusinessException {
		this.serive.deletePaymentMethod(id);
	}
	
	
}
