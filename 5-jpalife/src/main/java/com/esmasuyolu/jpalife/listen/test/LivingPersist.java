package com.esmasuyolu.jpalife.listen.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.esmasuyolu.jpalife.listen.entity.Living;

public class LivingPersist {

	public static void main(String[] args) {
		
		Living living = new Living();
		living.setFirstName("");
		living.setLastName(null);

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ItsPersistenceUnit");
		EntityManager entityManager = factory.createEntityManager();

		entityManager.getTransaction().begin();

		entityManager.persist(living);

		entityManager.getTransaction().commit();

		entityManager.close();

		System.out.println("Ad boş mu?: " + living.isEmptyName());
	}
}
