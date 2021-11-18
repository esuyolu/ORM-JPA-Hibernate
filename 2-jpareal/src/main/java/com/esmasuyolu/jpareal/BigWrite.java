package com.esmasuyolu.jpareal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BigWrite {

	public static void main(String[] args) {
		
		String bigText = "Godoro";
		byte[] bigBytes = {1, 2, 3, 4};
		
		
		Big big = new Big();
		big.setBigText(bigText);
		big.setBigBytes(bigBytes);

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("OurPersistenceUnit");
		EntityManager entityManager = factory.createEntityManager();

		entityManager.getTransaction().begin();

		entityManager.persist(big);

		entityManager.getTransaction().commit();

		entityManager.close();
	}
}
