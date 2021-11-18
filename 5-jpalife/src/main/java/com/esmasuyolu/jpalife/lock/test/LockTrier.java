package com.esmasuyolu.jpalife.lock.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.esmasuyolu.jpalife.lock.entity.Shared;

public class LockTrier {

	public static void main(String[] args) {

		long sharedId = 1;

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ItsPersistenceUnit");
		EntityManager entityManager = factory.createEntityManager();
		
		entityManager.getTransaction().begin();

		Shared shared = entityManager.find(Shared.class, sharedId);
		System.out.println("sürüm sayısı: " + shared.getVersionNumer());
		
		shared.setSharedName("paylaşılan güncellendi - kilit açıldı");
		
		entityManager.merge(shared);

		entityManager.getTransaction().commit();

		entityManager.close();
	}
}
