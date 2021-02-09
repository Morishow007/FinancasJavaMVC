package com.brunoepaulafinancas.first.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brunoepaulafinancas.first.model.dto.Transaction;
import com.brunoepaulafinancas.first.model.dto.TransactionConverter;
import com.brunoepaulafinancas.first.model.entities.TransactionEntity;
import com.brunoepaulafinancas.first.model.repositories.TransactionCRUD;

@Service
public class TransactionService {

	@Autowired
	private TransactionCRUD transactionCRUD;

	public void saveTransaction(Transaction transaction) {
		

		transactionCRUD.save(TransactionConverter.toTransactionEntityWithoutID(transaction));
	}
	
	

	public TransactionEntity updateTransaction(int id) {
		
		TransactionEntity transaction = transactionCRUD.findById(id).get();
		
		return transaction;

	}
	
	
	public void deleteTransaction(int id) {

		transactionCRUD.deleteById(id);

	}

	public Transaction getTransaction(int id) {
		TransactionEntity transaction = transactionCRUD.findById(id).get();
		
		return TransactionConverter.toTransaction(transaction);
	}
	
	public TransactionEntity getTransactionEntity(int id) {
		TransactionEntity transaction = transactionCRUD.findById(id).get();
		
		return transaction;
	}
	
//	public List<TransactionEntity> retrieveFilterTransactions(String keyword){
//		if(keyword != null) {
//			return transactionCRUD.search(keyword);
//		}
//		return (List<TransactionEntity>) transactionCRUD.findAll();
//	}
	
	public Iterable<TransactionEntity> retrieveTransactions() {
		
		return transactionCRUD.findAll();
		
	}

}
