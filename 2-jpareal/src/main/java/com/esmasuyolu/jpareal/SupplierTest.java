package com.esmasuyolu.jpareal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SupplierTest {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("OurPersistenceUnit");
		EntityManager entityManager = factory.createEntityManager();
		
		Supplier supplier = new Supplier(0, "Neşet Ertaş", 4365);
		
		entityManager.getTransaction().begin();
		
		entityManager.persist(supplier);
		
		entityManager.getTransaction().commit();
		
		entityManager.close();
	}
}
