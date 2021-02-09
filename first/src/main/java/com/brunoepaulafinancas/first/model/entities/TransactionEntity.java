package com.brunoepaulafinancas.first.model.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Transaction")
public class TransactionEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private double amount;
	private String category;
	private Date date;
	
	@Column(name = "Payment_Type" )
	String creditOrDebit;
	
	
	

	public TransactionEntity(double amount, String category, String creditOrDebit) {
		super();
		this.amount = amount;
		this.category = category;
		this.creditOrDebit = creditOrDebit;
	}
	public TransactionEntity() {
		
	}
	public TransactionEntity(int id, double amount, String category, String creditOrDebit) {
		super();
		this.id = id;
		this.amount = amount;
		this.category = category;
		this.creditOrDebit = creditOrDebit;
	}
	
	public TransactionEntity(int id, double amount, String category, Date date, String creditOrDebit) {
		super();
		this.id = id;
		this.amount = amount;
		this.category = category;
		this.date = date;
		this.creditOrDebit = creditOrDebit;
	}
	public TransactionEntity(double amount, String category) {
		super();
		this.amount = amount;
		this.category = category;
	
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getCreditOrDebit() {
		return creditOrDebit;
	}
	public void setCreditOrDebit(String creditOrDebit) {
		this.creditOrDebit = creditOrDebit;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((creditOrDebit == null) ? 0 : creditOrDebit.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TransactionEntity other = (TransactionEntity) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (creditOrDebit == null) {
			if (other.creditOrDebit != null)
				return false;
		} else if (!creditOrDebit.equals(other.creditOrDebit))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	

	
	

}
