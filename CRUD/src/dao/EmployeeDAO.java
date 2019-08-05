package dao;

import java.util.List;
import pojo.Employee;

public interface EmployeeDAO {
	void addEmployee(Employee employee);
	void updateEmployee(Employee employee);
	List<Employee> listEmployee();
	Employee getEmployeeById(int employeeId);
	void removeEmployee(int employeeId);
}
