package com.esmasuyolu.jpa.mapped.entity;

import javax.persistence.Entity;

@Entity
public class Customer extends Partner {

	private double totalDebit;

	public Customer() {}
	
	public Customer(long parentId, String parentName, double totalDebit) {
		super(parentId, parentName);
		this.totalDebit = totalDebit;
	}

	public double getTotalDebit() {
		return totalDebit;
	}

	public void setTotalDebit(double totalDebit) {
		this.totalDebit = totalDebit;
	}
	
	
}
