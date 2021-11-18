package com.esmasuyolu.criteria.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.esmasuyolu.jpaquery.entity.Example;

public class CriteriaTest {

	public static void main(String[] args) {

		double exampleValueMin = 100;

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("HerPersistenceUnit");
		EntityManager entityManager = factory.createEntityManager();

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		
		CriteriaQuery<Example> criteria = builder.createQuery(Example.class);
		
		Root<Example> root = criteria.from(Example.class);
		
		Predicate condition = builder.gt(root.get("exampleValue"), exampleValueMin);
		
		TypedQuery<Example> query = entityManager.createQuery(criteria);
		
		criteria.where(condition);
		
		List<Example> exampleList = query.getResultList();

		entityManager.close();

		for (Example example : exampleList) {
			System.out
					.println(example.getExampleId() + " " + example.getExampleName() + " " + example.getExampleValue());
		}
	}
}
