package com.esmasuyolu.jpalife.listen.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.esmasuyolu.jpalife.listen.entity.Kid;

public class HeritagePersist {

public static void main(String[] args) {
		
		Kid kid = new Kid();
		kid.setNameField("çocuk");

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ItsPersistenceUnit");
		EntityManager entityManager = factory.createEntityManager();

		entityManager.getTransaction().begin();

		entityManager.persist(kid);

		entityManager.getTransaction().commit();

		entityManager.close();
	}
}
