package com.esmasuyolu.natives.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.esmasuyolu.jpaquery.entity.Example;

public class NativeTest {

	public static void main(String[] args) {
		
		double exampleValueMin = 105;

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("HerPersistenceUnit");
		EntityManager entityManager = factory.createEntityManager();

		String jpql = "select * from Example where exampleValue > ?";
		Query query = entityManager.createNativeQuery(jpql, Example.class);
		query.setParameter(1, exampleValueMin);

		List<Example> exampleList = query.getResultList();

		entityManager.close();

		for (Example example : exampleList) {
			System.out
					.println(example.getExampleId() + " " + example.getExampleName() + " " + example.getExampleValue());
		}
	}
}
