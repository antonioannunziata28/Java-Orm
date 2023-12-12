package it.betacom.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import it.betacom.entity.Employee;

public class DeleteEmployee {

	public static void main(String[] args) {
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("JpaProject");
		EntityManager entityManager = emFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		Employee employee = entityManager.find(Employee.class, 2);
		entityManager.remove(employee);
		entityManager.getTransaction().commit();
		entityManager.close();
		emFactory.close();
	}

}
