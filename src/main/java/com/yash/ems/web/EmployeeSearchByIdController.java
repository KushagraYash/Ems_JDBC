package com.yash.ems.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.yash.ems.serviceimpl.EmployeeServiceImpl;
import com.yash.ems.model.Employee;
/**
 * 
 * @author kushagra.sharma
 *
 */
@Controller
@RequestMapping("/searchbyid")
public class EmployeeSearchByIdController 
{
	EmployeeServiceImpl empser = new EmployeeServiceImpl();
	
	/*
	* This method will serve as default GET handler
	*/
	
	@RequestMapping(method = RequestMethod.GET)
	public String searchpage(ModelMap model) 
	{
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "searchbyid";
	}
	
	/*
	* This method will be called on form submission, handling POST request It
	* also validates the user input
	*/
	
	@RequestMapping(method = RequestMethod.POST)
	public String searchEmp(Employee employee,BindingResult result, ModelMap model)
	{
		int empid = (int) employee.getId();
		Employee e = empser.searchEmployeeById(empid);
		model.addAttribute("employee", e);
		model.addAttribute("success", "Record found !!!");
		return "success";
	}
}
