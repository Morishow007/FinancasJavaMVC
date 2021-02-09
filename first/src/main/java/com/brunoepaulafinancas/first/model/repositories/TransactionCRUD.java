package com.brunoepaulafinancas.first.model.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.brunoepaulafinancas.first.model.entities.TransactionEntity;

@Repository
public interface TransactionCRUD 
		extends CrudRepository<TransactionEntity, Integer> {
	
	
	

}
