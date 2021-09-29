package com.yash.ems.daoimpl;

/*
 * functionalities related to Employee CRUD are implemented here 
 * using Java database connectivity
 * 
 *@author kushagra.sharma
 *
 */

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.yash.ems.dao.EmployeeDao;
import com.yash.ems.model.Employee;
import com.yash.ems.daoimpl.EmployeeDaoImpl;
import com.yash.ems.util.GetConnection;

public class EmployeeDaoImpl implements EmployeeDao
{
	Logger log = Logger.getLogger(EmployeeDaoImpl.class);

	@Override
	public void saveEmployee(Employee employee)
	{
		try(Connection con = GetConnection.getConn();
				PreparedStatement pst = (PreparedStatement) con.prepareStatement
				("Insert into employee(name,salary,department,designation,address) values(?,?,?,?,?)");) 
			{
			
				pst.setString(1, employee.getName());
				pst.setDouble(2, employee.getSalary());
				pst.setString(3, employee.getDepartment());
				pst.setString(4, employee.getDesignation());
				pst.setString(5, employee.getAddress());
				pst.executeUpdate();
			
				log.info("\nRecord added successfully..");
			
			}catch(Exception e)
			{
				log.warn("Something went wrong...");
				e.printStackTrace();
			}
	}

	@Override
	public List<Employee> getEmployeeList() {
		try(Connection con = GetConnection.getConn();
				Statement st = con.createStatement();)
		{
			List<Employee> emplist = new ArrayList<Employee>();
			String q1="Select * from employee";
			
			ResultSet rs = st.executeQuery(q1);
			while(rs.next())
			{
				int id = rs.getInt(1);
				String name = rs.getString(2);
				Double salary = rs.getDouble(3);
				String department = rs.getString(4);
				String designation = rs.getString(5);
				String address = rs.getString(6);
				
				Employee e = new Employee(id,name,salary,department,designation,address);
				
				emplist.add(e);
				
			}
			return emplist;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void updateEmployee(Employee employee) 
	{
		try(Connection con = GetConnection.getConn();
				PreparedStatement pst = (PreparedStatement) con.prepareStatement
				("Update employee set name=?,salary=?,department=?,designation=?,address=? where id=?");) 
			{
				
				pst.setString(1, employee.getName());
				pst.setDouble(2, employee.getSalary());
				pst.setString(3, employee.getDepartment());
				pst.setString(4, employee.getDesignation());
				pst.setString(5, employee.getAddress());
				pst.setLong(6, employee.getId());
				pst.executeUpdate();
				
				log.info("\nRecord updated successfully..");
				
				
			}catch(Exception e)
			{
				log.warn("Something went wrong...");
				e.printStackTrace();
			}
		
		
	}

	@Override
	public void deleteEmployee(int eid) 
	{
		
		try(Connection con = GetConnection.getConn();
				PreparedStatement pst = (PreparedStatement) con.prepareStatement
				("Delete from employee where id=?");)
			{
				pst.setInt(1, eid);
				int i = pst.executeUpdate();
				log.info("\n"+i+" Record deleted\n");
				
			}
			catch(Exception e)
			{
				log.warn("Something went wrong...");
				e.printStackTrace();
			}
			
		
	}

}
