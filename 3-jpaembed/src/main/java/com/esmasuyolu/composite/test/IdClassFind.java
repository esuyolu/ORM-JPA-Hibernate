package com.esmasuyolu.composite.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.esmasuyolu.composite.entity.Director;
import com.esmasuyolu.composite.entity.DirectorId;

public class IdClassFind {

	public static void main(String[] args) {

		long employeeId = 2;
		long projectId = 2;

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("TheirPersistenceUnit");
		EntityManager entityManager = factory.createEntityManager();
		
		DirectorId directorId = new DirectorId(employeeId,projectId);

		Director director = entityManager.find(Director.class, directorId);

		entityManager.close();

		System.out.println(director.getEmployeeId()
				+ " " + director.getProjectId()
				+ " " + director.getDirectoryTitle());
	}
}
