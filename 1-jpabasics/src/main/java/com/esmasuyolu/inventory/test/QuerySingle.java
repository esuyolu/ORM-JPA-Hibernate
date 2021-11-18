package com.esmasuyolu.inventory.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.esmasuyolu.inventory.entity.Department;

public class QuerySingle {

	public static void main(String[] args) {

		Department product;

		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("MyPersistenceUnit");
			EntityManager entityManager = factory.createEntityManager();

			String jpql = "select product from Product as product where product.salesPrice < :salesPriceMin";
			TypedQuery<Department> query = entityManager.createQuery(jpql, Department.class);
			query.setParameter("salesPriceMin", 1000.0);

			product = query.getSingleResult();

			entityManager.close();
		} catch (NoResultException e) {
			product = null;
		}

		if (product != null) {
			System.out.println(product.getProductId() + " " + product.getProductName() + " " + product.getSalesPrice());
		} else {
			System.out.println("Aradığınız ürün bulunamadı.");
		}
	}
}
