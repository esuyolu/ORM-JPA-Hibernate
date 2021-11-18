package com.esmasuyolu.jpareal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CustomerTest {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("OurPersistenceUnit");
		EntityManager entityManager = factory.createEntityManager();
		
		Customer customer = new Customer(0, "Mahsuni Şerif", 3560);
		
		entityManager.getTransaction().begin();
		
		entityManager.persist(customer);
		
		entityManager.getTransaction().commit();
		
		entityManager.close();
	}
}
