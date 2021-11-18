package com.esmasuyolu.human.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.esmasuyolu.human.entity.Employee;

public class RelationQuery {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("MyPersistenceUnit");
		EntityManager entityManager = factory.createEntityManager();

		String jpql = "select employee from Employee as employee"
				+ " where employee.department.departmentId = :departmentId";
		TypedQuery<Employee> query = entityManager.createQuery(jpql, Employee.class);
		query.setParameter("departmentId", 1L);
		List<Employee> employeeList = query.getResultList();

		entityManager.close(); 

		for (Employee employee : employeeList) {
			System.out.println(employee.getEmployeeId() + " " 
								+ employee.getEmployeeName() + " " 
								+ employee.getMonthlySalary() + " "
								+ employee.getDepartment().getDepartmentId() + " "
								+ employee.getDepartment().getDepartmentName());
		}
	}
}
