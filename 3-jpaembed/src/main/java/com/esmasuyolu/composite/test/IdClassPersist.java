package com.esmasuyolu.composite.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.esmasuyolu.composite.entity.Director;
import com.esmasuyolu.composite.entity.Employee;
import com.esmasuyolu.composite.entity.Project;

public class IdClassPersist {

	public static void main(String[] args) {
		Employee employee = new Employee(0, "Çalışan 2");
		Project project = new Project(0, "İzdüşü B");
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("TheirPersistenceUnit");
		EntityManager entityManager = factory.createEntityManager();

		entityManager.getTransaction().begin(); 

		entityManager.persist(employee);
		entityManager.persist(project);

		entityManager.getTransaction().commit();
		
		Director director = new Director(employee.getEmployeeId(), project.getProjectId(), "Mühendis");

		entityManager.getTransaction().begin(); 

		entityManager.persist(director);

		entityManager.getTransaction().commit();
		
		entityManager.close();
	}
}
