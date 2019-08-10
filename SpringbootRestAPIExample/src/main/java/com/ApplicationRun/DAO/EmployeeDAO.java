package com.ApplicationRun.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.ApplicationRun.model.Employee;
import com.ApplicationRun.repository.EmployeeRepository;



@Service

public class EmployeeDAO 
{
	@Autowired
	EmployeeRepository  er;

	//insert
	public Employee save(Employee emp)
	{
		return er.save(emp);
	}
	//search
	public List<Employee> findAll()
	{
		return er.findAll();
	}
	
	//getbyid
	public Employee findOne(Long empid)
	{
		return er.getOne(empid);
	}
	
	public void delete(Employee emp)
	{
		er.delete(emp);
	}
}
