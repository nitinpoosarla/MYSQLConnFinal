package com.ApplicationRun.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ApplicationRun.DAO.EmployeeDAO;
import com.ApplicationRun.model.Employee;



@RestController

@RequestMapping("/company")
public class EmployeeController 
{
    
	@Autowired
	EmployeeDAO empdao;
	
	//save emp data in db
	@PostMapping("/employee")
	public Employee createEmployee(@RequestBody  Employee emp)
	{
		return empdao.save(emp);	
	}	
	//get emp data in db
	@GetMapping("/employee")
	public List<Employee> getAllEmployees()
	{
		return empdao.findAll();
	}
   //get emp databy ID
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id)
	{
		Employee emp=empdao.findOne(id);
		if(emp == null)
		{
		return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(emp);
	}
	
	//update emp
	@PutMapping("/employee/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value="id") Long empid,@RequestBody  Employee emp)
	{
		Employee emp1=empdao.findOne(empid);
		if(emp == null)
		{
		return ResponseEntity.notFound().build();
		}
		emp1.setName(emp.getName());
		emp1.setExpertise(emp.getExpertise());
		emp1.setDesignation(emp.getDesignation());
	
		empdao.save(emp1);
		return ResponseEntity.ok().body(emp1);
	}
	
	//deleteemployee
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable(value="id") Long empid)
	{
		Employee emp=empdao.findOne(empid);
		if(emp == null)
		{
		return ResponseEntity.notFound().build();
		}
		
		empdao.delete(emp);
		return ResponseEntity.ok().body(emp);
		
	}
}
