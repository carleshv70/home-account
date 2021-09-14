package com.chuix.home.account.domain.core.port.persistence;

import java.util.List;

public interface BasePort<T> {
	
	List<T> findAll();
		
	T findById(Long id);
	
	T save(T BusinessEntity);
}
