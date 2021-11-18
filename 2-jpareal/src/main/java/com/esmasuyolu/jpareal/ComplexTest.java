package com.esmasuyolu.jpareal;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ComplexTest {

	public static void main(String[] args) {
		
		Complex complex = new Complex();
		complex.setComplexName("Karmaşık Ad");
		complex.setComplexValue(123.45);
		complex.setComplexKind(ComplexKind.MEDIUM); // 1 
		complex.setComplexDate(new Date(System.currentTimeMillis()));
		complex.setTemporaryField("Geçici Değer");

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("OurPersistenceUnit");
		EntityManager entityManager = factory.createEntityManager();

		entityManager.getTransaction().begin();

		entityManager.persist(complex);

		entityManager.getTransaction().commit();

		entityManager.close();
	}
}
