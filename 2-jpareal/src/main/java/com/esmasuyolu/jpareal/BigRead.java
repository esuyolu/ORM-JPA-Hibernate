package com.esmasuyolu.jpareal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BigRead {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("OurPersistenceUnit");
		EntityManager entityManager = factory.createEntityManager();

		entityManager.close();
	}
}
