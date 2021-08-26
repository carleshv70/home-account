package com.chuix.home.account.constants;

public class ApplicationConstant {

	// Constants to create path to api
	public static final String PATH_API_REST = "/api";
	public static final String PATH_PAYMENT_METHOD = "/medios-pago";
	public static final String PATH_CREATE = "/";
	public static final String PATH_UPDATE = "/{id}";
	public static final String PATH_DELETE = "/{id}";
	public static final String PATH_READ = "/{id}";
	public static final String PATH_LIST = "/";
	
	// Constants to create path to view
	public static final String PATH_CREATE_VIEW = "/new";
	public static final String PATH_UPDATE_VIEW = "/{id}/edit";
	public static final String PATH_DELETE_VIEW = "/{id}/delete";
	public static final String PATH_READ_VIEW = "/{id}/detail";
	public static final String PATH_LIST_VIEW = "/list";
	
	
	// Constants to create links 
	public static final String PATHERN_ROUTE_BASE = "http://%s:%s";
	public static final String PATHERN_ROUTE_PAYMENT_METHOD = "%s/";
	public static final String PATHERN_ROUTE_PAYMENT_METHOD_UPDATE = "%d";
	public static final String PATHERN_ROUTE_PAYMENT_METHOD_DELETE = "%d";
	public static final String PATHERN_ROUTE_PAYMENT_METHOD_READ = "%d";
	
	public static final String KEY_ERROR = "errors";
	
	
	
	private ApplicationConstant() {
		
	}
	
}
