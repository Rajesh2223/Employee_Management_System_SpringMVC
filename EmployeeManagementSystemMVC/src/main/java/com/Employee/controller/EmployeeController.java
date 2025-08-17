package com.Employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Employee.DAO.EmployeeDAO;
import com.Employee.entity.EmployeeDetails;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeDAO employeeDAO;
	//All employees related request
	//Registration
	//Login
	//Updation//
	//deletion
	@RequestMapping("/empRegistration")
	public String  employeeRegistration(EmployeeDetails employeeDetails) {
		
		
		
		EmployeeDetails employeeDetails1=employeeDAO.insertEmployeeDetails(employeeDetails);
		if (employeeDetails1!=null) {
			return "redirect:/teca64/allEmployeeDetails";
		}
		else {
			return "redirect:/teca64/registrationpage";
		}
		
	}
	@RequestMapping("/emplogin")
	@ResponseBody
	public String  employeeLogin() {
		System.out.println("Employee Login successfull");
		return "Employee Login Successfull";
	}
	@RequestMapping("/registrationpage")
	public String  employeeRegistrationPage() {
		return "EmployeeRegistration";
	}
	
	@RequestMapping("/allEmployeeDetails")
	public String allEmployeeDetails(Model model) {
		List<EmployeeDetails> allEmployeeDetails=employeeDAO.getAllEmployeeDetails();
		model.addAttribute("listofemployeedetails",allEmployeeDetails);
		return "allEmployeeDetails";
	}
	@RequestMapping("/deletebyid")
	public String deleteById(@RequestParam("empid") int id) {
		System.out.println(id);
		if (employeeDAO.deleteEmployeeByUsingId(id))
		{
			return  "redirect:/teca64/allEmployeeDetails";
		}
		else {
			return "";
		}
	}

}
