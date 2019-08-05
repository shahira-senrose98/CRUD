package service;

import java.util.List;

import pojo.Employee;

public interface EmployeeService {

	void invokeAddEmployee(Employee employee);

	void invokeUpdateEmployee(Employee employee);
	
	Employee invokeGetEmployeeById(int employeeId);
	
	List<Employee> invokeListEmployees();
	
	void invokeRemoveEmployee(int employeeId);
	
}