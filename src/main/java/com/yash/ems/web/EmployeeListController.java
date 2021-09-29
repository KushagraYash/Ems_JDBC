package com.yash.ems.web;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
@RequestMapping("/list")
public class EmployeeListController 
{
	EmployeeDaoImpl empdao = new EmployeeDaoImpl();
	
	/*
	* This method will serve as default GET handler.
	*/
	
	@RequestMapping(method = RequestMethod.GET)
	public String getList(ModelMap model) 
	{
		List<Employee> emplist = empdao.getEmployeeList();
		model.addAttribute("emplist", emplist);
		return "empllist";
	}
	
}
