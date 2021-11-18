package com.esmasuyolu.jpa.mapped.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.esmasuyolu.jpa.mapped.entity.Customer;

public class MappedQuery {

	public static void main(String[] args) {
		
		double totalDebitMin = 4000;

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("YourPersistenceUnit");
		EntityManager entityManager = factory.createEntityManager();

		String jpql = "select customer from Customer as customer where customer.totalDebit > :totalDebitMin";
		TypedQuery<Customer> query = entityManager.createQuery(jpql, Customer.class);
		query.setParameter("totalDebitMin", totalDebitMin);
		List<Customer> customerList = query.getResultList();

		entityManager.close();

		for (Customer customer : customerList) {
			System.out.println(customer.getParentId() + " " +customer.getParentName() + " " + customer.getTotalDebit());
		}
	}
}
