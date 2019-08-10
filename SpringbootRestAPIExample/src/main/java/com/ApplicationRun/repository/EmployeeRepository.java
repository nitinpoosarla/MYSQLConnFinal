package com.ApplicationRun.repository;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ApplicationRun.model.Employee;




public interface EmployeeRepository extends JpaRepository<Employee,Long>{

	
}
