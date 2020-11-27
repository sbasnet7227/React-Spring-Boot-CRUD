package net.javaguides.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.bytebuddy.asm.Advice.Return;
import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.service.EmployeeService;

//@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	//get all employees
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		
		return employeeService.getAllEmployees();
		
	}
		//get employee by id rest api
	
		@GetMapping("/employees/{id}")
		public Employee getEmployeeById(@PathVariable("id") long id) {
			
		Employee employee = employeeService.geEmployeeById(id).orElse(null);
			
			if(employee == null)
			{
				throw new RuntimeException("Not Found");
		}
		
			return employee;
			
		}
		
		// create employee rest api
		
		@PostMapping("/employees")
		public Employee createEmployee(@RequestBody Employee employee) {
			
			return employeeService.createEmployee(employee);
		}
		
		//Update employee rest api
		
		@PutMapping("/employees/{id}")
		public Employee updateEmployee(@PathVariable("id") long id , @RequestBody Employee employee) {
			
			employee.setId(id);
			return employeeService.updateEmployee(employee);
		}
		
		//Delete employee rest api
		
		@DeleteMapping("/employees/{id}")
		public void delete(@PathVariable("id") long id) {
			employeeService.delete(id);
			
		}
		
	}

