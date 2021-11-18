package com.esmasuyolu.human.test;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.esmasuyolu.human.entity.Department;
import com.esmasuyolu.human.entity.Employee;

public class RelationPersist {

	public static void main(String[] args) {

		Department departmentA =  new Department(0, "Satış");
		departmentA.setEmployeeList(new ArrayList<Employee>());
		
		Employee employee1 = new Employee(0, "Sadettin Kaynak", 6230);
		employee1.setDepartment(departmentA);
		departmentA.getEmployeeList().add(employee1);
		
		Employee employee2 = new Employee(0, "Selahattin Pınar", 7615);
		employee2.setDepartment(departmentA);
		departmentA.getEmployeeList().add(employee2);
		
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("MyPersistenceUnit");
		EntityManager entityManager = factory.createEntityManager();


		entityManager.getTransaction().begin(); 
		entityManager.persist(departmentA);
		entityManager.getTransaction().commit();

		entityManager.close();


	}
}
