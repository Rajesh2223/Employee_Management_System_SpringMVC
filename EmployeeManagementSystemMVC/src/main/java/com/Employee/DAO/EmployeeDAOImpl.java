package com.Employee.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Employee.entity.EmployeeDetails;
import com.Employee.Repository.EmployeeRepository;

@Component
public class EmployeeDAOImpl implements EmployeeDAO {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public EmployeeDetails insertEmployeeDetails(EmployeeDetails employeeDetails) {

		return employeeRepository.save(employeeDetails);
	}

	@Override
	public List<EmployeeDetails> getAllEmployeeDetails() {
		// TODO Auto-generated method stub
		return  employeeRepository.findAll();
	}

	@Override
	public boolean deleteEmployeeByUsingId(int id) {
		// TODO Auto-generated method stub
		//employeeRepository.deleteById(id);
		Optional<EmployeeDetails>  optional=employeeRepository.findById(id);
		try {
			EmployeeDetails details=optional.get();
			employeeRepository.delete(details);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	

	

	

}