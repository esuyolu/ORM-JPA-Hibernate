package com.esmasuyolu.jpaembed.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.esmasuyolu.jpaembed.entity.Address;
import com.esmasuyolu.jpaembed.entity.Customer;


public class CustomerPersist {

	public static void main(String[] args) {

		Customer customer = new Customer();
		customer.setCustomerName("Barış Manço");

		Address address = new Address();
		address.setProvinceName("İstanbul");
		address.setDistrictName("Kadıköy");
		address.setAddressLine1("Moda Mah.");
		address.setAddressLine2("No 9.");
		
		customer.setAddress(address);
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("TheirPersistenceUnit");
		EntityManager entityManager = factory.createEntityManager();

		entityManager.getTransaction().begin(); 

		entityManager.persist(customer);

		entityManager.getTransaction().commit();

		entityManager.close();
	}
}
