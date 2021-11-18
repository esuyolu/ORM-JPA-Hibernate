package com.esmasuyolu.named.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.esmasuyolu.jpaquery.entity.Example;

public class NamedTest {

	public static void main(String[] args) {
		
		double exampleValueMin = 105;

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("HerPersistenceUnit");
		EntityManager entityManager = factory.createEntityManager();

		TypedQuery<Example> query = entityManager.createNamedQuery("Example.findAllMin", Example.class);
		query.setParameter("exampleValue", exampleValueMin);
		
		List<Example> exampleList = query.getResultList();

		entityManager.close(); 

		for (Example example : exampleList) {
			System.out.println(example.getExampleId() + " " + example.getExampleName() + " " + example.getExampleValue());
		}
	}
}
