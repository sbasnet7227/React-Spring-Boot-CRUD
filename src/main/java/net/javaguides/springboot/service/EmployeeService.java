package net.javaguides.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.repository.EmployeeRepository;

@Component
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public List<Employee> getAllEmployees() {
		
		return employeeRepository.findAll();
	}

	public Optional<Employee>geEmployeeById(long id) {
		
		return employeeRepository.findById(id);
	}

	public Employee createEmployee(Employee employee) {
		
		return employeeRepository.save(employee);
		
	}

	public Employee updateEmployee(Employee employee) {
		
		return employeeRepository.save(employee);
	}

	public void delete(long id) {
		
		employeeRepository.deleteById(id);
		
	}
}
