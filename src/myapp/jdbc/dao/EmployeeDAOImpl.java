package myapp.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import myapp.jdbc.common.ConnectionFactory;
import myapp.jdbc.model.Employee;

public class EmployeeDAOImpl implements EmployeeDAO{

	@Override
	public void saveEmployee(Employee emp) {

		Connection conn = ConnectionFactory.getConnection();
		String sql = "insert into employee (id, name, age) values (?,?,?)";

		try
		{
			PreparedStatement ps = conn.prepareStatement(sql);

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee getEmployeeById(int id) {
		
		Connection conn = ConnectionFactory.getConnection();
		String sql = "select * from employee where id= ?";
		Employee emp = new Employee();

		try
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
		
			ResultSet rs=  ps.executeQuery();
		
			if(rs != null)
			{
				while(rs.next())
				{
					id = rs.getInt(1);
					String name = rs.getString(2);
					int age = rs.getInt(3);
					emp.setId(id);
					emp.setName(name);
					emp.setAge(age);
					
					
				}
				
			}
		
		}
		catch(Exception e)
		{
			System.out.println("Exception occured while saving the employee, "+ emp + ": "+ e);
		}
		return emp;
	}

	@Override
	public List<Employee> getEmployeeByName() {
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
