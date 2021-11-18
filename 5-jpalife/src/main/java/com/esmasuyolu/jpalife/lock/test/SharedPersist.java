package com.esmasuyolu.jpalife.lock.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.esmasuyolu.jpalife.lock.entity.Shared;

public class SharedPersist {

	public static void main(String[] args) {

		Shared shared = new Shared();
		shared.setSharedName("paylaşılan"); 

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ItsPersistenceUnit");
		EntityManager entityManager = factory.createEntityManager();

		entityManager.getTransaction().begin();

		entityManager.persist(shared);

		entityManager.getTransaction().commit();

		entityManager.close();
	}
}
