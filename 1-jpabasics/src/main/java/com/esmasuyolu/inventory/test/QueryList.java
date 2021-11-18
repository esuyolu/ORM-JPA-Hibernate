package com.esmasuyolu.inventory.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.esmasuyolu.inventory.entity.Department;

public class QueryList {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("MyPersistenceUnit");
		EntityManager entityManager = factory.createEntityManager();

		String jpql = "select product from Product as product where product.salesPrice > :salesPriceMin";
		TypedQuery<Department> query = entityManager.createQuery(jpql, Department.class);
		query.setParameter("salesPriceMin", 4000.0);

		List<Department> productList = query.getResultList();

		entityManager.close(); // veritabanı ile olan iş biter

		for (Department product : productList) {
			System.out.println(product.getProductId() + " " + product.getProductName() + " " + product.getSalesPrice());
		}
	}
}
