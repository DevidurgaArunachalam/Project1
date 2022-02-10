package com.employee.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;

import com.employee.view.EmployeeDetails;

/**
 * <p>
 *     Employee Management System using Collection by implementing 
 *     CRUD OPERATIONS like, add employee details,view details,update
 *     if needed and delete the details by providing switch case to follow the flow
 *     as per user's choice.
 * </p>
 * 
 * @author Devidurga Arunachalam
 */
public class EmployeeManagement {
  
    private static final String LOG_FILE = "log4.properties";
    private static Properties properties=new Properties();

   	public static void main(String[] args) throws FileNotFoundException, IOException {
   	 
   	properties.load(new FileInputStream(LOG_FILE));
   	PropertyConfigurator.configure(properties);

   	   do {
			System.out.println(
			    "\nEmployee Management System\n1.Add Employee\n2.View EmployeeList\n3.Update Employee Details\n4.Delete Employee details\nEnter your choice :");
			final int choice = Integer.parseInt(EmployeeDetails.SCANNER.nextLine());

			switch (choice) {
			case 1:
			    EmployeeDetails.addEmployee();
				break;
			case 2:
			    EmployeeDetails.viewEmployeeDetails();
				break;
			case 3:
			    EmployeeDetails.updateEmployeeDetails();
				break;
			case 4:
			    EmployeeDetails.deleteEmployee();
				break;
 			default:
			    EmployeeDetails.SCANNER.close();
				System.exit(0);
			}
		} while (true);
	}
}

