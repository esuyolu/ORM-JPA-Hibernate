package com.esmasuyolu.composite.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.esmasuyolu.composite.entity.Participant;
import com.esmasuyolu.composite.entity.ParticipantId;

public class EmbeddedIdFind {

	public static void main(String[] args) {

		long employeeId = 1;
		long projectId = 1;

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("TheirPersistenceUnit");
		EntityManager entityManager = factory.createEntityManager();
		
		ParticipantId participantId = new ParticipantId(employeeId,projectId);

		Participant participant = entityManager.find(Participant.class, participantId);

		entityManager.close();

		System.out.println(participant.getParticipantId() 
				+ " " + participant.getRoleName());
	}
}
