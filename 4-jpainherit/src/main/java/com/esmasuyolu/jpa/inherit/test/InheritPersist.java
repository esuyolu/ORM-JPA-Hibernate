package com.esmasuyolu.jpa.inherit.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.esmasuyolu.jpa.inherit.entity.Brother;
import com.esmasuyolu.jpa.inherit.entity.Sister;


public class InheritPersist {

	public static void main(String[] args) {

		Brother brother1 = new Brother(0, "Erkek kardeş 1", 5450, true);
		Brother brother2 = new Brother(0, "Ekek kardeş 2", 3655, false);
		Sister sister1 = new Sister(0, "Kız kardeş 1", 2465, (short)328);
		Sister sister2 = new Sister(0, "Kız kardeş 2", 1690, (short)651);
		
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("YourPersistenceUnit");
		EntityManager entityManager = factory.createEntityManager();

		entityManager.getTransaction().begin();

		entityManager.persist(brother1);
		entityManager.persist(brother2);
		entityManager.persist(sister1);
		entityManager.persist(sister2);

		entityManager.getTransaction().commit();

		entityManager.close();
	}
}
