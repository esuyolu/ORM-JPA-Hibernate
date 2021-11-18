package com.esmasuyolu.bulk.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class BulkUpdate {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("HerPersistenceUnit");
		EntityManager manager = factory.createEntityManager();

		manager.getTransaction().begin();
		
		String jpql = " update Example as example "
					+ " set example.exampleName = CONCAT(:namePrefix, example.exampleName) ";
	
		Query query = manager.createQuery(jpql);
		query.setParameter("namePrefix", "esma ");
		int affected = query.executeUpdate();
		
		manager.getTransaction().commit();

		manager.close();
		
		System.out.println("etkilenen satır sayısı: " + affected);
	}
}
