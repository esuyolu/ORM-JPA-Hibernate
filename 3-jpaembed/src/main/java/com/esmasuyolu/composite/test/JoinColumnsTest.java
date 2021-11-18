package com.esmasuyolu.composite.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.esmasuyolu.composite.entity.Director;
import com.esmasuyolu.composite.entity.DirectorId;
import com.esmasuyolu.composite.entity.Participant;
import com.esmasuyolu.composite.entity.ParticipantId;
import com.esmasuyolu.composite.entity.Task;

public class JoinColumnsTest {

	public static void main(String[] args) {
		
		long projectId = 1;
		long employeeId = 1;
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("TheirPersistenceUnit");
		EntityManager entityManager = factory.createEntityManager();

		ParticipantId participantId = new ParticipantId(employeeId, projectId);
		Participant participant = entityManager.find(Participant.class, participantId);
		
		DirectorId directorId = new DirectorId(employeeId, projectId);
		Director director = entityManager.find(Director.class, directorId);
		
		Task task = new Task(0, "O işi bitir", participant, director);
		
		entityManager.getTransaction().begin(); 
		entityManager.persist(task);
		entityManager.getTransaction().commit();
	
		entityManager.close();
	}
}
