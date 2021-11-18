package com.esmasuyolu.bulk.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class BulkDelete {

	public static void main(String[] args) {

		double minExampleValue = 105;
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("HerPersistenceUnit");
		EntityManager manager = factory.createEntityManager();

		manager.getTransaction().begin();
		
		String jpql = "delete Example as example where example.exampleValue < :minExampleValue";
	
		Query query = manager.createQuery(jpql);
		query.setParameter("minExampleValue", minExampleValue);
		int affected = query.executeUpdate();
		
		manager.getTransaction().commit();

		manager.close();
		
		System.out.println("etkilenen satır sayısı: " + affected);
	}
}
