package com.esmasuyolu.jpa.mapped.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.esmasuyolu.jpa.mapped.entity.Customer;
import com.esmasuyolu.jpa.mapped.entity.Supplier;

public class MappedPersist {

	public static void main(String[] args) {

		Customer customer1 = new Customer(0, "Müşteri 1", 5450);
		Customer customer2 = new Customer(0, "Müşteri 2", 3655);
		Supplier supplier1 = new Supplier(0, "Satıcı 1", 2465);
		Supplier supplier2 = new Supplier(0, "Satıcı 2", 1690);
		
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("YourPersistenceUnit");
		EntityManager entityManager = factory.createEntityManager();

		entityManager.getTransaction().begin();

		entityManager.persist(customer1);
		entityManager.persist(customer2);
		entityManager.persist(supplier1);
		entityManager.persist(supplier2);

		entityManager.getTransaction().commit();

		entityManager.close();
	}
}
