package com.yash.ems.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yash.ems.daoimpl.EmployeeDaoImpl;
import com.yash.ems.model.Employee;

/**
 * 
 * @author kushagra.sharma
 *
 */
@Controller
@RequestMapping("/update")
public class EmployeeUpdateController 
{
	EmployeeDaoImpl empdao = new EmployeeDaoImpl();
	
	/*
	* This method will serve as default GET handler.
	*/
	
	@RequestMapping(method = RequestMethod.GET)
	public String newRegistration(ModelMap model) 
	{
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "updateform";
	}
	
	/*
	* This method will be called on form submission, handling POST request It
	* also validates the user input
	*/
	
	@RequestMapping(method = RequestMethod.POST)
	public String saveRegistration(Employee employee, ModelMap model)
	{
		empdao.updateEmployee(employee);
		
		model.addAttribute("success", "Dear " + employee.getName() + " , your record updated successfully");
		return "successupdation";
	}
	
	
	/*
	* Method used to populate the Department list in view. Note that here you can
	* call external systems to provide real data.
	*/
	
	@ModelAttribute("department")
	public List<String> initializeDepartments()
	{
		/**
		 * this is the list of department
		 */
		List<String> department = new ArrayList<String>();
		department.add("IT");
		department.add("Testing");
		department.add("Research");
		department.add("HR");
		department.add("Finance");
		return department;
	}
	
	/*
	* Method used to populate the country list in view. Note that here you can
	* call external systems to provide real data.
	* 
	*/
	
	@ModelAttribute("countries")
	public List<String> initializeCountries()
	{
		/**
		 * list of Address
		 * 
		 */
		List<String> countries = new ArrayList<String>();
		countries.add("INDIA");
		countries.add("USA");
		countries.add("UAE");
		countries.add("GERMANY");
		countries.add("ITALY");
		countries.add("OTHER");
		return countries;
	}
	
	
}
