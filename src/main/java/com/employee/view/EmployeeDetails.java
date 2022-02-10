package com.employee.view;

import com.employee.exception.CustomException.ConenctionNotFoundException;
import com.employee.exception.CustomException.DataNotFoundException;
import com.employee.exception.CustomException.IdAlreadyExistsException;
import com.employee.exception.CustomException.IdNotFoundException;
import com.employee.service.EmployeeDetailsValidation;
import com.employee.controller.EmployeeController;
import com.employee.model.Employee;

import java.util.Map;
import java.util.Scanner;

import org.apache.log4j.Logger;

import java.sql.Date;

/**
 * Used to obtain the input from the user
 * 
 * @author DeviDurga Arunachalam
 */
public class EmployeeDetails {
	public static final Scanner SCANNER = new Scanner(System.in);
	public static final EmployeeController EMPLOYEECONTROLLER = new EmployeeController();
	public static final Logger LOGGER = Logger.getLogger(EmployeeDetails.class);

   /**
	* Used to get the user Id in the numerical values
	* 
	* @return employeeId
    */
	public static int getEmployeeId() {
	    LOGGER.info("Enter the EmployeeId:");
		final int employeeId = Integer.parseInt(SCANNER.nextLine());
		
		return employeeId;
	}

   /**
	* <p>
	*    Used to get the user name.
	*    By calling the EmployeeDetailsValidation class to validate the input. 
	* </p> 
	*   
	* @return employeeName
	*/
	public static String getEmployeeName() {
	    LOGGER.info("Enter the EmployeeName:");
		final String employeeName = EmployeeDetailsValidation.checkEmployeeName(SCANNER.nextLine());
		
		return employeeName;
	}

   /**
	* <p>
	*    Used to get the contact number.
	*    By calling the EmployeeDetailsValidation class to validate the input.
	* </p>   
	* 
	* @return contactNumber
	*/
	public static String getContactNumber() {
	    LOGGER.info("Enter the Contact Number:");
		final String contactNumber = EmployeeDetailsValidation.checkContactNumber(SCANNER.nextLine());
		
		return contactNumber;
	}

   /**
	* <p>
	*    Used to get employee salary details.
	*    By calling the EmployeeDetailsValidation class to validate the input.
	* </p>  
	*  
	* @return salary
	*/
	public static String getEmployeeSalary() {
	    LOGGER.info("Enter the Salary:");
		final String salary = EmployeeDetailsValidation.checkSalary(SCANNER.nextLine());
		
		return salary;
	}

   /**
	* <p>
	*    Used to get the email Id.
	*    By calling the EmployeeDetailsValidation class to validate the input.
	* </p> 
	*   
	* @return emailId
    */
	public static String getEmailId() {
	    LOGGER.info("Enter the EmailId:");
		final String emailId = EmployeeDetailsValidation.checkEmailId(SCANNER.nextLine());
		
		return emailId;
	}

   /**
	* Used to get the date of birth of the employee
	*/
	public static Date getDateOfBirth() {
	    LOGGER.info("Enter employee date of birth (YYYY-MM-dd):"); 
		return EmployeeDetailsValidation.dateValidation(SCANNER.nextLine());  
	}	
	
   /**
    * <p>
    *     Used to add employee details as including employeeId,
    *     name of the employee, salary details,contact number, emailId and
    *     date of birth of the employee and pass it to the controller.
    * </p>   
    */
    public static void addEmployee() {
        final int employeeId = EmployeeDetails.getEmployeeId();
        final String employeeName = EmployeeDetails.getEmployeeName();
        final String salary = EmployeeDetails.getEmployeeSalary();
        final String contactNumber = EmployeeDetails.getContactNumber();
        final String emailId = EmployeeDetails.getEmailId();
        final Date dateOfBirth = EmployeeDetails.getDateOfBirth();
        final Employee employee = new Employee(employeeId, employeeName, salary, contactNumber, emailId, dateOfBirth);
        
        try {
           EMPLOYEECONTROLLER.addEmployee(employee);
           LOGGER.info("Successfully Added");
        } catch (IdAlreadyExistsException exception) {
            LOGGER.error(exception);
        } catch (ConenctionNotFoundException exception) {
            LOGGER.error(exception);
        }
    }
    
   /**
    * Used to view the employee details
    */
    public static void viewEmployeeDetails() {
        
        try {
            Map<Integer, Employee> data = EMPLOYEECONTROLLER.viewEmployeeDetails();
            
            LOGGER.info(data);
        } catch (DataNotFoundException exception) {
            LOGGER.error(exception);
        } catch (ConenctionNotFoundException exception) {
            LOGGER.error(exception);
        } 
    }
    
   /**
    * Used to delete the employee details by checking the employeeId
    */
    public static void deleteEmployee() {
      
        try {
            EMPLOYEECONTROLLER.deleteEmployee(EmployeeDetails.getEmployeeId());
            LOGGER.info("Successfully Deleted");
        } catch (IdNotFoundException exception) {
            LOGGER.error(exception);
        } catch (ConenctionNotFoundException exception) {
            LOGGER.error(exception);
        }
    }
    
   /**
    * <p>
    *     Used to update the employee details by using iterator and 
    *     employeeId for checking the availability of the details of the employee
    *     and then update employee details using switch case 
    *     implemetation by user choice.
    * </p>  
    */   
    public static void updateEmployeeDetails() {
        int employeeId = EmployeeDetails.getEmployeeId();
        String employeeName = null;
        String salary = null;
        String contactNumber = null;
        String emailId = null;
        Date dateOfBirth = null;
        
        LOGGER.info("Update Changes To Employee Name ?\n yes or no");
        
        if (("yes").equalsIgnoreCase(EmployeeDetails.SCANNER.nextLine())) {
            employeeName  = EmployeeDetails.getEmployeeName();
        }
        
        LOGGER.info("Update Changes To Employee Salary ?\n yes or no");
        
        if (("yes").equalsIgnoreCase(EmployeeDetails.SCANNER.nextLine())) {
            salary = EmployeeDetails.getEmployeeSalary();
        }
        
        LOGGER.info("Update Changes To Employee Contact Number ?\n yes or no");
        
        if (("yes").equalsIgnoreCase(EmployeeDetails.SCANNER.nextLine())) {
            contactNumber = EmployeeDetails.getContactNumber();
        }
        
        LOGGER.info("Update Changes To Employee EmailId ?\n yes or no");
        
        if (("yes").equalsIgnoreCase(EmployeeDetails.SCANNER.nextLine())) {
            emailId = EmployeeDetails.getEmailId();
        }
        
        LOGGER.info("Update Changes To Employee DateOfBirth ?\n yes or no");
        
        if (("yes").equalsIgnoreCase(EmployeeDetails.SCANNER.nextLine())) {
            dateOfBirth = EmployeeDetails.getDateOfBirth();
        }
        Employee employee = new Employee();
        
        employee.setEmployeeId(employeeId);
        employee.setEmployeeName(employeeName);
        employee.setSalary(salary);
        employee.setContactNumber(contactNumber);
        employee.setEmailId(emailId);
        employee.setDateOfBirth(dateOfBirth);
        
        try {
            EMPLOYEECONTROLLER.updateEmployeeDetails(employee);
            LOGGER.info("Successfully updated");
        } catch (IdNotFoundException exception) {
            LOGGER.error(exception);
        } catch (ConenctionNotFoundException exception) {
            LOGGER.error(exception);
        }
    }    
}
	   
	

