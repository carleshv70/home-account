package com.chuix.home.account.domain.port;

import java.util.List;

public interface Port<T> {
	
	List<T> findAll();
		
	T findById(Long id);
	
	T save(T paymentMethod);
}
