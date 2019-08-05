package controller;

import java.sql.SQLException; 
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import pojo.Employee;
import service.EmployeeService;
import service.EmployeeServiceImpl;

public class EmployeeController {

	EmployeeService service;
	Scanner sc;

	public EmployeeController() {
		initializeComponents();
	}

	public void start() {

		System.out.println("Select choice: ");
		System.out.println("1) Add an employee");
		System.out.println("2) Display all employees");
		System.out.println("3) Update an employee");
		System.out.println("4) Delete an employee");
		System.out.print("\nYour choice: ");
		
		int userChoice = sc.nextInt();
		
		switch (userChoice) {
		
			case 1: addEmployee();
				break;
			case 2: getAllEmployees();
				break;
			case 3: updateEmployee();
				break;
			case 4: removeEmployee();
				break;
			default: System.out.println("Invalid input!");
				break;
		}

	}

	private void removeEmployee() {
		
		// Get ID
		System.out.print("\nEnter employee ID: ");
		int employeeId = sc.nextInt();
		sc.nextLine();
		
		service.invokeRemoveEmployee(employeeId);
		
	}
	
	private void getAllEmployees() {
		
		List<Employee> employees = service.invokeListEmployees();
		displayEmployeeDetails(employees);
	}
	
	
	private void updateEmployee() {
		
		System.out.print("\nEnter employee ID: ");
		int employeeId = sc.nextInt();
		sc.nextLine();
	
		if (service.invokeGetEmployeeById(employeeId) != null) {
			
			System.out.print("Enter new employee name: ");
			String newEmployeeName = sc.nextLine();
			
			System.out.print("Enter new employee password: ");
			String newEmployeePassword = sc.next();
			
			System.out.print("Enter new employee date of birth (DD/MM/YYYY): ");
			String newEmployeeDOB = sc.next();
			
			Employee employee = new Employee();
			employee.setEmployeeId(employeeId);
			employee.setEmployeeName(newEmployeeName);
			employee.setPassword(newEmployeePassword);
			employee.setDateOfBirth(newEmployeeDOB);
			
			service.invokeUpdateEmployee(employee);
		
		} else {
			System.out.println("Sorry! Employee " + employeeId + " does not exist!");
		}
	}

	private void addEmployee() {
		
		System.out.print("\nEnter employee ID: ");
		int employeeId = sc.nextInt();
		sc.nextLine();

		System.out.print("Enter employee name: ");
		String employeeName = sc.nextLine();

		System.out.print("Enter employee password: ");
		String employeePassword = sc.next();

		System.out.print("Enter employee date of birth (DD/MM/YYYY): ");
		String employeeDOB = sc.next();
		
		Employee employee = new Employee();
		employee.setEmployeeId(employeeId);
		employee.setEmployeeName(employeeName);
		employee.setPassword(employeePassword);
		employee.setDateOfBirth(employeeDOB);
		
		service.invokeAddEmployee(employee);
	}

	private void initializeComponents() {

		try {
			service = new EmployeeServiceImpl();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		sc = new Scanner(System.in);
	}
	
	private void displayEmployeeDetails(List<Employee> employees) {
		
		System.out.println("\nEmployee ID\tName\t\t\tPassword\t\tDate of Birth");
		System.out.println("================================================" + 
							"===================================");
		
		for(Employee e: employees) {
			System.out.println(e.getEmployeeId() + "\t\t" 
							+ e.getEmployeeName() + "\t\t" 
							+ e.getPassword() + "\t\t" 
							+ e.getDateOfBirth());
		}
		
	}

	

}

