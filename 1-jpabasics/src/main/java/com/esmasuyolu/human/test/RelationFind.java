package com.esmasuyolu.human.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.esmasuyolu.human.entity.Department;
import com.esmasuyolu.human.entity.Employee;

public class RelationFind {

public static void main(String[] args) {
		
		long departmentId = 1;

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("MyPersistenceUnit");
		EntityManager entityManager = factory.createEntityManager();

		Department department = entityManager.find(Department.class, departmentId);
		
		entityManager.close();
		
		System.out.println(department.getDepartmentId() + " "
				+ department.getDepartmentName());
		for (Employee employee : department.getEmployeeList()) {
			System.out.println(employee.getEmployeeId() + " "
					+ employee.getEmployeeName() + " "
					+ employee.getMonthlySalary());
		}

	}
}
