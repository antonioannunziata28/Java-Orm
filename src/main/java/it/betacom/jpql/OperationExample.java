package it.betacom.jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class OperationExample {

	public static void main(String[] args) {
		
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("JpaProject");
		EntityManager entityManager = emFactory.createEntityManager();
		
		Query query = entityManager.createQuery("SELECT UPPER(e.name) from Employee e");
		List<String> list = query.getResultList();
		System.out.println("Lista degli impiegati in maiuscolo");
		
		for(String s : list) {
			System.out.println("Nome Impiegato: " + s);
		}
		
		Query queryMaxSalary = entityManager.createQuery("SELECT MAX (e.salary) from Employee e");
		Double maxSalary = (Double) queryMaxSalary.getSingleResult();
		System.out.println("Salario Massimo: €" + maxSalary);
		
		entityManager.close();
		emFactory.close();
	}

}
