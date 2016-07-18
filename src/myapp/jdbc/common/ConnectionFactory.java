package myapp.jdbc.common;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	private static Connection _connection = null;
	
	private ConnectionFactory() {}

	static
	{
		try
		{
			Class.forName(DatabaseConstants.DRIVER);
			_connection = DriverManager.getConnection(DatabaseConstants.URL+DatabaseConstants.DATABASE_NAME, DatabaseConstants.USER, 
					DatabaseConstants.PASSWORD);
			if(_connection != null)
			{
				System.out.println("Application is connected to MYSQL successfully!!");
			}
			else
			{
				System.out.println("Application is not connected!!!!!!");
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception occured while establishing the connection to MYSQL : "+ e);
		}

	}

	public static Connection getConnection()
	{
		return _connection;
	}

}
