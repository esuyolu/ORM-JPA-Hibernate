package com.esmasuyolu.jpalife.cache.test;

import javax.persistence.Cache;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.esmasuyolu.jpalife.cache.entity.Frequent;

public class SecondLevelFind {

	public static void main(String[] args) {

		long frequentId = 1;

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ItsPersistenceUnit");
		
		Cache cache = factory.getCache();
		
		EntityManager entityManager = factory.createEntityManager();

		Frequent frequent = entityManager.find(Frequent.class, frequentId);
		System.out.println(frequent);
		System.out.println("cahche de mi ? " + cache.contains(Frequent.class, frequentId));
		
		cache.evict(Frequent.class, frequentId); // cache boşaltma
		System.out.println("cahche de mi ? " + cache.contains(Frequent.class, frequentId));
		
		entityManager.close(); 
		
	}
}
