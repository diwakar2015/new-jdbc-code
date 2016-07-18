import myapp.jdbc.common.ConnectionFactory;
import myapp.jdbc.dao.EmployeeDAO;
import myapp.jdbc.dao.EmployeeDAOImpl;
import myapp.jdbc.model.Employee;


public class MainApp {


	public static void main(String[] args) {
		
		//Employee emp = new Employee(3, "Monica", 55);
		EmployeeDAO empDAO = new EmployeeDAOImpl();
	/*	empDAO.saveEmployee(emp);
		
		System.out.println("DONE");
		*/
		
		Employee emp = empDAO.getEmployeeById(2);
		System.out.println(emp);

		

	}
}
