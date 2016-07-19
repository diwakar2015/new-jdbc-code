package myap.jdbc.app;
import java.util.Scanner;

import myapp.jdbc.controller.RequestController;


public class Menu {


	public static void displayMenu()
	{

		RequestController rc = new RequestController();
		
		System.out.println("***************Employee Management System **********************");

		System.out.println("Press 1. To add new employee");
		System.out.println("Press 2. To list all the employees");
		System.out.println("Press 3. To find employee by Id");
		System.out.println("Press 4. To Exit");

		try
		{

			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();
			
			rc.dispatchRequest(choice);
		}
		catch(Exception e)
		{
			System.out.println("Invalid input provided!!");
			displayMenu();
		}
	
	}

}
