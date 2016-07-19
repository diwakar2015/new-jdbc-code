package myapp.jdbc.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import myapp.jdbc.model.Employee;

public class ResultSetMapper {

	public static List<Employee> resultSetToList(ResultSet rs) throws SQLException
	{
		List<Employee> empList = new ArrayList<Employee>();
		if(rs != null)
		{
			while(rs.next())
			{
				int id = rs.getInt(1);
				String name = rs.getString(2);
				int age = rs.getInt(3);

				Employee emp = new Employee(id, name, age);
				empList.add(emp);

			}

		}

		return empList;
	}

}
