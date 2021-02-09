package com.brunoepaulafinancas.first.model.dto;

import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.brunoepaulafinancas.first.model.repositories.CreditOrDebit;

public class Transaction {
	
	private int id;
	
	@NotNull
	@Min(0)
	private double amount;
	@NotBlank
	private String category;
	private Date date;
	@Valid
	private CreditOrDebit creditOrDebit;
	
	
	
	public Transaction() {
		super();
	}
	public Transaction(int id, @NotNull @Min(0) double amount, @NotBlank String category,
			@Valid CreditOrDebit creditOrDebit) {
		super();
		this.id = id;
		this.amount = amount;
		this.category = category;
		this.creditOrDebit = creditOrDebit;
	}
	public long getId() {
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
	public CreditOrDebit getCreditOrDebit() {
		return creditOrDebit;
	}
	public void setCreditOrDebit(CreditOrDebit creditOrDebit) {
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
		result = prime * result + (int) (id ^ (id >>> 32));
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
		Transaction other = (Transaction) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (creditOrDebit != other.creditOrDebit)
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
