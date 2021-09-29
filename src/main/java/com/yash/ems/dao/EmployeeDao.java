package com.yash.ems.dao;

import java.util.List;

import com.yash.ems.model.Employee;

/*
 * Interface having declaration of all the CRUD methods of Employee
 * it provides standardization to the application
 * 
 * @author kushagra.sharma
*/

public interface EmployeeDao 
{
	
	/* this saveEmployee method is used for inserting records into table employee */
	
	public void saveEmployee(Employee employee);
	
	/* this getEmployeeList method is used for fetching records from table employee */
	
	public List<Employee> getEmployeeList();
	
	/* this updateEmployee method is used for updating records into table employee */
	
	public void updateEmployee(Employee employee);
	
	/* this deleteEmployee method is used for deleting records from table employee */
	
	public void deleteEmployee(int eid);
}
