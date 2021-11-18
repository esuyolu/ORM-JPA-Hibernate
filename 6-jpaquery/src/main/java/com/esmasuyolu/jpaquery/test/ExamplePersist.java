package com.esmasuyolu.jpaquery.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.esmasuyolu.jpaquery.entity.Example;

public class ExamplePersist {

	public static void main(String[] args) {
		
		Example example1 = new Example(0, "�rnek ad 1", 100);
		Example example2 = new Example(0, "�rnek ad 2", 105);
		Example example3 = new Example(0, "�rnek ad 3", 110);
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("HerPersistenceUnit");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		manager.persist(example1);
		manager.persist(example2);
		manager.persist(example3);
		manager.getTransaction().commit();
		
		manager.close();
	}
}
