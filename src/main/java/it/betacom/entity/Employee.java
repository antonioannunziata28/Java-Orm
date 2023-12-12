package it.betacom.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Employee
 *
 */
@Entity

public class Employee implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private double salary;
	private String deg;
	
	private static final long serialVersionUID = 1L;

	public Employee(int id, String name, double salary, String deg) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.deg = deg;
	}

	public Employee() {
		super();
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	public String getDeg() {
		return deg;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public void setDeg(String deg) {
		this.deg = deg;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", deg=" + deg + "]";
	}
   
	
	
}
