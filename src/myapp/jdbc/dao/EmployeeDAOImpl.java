package myapp.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import myapp.jdbc.common.ConnectionFactory;
import myapp.jdbc.common.QUERIES;
import myapp.jdbc.common.ResultSetMapper;
import myapp.jdbc.model.Employee;

public class EmployeeDAOImpl implements EmployeeDAO{

	@Override
	public void saveEmployee(Employee emp) {

		Connection conn = ConnectionFactory.getConnection();
		try
		{
			PreparedStatement ps = conn.prepareStatement(QUERIES.INSERT_INTO_DB);
		    // Statement stmt=conn.createStatement("select * from employee where id = "+ id); 

			ps.setInt(1, emp.getId());
			ps.setString(2, emp.getName());
			ps.setInt(3, emp.getAge());


			int n =  ps.executeUpdate();

			System.out.println("Number of records inserted into db : "+ n);
		}
		catch(Exception e)
		{
			System.out.println("Exception occured while saving the employee, "+ emp + ": "+ e);
		}



	}

	@Override
	public List<Employee> listEmployee() {

		List<Employee> empList = new ArrayList<Employee>();

		Connection conn = ConnectionFactory.getConnection();
		try
		{
			PreparedStatement ps = conn.prepareStatement(QUERIES.GET_ALL_EMPLOYEES);
			ResultSet rs =  ps.executeQuery();

			empList = ResultSetMapper.resultSetToList(rs);
		}
		catch(Exception e)
		{
			System.out.println("Exception occured while fetching all the employees from db " + e);
		}

		return empList;

	}

	@Override
	public Employee getEmployeeById(int id) {

		Connection conn = ConnectionFactory.getConnection();
		
		Employee emp = null;

		try
		{
			PreparedStatement ps = conn.prepareStatement(QUERIES.GET_EMPLOYEE_BY_ID);
			ps.setInt(1, id);

			ResultSet rs=  ps.executeQuery();

			List<Employee> empList = ResultSetMapper.resultSetToList(rs);
			
			if(empList.size() > 0)
				emp = empList.get(0);
		}
		catch(Exception e)
		{
			System.out.println("Exception occured while saving the employee, "+ emp + ": "+ e);
		}
		return emp;
	}

	@Override
	public List<Employee> getEmployeeByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateEmployee(Employee emp) {
		// TODO Auto-generated method stub

	}

	@Override
	public int deleteEmployees(Employee emp) {
		// TODO Auto-generated method stub
		return 0;
	}

}
