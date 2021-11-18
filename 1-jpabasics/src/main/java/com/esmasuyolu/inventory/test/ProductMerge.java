package com.esmasuyolu.inventory.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.esmasuyolu.inventory.entity.Department;

public class ProductMerge { 
	
	public static void main(String[] args) {

		long productId = 1;

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("MyPersistenceUnit");
		EntityManager entityManager = factory.createEntityManager();
		
		entityManager.getTransaction().begin();  // veritabanında değişiklik yapacağın zaman transaction açmak zorundasın!!

		Department product = entityManager.find(Department.class, productId);
		
		product.setProductName("Masaüstü Bilgisayar");
		product.setSalesPrice(3450);
		
		entityManager.merge(product);     // update

		entityManager.getTransaction().commit();

		entityManager.close();
	}
}
