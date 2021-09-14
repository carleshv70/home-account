package com.chuix.home.account.domain.api;

import java.util.List;

import com.chuix.home.account.domain.core.exception.BusinessException;

interface CrudService<E> {
	
	List<E> getAll();
	
	E getById(Long id);
	
	E add(E entity) throws BusinessException;

	E update(Long id, E entity) throws BusinessException;
	
	void deleteById(long Id);
}
