package com.esmasuyolu.inventory.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.esmasuyolu.inventory.entity.Department;

public class ProductFind {

	public static void main(String[] args) {
		
		long productId = 1;

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("MyPersistenceUnit");
		EntityManager entityManager = factory.createEntityManager();

		Department product = entityManager.find(Department.class, productId);

		entityManager.close();
		
		System.out.println(product.getProductId() + " "
				+ product.getProductName() + " "
				+ product.getSalesPrice());
	}
}
