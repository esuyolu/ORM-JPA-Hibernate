package com.esmasuyolu.jpareal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class RealisticTest {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("OurPersistenceUnit");
		EntityManager entityManager = factory.createEntityManager();
		
		Realistic realistic = new Realistic(0, "Selda Bağcan", 5425.1234);
		
		entityManager.getTransaction().begin();
		
		entityManager.persist(realistic);
		
		entityManager.getTransaction().commit();
		
		entityManager.close();
	}
}
