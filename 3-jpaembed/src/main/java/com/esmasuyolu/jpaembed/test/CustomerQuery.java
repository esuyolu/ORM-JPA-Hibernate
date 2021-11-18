package com.esmasuyolu.jpaembed.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.esmasuyolu.jpaembed.entity.Customer;

public class CustomerQuery {

	public static void main(String[] args) {
		
		String districtName = "Fatih";

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("TheirPersistenceUnit");
		EntityManager entityManager = factory.createEntityManager();

		String jpql = " select customer from Customer as customer "
				+ " where customer.address.districtName = :districtName ";
		TypedQuery<Customer> query = entityManager.createQuery(jpql, Customer.class);
		query.setParameter("districtName", districtName);

		List<Customer> customerList = query.getResultList();

		entityManager.close(); 

		for (Customer customer : customerList) {
			System.out.println(customer.getCustomerId()
					+ " " + customer.getCustomerName()
					+ " " + customer.getAddress().getProvinceName()
					+ " " + customer.getAddress().getDistrictName()
					+ " " + customer.getAddress().getAddressLine1()
					+ " " + customer.getAddress().getAddressLine2());
		}
	}
}
