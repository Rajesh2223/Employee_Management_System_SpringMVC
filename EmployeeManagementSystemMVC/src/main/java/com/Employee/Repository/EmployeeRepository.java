package com.Employee.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Employee.entity.EmployeeDetails;

public interface EmployeeRepository  extends JpaRepository<EmployeeDetails, Integer> {

}
