package com.brunoepaulafinancas.first.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brunoepaulafinancas.first.model.dto.Transaction;
import com.brunoepaulafinancas.first.model.entities.TransactionEntity;
import com.brunoepaulafinancas.first.model.repositories.TransactionCRUD;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

	
	@Autowired
	TransactionService transactionService;
	
	@Autowired
	private TransactionCRUD transactionCRUD;
	
	@PostMapping
	public Transaction createTransaction(@Valid @RequestBody Transaction transaction) {
		
		transactionService.saveTransaction(transaction);
		return transaction;
	}
	
	@GetMapping(value = "/{id}")
	public Transaction getTransaction(@PathVariable int id) {
		
		return transactionService.getTransaction(id);
	}
	
	@GetMapping("/listAll")
	public List<TransactionEntity> getAllTransactions() {
		
		return (List<TransactionEntity>) transactionService.retrieveTransactions();
	}
	
//	
	@DeleteMapping(value = "/{id}")
	public void deleteTransaction(@PathVariable int id) {
		
		transactionService.deleteTransaction(id);
	}
	
	@PutMapping(path = "/update/{id}")
	public  ResponseEntity<Void> updateTransactionAmount(@Valid @PathVariable int id,  
												@RequestBody TransactionEntity transactionUpdate) {
		
		
		TransactionEntity transaction = transactionService.updateTransaction(id);
		
	
		
		if (transactionUpdate.getAmount() != 0 ) {
			transaction.setAmount(transactionUpdate.getAmount());
		}
		if(transactionUpdate.getCategory() != null) {
			transaction.setCategory(transactionUpdate.getCategory());
		}
		if(transactionUpdate.getCreditOrDebit() != null) {
			transaction.setCreditOrDebit(transactionUpdate.getCreditOrDebit());
		}
		
		transactionCRUD.save(transaction);
		
		return ResponseEntity.noContent().build();
		
	}
	

}
