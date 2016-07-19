package myapp.jdbc.common;

public interface QUERIES {
	
	String INSERT_INTO_DB = "insert into employee (id, name, age) values (?,?,?)";
	String GET_ALL_EMPLOYEES = "select * from employee";
    String GET_EMPLOYEE_BY_ID = "select * from employee where id= ?";
    String GET_EMPLOYEE_BY_NAMe = "select * from employee where name = ?";
    String DELETE_AN_EMPLOYEE = "delete from employee where id = ?";
    String UPDATE_AN_EMPLOYEE = "update employee set name = ?, age = ?, id = ?";
    
    
}
