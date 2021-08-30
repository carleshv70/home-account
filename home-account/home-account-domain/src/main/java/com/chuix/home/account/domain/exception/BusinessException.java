package com.chuix.home.account.domain.exception;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BusinessException extends Exception  {

	private static final long serialVersionUID = -2943800881657126284L;
	
	private BusinessExceptionEnum error;
	private Exception exception;
	private String message;

	public BusinessException(BusinessExceptionEnum err) {
		super();
		this.error = err;
		this.message = err.getDescription();
	}
	
	public BusinessException(BusinessExceptionEnum err, Exception exception) {
		this(err);
		this.exception = exception;
	}

	public BusinessException(BusinessExceptionEnum err, Exception exception, String message) {
		this(err, exception);
		this.message = message;
	}
 
	public BusinessException(BusinessExceptionEnum err, String message) {
		this(err);
		this.message = message;
	}
	
}
