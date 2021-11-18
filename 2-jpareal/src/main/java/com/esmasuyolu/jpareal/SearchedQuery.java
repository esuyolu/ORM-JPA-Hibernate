package com.esmasuyolu.jpareal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class SearchedQuery {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("OurPersistenceUnit");
		EntityManager entityManager = factory.createEntityManager();

		String jpql = "select searched from Searched as searched"
				+ " order by searchedName";
		TypedQuery<Searched> query = entityManager.createQuery(jpql, Searched.class);
	
		List<Searched> searchedList = query.getResultList();

		entityManager.close();

		for (Searched searched : searchedList) {
			System.out.println(searched.getSearchedId()
					+ " " + searched.getSearchedName()
					+ " " + searched.getSearchedValue()
					+ " " + searched.getSearchedCount()
					+ " " + searched.getSingularName());
		}
	}	
}