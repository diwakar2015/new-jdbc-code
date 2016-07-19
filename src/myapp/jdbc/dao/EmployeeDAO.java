package myapp.jdbc.dao;
import java.util.List;

import myapp.jdbc.model.Employee;


public interface EmployeeDAO {
	
	public void saveEmployee(Employee emp);
	public List<Employee> listEmployee();
	public Employee getEmployeeById(int id);
	public List<Employee> getEmployeeByName(String name);
	
	public void updateEmployee (Employee emp);
	public int deleteEmployees(Employee emp);


}
