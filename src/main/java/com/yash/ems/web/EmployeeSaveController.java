package com.yash.ems.web;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
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
@RequestMapping("/save")
public class EmployeeSaveController 
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
		return "enroll";
	}
	
	/*
	* This method will be called on form submission, handling POST request It
	* also validates the user input
	*/
	
	@RequestMapping(method = RequestMethod.POST)
	public String saveRegistration(@Valid Employee employee,BindingResult result, ModelMap model)
	{
		if (result.hasErrors()) 
		{
			return "enroll";
		}
		
		empdao.saveEmployee(employee);
		
		model.addAttribute("success", "Dear " + employee.getName() + " , your registration completed successfully");
		return "success";
	}

	/*
	* Method used to populate the Department list in view. Note that here you can
	* call external systems to provide real data.
	*/
	
	@ModelAttribute("department")
	public List<String> initializeDepartments()
	{
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
	*/
	
	@ModelAttribute("countries")
	public List<String> initializeCountries()
	{
		List<String> countries = new ArrayList<String>();
		countries.add("INDIA");
		countries.add("USA");
		countries.add("UAE");
		countries.add("GERMANY");
		countries.add("ITALY");
		countries.add("OTHER");
		return countries;
	}
	
	/*
	* Method used to populate the projects list in view. Note that here you can
	* call external systems to provide real data.

	
	@ModelAttribute("projects")
	public List<String> initializeProjects() {
	List<String> projects = new ArrayList<String>();
	projects.add("EMS");
	projects.add("HMS");
	projects.add("SMS");
	projects.add("LMS");
	return projects;
	}
		*/
}
