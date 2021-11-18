package com.esmasuyolu.jpalife.cache.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.esmasuyolu.jpalife.cache.entity.Frequent;

public class FirstLevelFind {

	public static void main(String[] args) {

		long frequentId = 1;

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ItsPersistenceUnit");
		EntityManager entityManager1 = factory.createEntityManager();

		Frequent frequent1a = entityManager1.find(Frequent.class, frequentId);
		System.out.println(frequent1a);
		
		entityManager1.refresh(frequent1a);
		
		Frequent frequent1b = entityManager1.find(Frequent.class, frequentId);
		System.out.println(frequent1b);
		
		entityManager1.close(); 
		
		EntityManager entityManager2 = factory.createEntityManager();

		Frequent frequent2a = entityManager2.find(Frequent.class, frequentId);
		System.out.println(frequent2a);
		
		entityManager2.refresh(frequent2a);
		
		Frequent frequent2b = entityManager2.find(Frequent.class, frequentId);
		System.out.println(frequent2b);
		
		entityManager2.close();
	}
}
