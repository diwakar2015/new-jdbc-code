package myapp.jdbc.controller;

import java.util.List;
import java.util.Scanner;

import myap.jdbc.app.Menu;
import myapp.jdbc.dao.EmployeeDAO;
import myapp.jdbc.dao.EmployeeDAOImpl;
import myapp.jdbc.model.Employee;

public class RequestController {

	public void dispatchRequest(int choice)
	{

		Scanner sc = new Scanner(System.in);
		EmployeeDAO empDAO = new EmployeeDAOImpl();

		switch (choice) {
		case 1:
			System.out.println("Enter the details of the employee");
			int id = sc.nextInt();
			String name = sc.next();
			int age = sc.nextInt();

			Employee emp = new Employee(id, name, age);
			empDAO.saveEmployee(emp);
			System.out.println("Employee record is saved in DB successfully!");
			break;

		case 2:

			List<Employee> empList = empDAO.listEmployee();
			System.out.println("Total number of employees : "+ empList.size());

			for(Employee e : empList)
			{
				System.out.println(e);
			}

			break;
		case 3:

			System.out.println("Provide the Id to find the employee");
			int empId = sc.nextInt();
			Employee e =  empDAO.getEmployeeById(empId);
			if(e!= null)
				System.out.println(e);
			else
			{
				System.out.println("No such employee found in the database");
			}

			break;
		case 4:
            System.exit(0);
			break;

		default:
			System.out.println("Please provide the correct input(from 1 to 4)");
			break;
		}

		Menu.displayMenu();
	}

}
