package it.betacom.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import it.betacom.entity.Employee;

public class CreateEmployee {

	public static void main (String[] args) {
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("JpaProject");
		EntityManager entityManager = emFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		
//		Employee employee = new Employee();
//		employee.setName("Maria");
//		employee.setSalary(2000);
//		employee.setDeg("Java Developer");
//		entityManager.persist(employee);
//		
//		Employee employee2 = new Employee();
//		employee2.setName("Sergio");
//		employee2.setSalary(1900);
//		employee2.setDeg("Php Developer");
//		entityManager.persist(employee2);
		
		Employee employee3 = new Employee();
		employee3.setName("Alfredo");
		employee3.setSalary(3500);
		employee3.setDeg("Abap Developer");
		entityManager.persist(employee3);
		
		entityManager.getTransaction().commit();
		entityManager.close();
		emFactory.close();
	}
}
