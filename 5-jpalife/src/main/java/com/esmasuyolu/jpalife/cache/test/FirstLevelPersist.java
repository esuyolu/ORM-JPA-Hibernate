package com.esmasuyolu.jpalife.cache.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.esmasuyolu.jpalife.cache.entity.Frequent;

public class FirstLevelPersist {

	public static void main(String[] args) {

		Frequent frequent = new Frequent(0, "sıklık adı1");
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ItsPersistenceUnit");
		EntityManager entityManager = factory.createEntityManager();

		entityManager.getTransaction().begin();

		entityManager.persist(frequent);

		entityManager.getTransaction().commit();

		entityManager.close();
	}
}
