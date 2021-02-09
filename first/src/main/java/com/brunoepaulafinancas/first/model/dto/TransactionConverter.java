package com.brunoepaulafinancas.first.model.dto;

import com.brunoepaulafinancas.first.model.entities.TransactionEntity;
import com.brunoepaulafinancas.first.model.repositories.CreditOrDebit;

public final class TransactionConverter {
	
	public static TransactionEntity toTransactionEntityWithoutID(Transaction transaction) {
		
		return  new TransactionEntity(transaction.getAmount(), transaction.getCategory() 
									, transaction.getCreditOrDebit().toString());
		
	}
	
	
	
	public static Transaction toTransaction(TransactionEntity transactionEntity) {
		
		return  new Transaction(transactionEntity.getId(),transactionEntity.getAmount(),
								transactionEntity.getCategory() ,CreditOrDebit.valueOf(transactionEntity.getCreditOrDebit()));
		
	}
}
