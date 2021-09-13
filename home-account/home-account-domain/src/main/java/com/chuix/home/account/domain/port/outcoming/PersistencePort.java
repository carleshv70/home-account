package com.chuix.home.account.domain.port.outcoming;

import java.util.List;

public interface PersistencePort<T> {
	
	List<T> findAll();
		
	T findById(Long id);
	
	T save(T paymentMethod);
}
