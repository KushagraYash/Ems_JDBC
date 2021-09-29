package com.yash.ems.model;
/*
 *  POJO Employee class 
 *  containing instance variables, constructors
 *  getters setters and toString() method
 * 
 * @author kushagra.sharma
 *
 */

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Employee 
{
	/* id stores the value of employee id */
	private long id;
	
	/* name stores the value of employee name */
	
	@Size(min=3, max=30) 
	@NotEmpty
	private String name;
	
	/* salary stores the value of employee salary */
	
	//@NotEmpty
	private double salary;
	
	/* department stores the value of employee department */
	
	@NotEmpty
	private String department;
	
	/* designation stores the value of employee designation */
	
	private String designation;
	
	/* address stores the value of employee address */

	@NotEmpty
	private String address;
	
	/* default constructor */
	
	public Employee() {
		super();
	}

	/* parametrized constructor for initializing values to instance variables */
	
	public Employee(long id, String name, double salary, String department, String designation, String address) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.department = department;
		this.designation = designation;
		this.address = address;
	}

	/* setters for all instance variables */
	
	public void setId(long id) {
		this.id = id;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setSalary(double salary) {
		this.salary = salary;
	}


	public void setDepartment(String department) {
		this.department = department;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	/* getters for all instance variables */
	
	public long getId() {
		return id;
	}


	public String getName() {
		return name;
	}


	public double getSalary() {
		return salary;
	}


	public String getDepartment() {
		return department;
	}


	public String getDesignation() {
		return designation;
	}


	public String getAddress() {
		return address;
	}


	/* toString() to print the object of employee */
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", department=" + department
				+ ", designation=" + designation + ", address=" + address + "]\n";
	}
	
	
	
}
