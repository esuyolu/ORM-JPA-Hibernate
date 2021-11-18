package com.esmasuyolu.inventory.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class QueryAggregate {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("MyPersistenceUnit");
		EntityManager entityManager = factory.createEntityManager();

		String jpql = "select sum(product.salesPrice) from Product as product"
				+ " where product.salesPrice > :salesPriceMin";
		TypedQuery<Double> query = entityManager.createQuery(jpql, Double.class);
		query.setParameter("salesPriceMin", 4000.0);
		double sum = query.getSingleResult();

		entityManager.close();
		
		System.out.println("Toplam: " + sum);
	}
}
