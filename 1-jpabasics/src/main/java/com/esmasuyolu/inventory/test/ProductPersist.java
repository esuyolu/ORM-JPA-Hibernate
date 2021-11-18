package com.esmasuyolu.inventory.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.esmasuyolu.inventory.entity.Department;

public class ProductPersist {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("MyPersistenceUnit");

		EntityManager entityManager = factory.createEntityManager();

		Department product = new Department(0, "Cep Telefonu", 1340);

		entityManager.getTransaction().begin();  // veritabanında değişiklik yapacağın zaman transaction açmak zorundasın!!

		entityManager.persist(product);

		entityManager.getTransaction().commit();

		entityManager.close();

		System.out.println("Ürün Özdeşliği: " + product.getProductId());
	}
}
