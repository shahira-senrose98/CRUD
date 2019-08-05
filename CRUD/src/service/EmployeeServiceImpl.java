package service;

import java.sql.SQLException;
import java.util.List;

import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
import pojo.Employee;

public class EmployeeServiceImpl implements EmployeeService {

	EmployeeDAO dao;
	
	public EmployeeServiceImpl() throws ClassNotFoundException, SQLException {
		
		dao = new EmployeeDAOImpl();
	}
	
	@Override
	public void invokeAddEmployee(Employee employee) {
		
		dao.addEmployee(employee);
	}

	@Override
	public void invokeUpdateEmployee(Employee employee) {
		
		dao.updateEmployee(employee);
	}
	
	@Override
	public void invokeRemoveEmployee(int employeeId) {

		dao.removeEmployee(employeeId);
	}

	@Override
	public Employee invokeGetEmployeeById(int employeeId) {
		
		return dao.getEmployeeById(employeeId);
	}

	@Override
	public List<Employee> invokeListEmployees() {
		
		return dao.listEmployee();
	}

}
