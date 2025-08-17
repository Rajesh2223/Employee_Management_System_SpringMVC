package com.Employee.DAO;

import java.util.List;

import com.Employee.entity.EmployeeDetails;

public interface EmployeeDAO {

	EmployeeDetails insertEmployeeDetails(EmployeeDetails employeeDetails);
	List<EmployeeDetails> getAllEmployeeDetails();
	boolean deleteEmployeeByUsingId(int  id);
}
