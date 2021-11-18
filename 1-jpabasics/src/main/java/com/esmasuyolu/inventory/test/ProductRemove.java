package com.esmasuyolu.inventory.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.esmasuyolu.inventory.entity.Department;

public class ProductRemove {

	public static void main(String[] args) {

		long productId = 2;

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("MyPersistenceUnit");
		EntityManager entityManager = factory.createEntityManager();
		
		entityManager.getTransaction().begin();

		Department product = entityManager.getReference(Department.class, productId);
		
		entityManager.remove(product);
		
		entityManager.getTransaction().commit();

		entityManager.close();
	}
}
