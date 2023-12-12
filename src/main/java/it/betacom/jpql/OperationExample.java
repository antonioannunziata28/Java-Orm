package it.betacom.jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import it.betacom.entity.Employee;

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
		
		Query queryListEmployeeAsc = entityManager.createQuery("SELECT e from Employee e "
				+ "order by e.name ASC");
		List<Employee> listEmployee = queryListEmployeeAsc.getResultList();
		for(Employee e : listEmployee) {
			System.out.println(e);
		}
		
		Query queryBetween = entityManager.createQuery("SELECT e from Employee e "
				+ "WHERE e.salary between 100 and 2000 ");
		List<Employee> listEmployeeBetween = queryListEmployeeAsc.getResultList();
		for(Employee e : listEmployeeBetween) {
			System.out.println(e);
		}
		
		Query queryLike = entityManager.createQuery("SELECT e from Employee e "
				+ "WHERE e.name like 'S%'");
		List<Employee> listEmployeeLike = queryListEmployeeAsc.getResultList();
		for(Employee e : listEmployeeLike) {
			System.out.println(e);
		}
		
		entityManager.getTransaction().begin();
		Query queryDelete = entityManager.createQuery("DELETE from Employee e "
				+ "WHERE e.salary > :p");
		int deletedEmployee = queryDelete.setParameter("p", 2400).executeUpdate();
		entityManager.getTransaction().commit();
		System.out.println("Record cancellati: " + deletedEmployee);
		
		
		
		entityManager.close();
		emFactory.close();
	}

}
