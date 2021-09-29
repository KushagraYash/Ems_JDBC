package com.yash.ems.service;

import com.yash.ems.model.Employee;

/*
 * Interface having declaration of all the service methods of Employee
 * it provides standardization to the application
 * 
 *@author kushagra.sharma
*/

public interface EmployeeService 
{
	
	/* this searchEmployeeById method is used for fetching records 
	 * of employee on the basis of eid */
	
	public Employee searchEmployeeById(int eid);
	
	/* this searchEmployeeByName method is used for fetching records 
	 * of employee on the basis of ename */
	
	public Employee searchEmployeeByName(String ename);

}
