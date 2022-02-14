package com.employee.view;

import com.employee.exception.CustomException.ConenctionNotFoundException;
import com.employee.exception.CustomException.InvalidInputException;
import com.employee.main.EmployeeManagement;
import com.employee.exception.CustomException.DataNotFoundException;
import com.employee.exception.CustomException.IdAlreadyExistsException;
import com.employee.exception.CustomException.IdNotFoundException;
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
	private static final Logger LOGGER = Logger.getLogger(EmployeeDetails.class);

    /**
	 * Used to get the user Id in the numerical values
	 * 
	 * @return employeeId
     */
	public static int getEmployeeId() {
	    LOGGER.info("Enter the EmployeeId:\t[Back To Main: $ ]");
		final String employeeId = SCANNER.nextLine().trim();
		final boolean isIdCorrect = EmployeeController.checkEmployeeId(employeeId);

        if ("$".equals(employeeId)) {
            EmployeeManagement.selectChoice();
        }
        
		if (isIdCorrect) {
            return Integer.parseInt(employeeId);
        } else {
            System.out.println("Invalid Input!!!... Numerical Values from 0-9)");
            return getEmployeeId();
        }
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
	    LOGGER.info("Enter the EmployeeName :\t[Back To Main: $ ]");
	    final String employeeName = SCANNER.nextLine().trim();
		final boolean isNameCorrect = EmployeeController.checkEmployeeName(employeeName);

        if ("$".equals(employeeName)) {
            EmployeeManagement.selectChoice();
        }
        
		if (isNameCorrect) {
		    return employeeName;
		} else {
		    System.out.println("Invalid Input!!!...\tEnter Valid Alphabets(a-z)");
		    return getEmployeeName();
		}
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
	    LOGGER.info("Enter the Contact Number :\t[Back To Main: $ ]");
	    final String contactNumber = SCANNER.nextLine().trim();
		final boolean isNumberCorrect = EmployeeController.checkContactNumber(contactNumber);
		
		if ("$".equals(contactNumber)) {
		    EmployeeManagement.selectChoice();
		}
		
		if (isNumberCorrect) {
            return contactNumber;
        } else {
            System.out.println("Invalid Input!!!...\tEnter Valid 10 Digit Number");
            return getContactNumber();
        }
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
	    LOGGER.info("Enter the Salary :\t[Back To Main: $ ]");
	    final String salary = SCANNER.nextLine().trim();
        final boolean isSalaryCorrect = EmployeeController.checkSalary(salary);

        if ("$".equals(salary)) {
            EmployeeManagement.selectChoice();
        }
        
        if (isSalaryCorrect) {
            return salary;
        } else {
            System.out.println("Invalid Input!!!...\tEnter Numerical Values(0-9)");
            return getEmployeeSalary();
        }
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
	    LOGGER.info("Enter the EmailId :\t[Back To Main: $ ]");
		final String emailId = (SCANNER.nextLine()).trim();
		final boolean isEmailIdCorrect = EmployeeController.checkEmailId(emailId);

        if ("$".equals(emailId)) {
            EmployeeManagement.selectChoice();
        }
        
		if (isEmailIdCorrect) {
		    return emailId;
		} else {
		    System.out.println("Invalid Input!!!...");
		    return getEmailId();
		}
	}
	
	/**
     * <p>
     *    Used to get the user choice.
     *    By calling the EmployeeDetailsValidation class to validate the input.
     * </p> 
     *   
     * @return emailId
     */
	public static String getUserChoice() {
	    LOGGER.info("Enter the EmailId :\t[Back To Main: $ ]");
        final String userChoice = (SCANNER.nextLine()).trim();
        final boolean isUserChoiceValid = EmployeeController.userChoiceValidation(userChoice);
        
        if (isUserChoiceValid) {
            return userChoice; 
        } else {
            System.out.println("Please Enter Valid Choice!!!...");
            return EmployeeDetails.getUserChoice();
        }
	}

    /**
	 * Used to get the date of birth of the employee
	 */
	public static Date getDateOfJoining() {
	    LOGGER.info("Enter employee date of joining (YYYY-MM-dd) :\t[Back To Main: $ ]"); 
	    String dateOfJoining = SCANNER.nextLine().trim();
		boolean isDateCorrect = false;

        if ("$".equals(dateOfJoining)) {
            EmployeeManagement.selectChoice();
        } 
        
		try {
		    isDateCorrect = EmployeeController.dateValidation(dateOfJoining);
		} catch (InvalidInputException exception) {
		    LOGGER.info(exception);
		}
		
		if (isDateCorrect) {
		    return Date.valueOf(dateOfJoining);
		} else {
		    System.out.println("Invalid Input!!!...");
		    return getDateOfJoining();
		}
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
    
        try {
            EMPLOYEECONTROLLER.employeeIdCorrect(employeeId);
        } catch (IdAlreadyExistsException exception) {
            LOGGER.error(exception);
            addEmployee();
            EmployeeManagement.selectChoice();
        }  
            final String employeeName = EmployeeDetails.getEmployeeName();
            final String salary = EmployeeDetails.getEmployeeSalary();
            final String contactNumber = EmployeeDetails.getContactNumber();
            final Date dateOfJoining = EmployeeDetails.getDateOfJoining();
            final Employee employee = new Employee(employeeId, employeeName, salary, contactNumber, dateOfJoining);
       try { 
            final boolean isAdded = EMPLOYEECONTROLLER.addEmployee(employee);
            
            if (isAdded) {
                LOGGER.info("Successfully Added"); 
            } 
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
        Employee employee = new Employee();
        int employeeId = EmployeeDetails.getEmployeeId();
        
        try {
            EMPLOYEECONTROLLER.employeeIdCorrectUpdate(employeeId);
        } catch (IdNotFoundException exception) {
            LOGGER.error(exception);
            updateEmployeeDetails();
            EmployeeManagement.selectChoice();
        } 
        employee.setEmployeeId(employeeId);
        String updateInput;
        LOGGER.info("Update Changes To Employee Name ?\t yes or no");
        
        while (true) {
            updateInput = EmployeeDetails.SCANNER.nextLine().trim();
            
            if (updateInput.equalsIgnoreCase("yes")) {
                employee.setEmployeeName(EmployeeDetails.getEmployeeName());
                break;
            } else if (updateInput.equalsIgnoreCase("no")) {
                break;
            } else {
                LOGGER.info("Enter Valid Input (yes or no)");
                continue;
            } 
        }
        LOGGER.info("Update Changes To Employee Salary ?\t yes or no");
        
        while (true) {
            updateInput = EmployeeDetails.SCANNER.nextLine().trim();
            
            if (updateInput.equalsIgnoreCase("yes")) {
                employee.setSalary(EmployeeDetails.getEmployeeSalary());
                break;
            } else if (updateInput.equalsIgnoreCase("no")) {
                break;
            } else {
                LOGGER.info("Enter Valid Input (yes or no)");
                continue;
            } 
        }        
        LOGGER.info("Update Changes To Employee Contact Number ?\t yes or no");
       
        while (true) {
            updateInput = EmployeeDetails.SCANNER.nextLine().trim();
            
            if (updateInput.equalsIgnoreCase("yes")) {
                employee.setContactNumber(EmployeeDetails.getEmployeeSalary());
                break;
            } else if (updateInput.equalsIgnoreCase("no")) {
                break;
            } else {
                LOGGER.info("Enter Valid Input (yes or no)");
                continue;
            } 
        }        
        LOGGER.info("Update Changes To Employee DateOfJoining ?\t yes or no");

        while (true) {
            updateInput = EmployeeDetails.SCANNER.nextLine().trim();
            
            if (updateInput.equalsIgnoreCase("yes")) {
                employee.setDateOfJoining(EmployeeDetails.getDateOfJoining());
                break;
            } else if (updateInput.equalsIgnoreCase("no")) {
                break;
            } else {
                LOGGER.info("Enter Valid Input (yes or no)");
                continue;
            } 
        }
        
        try { 
          EMPLOYEECONTROLLER.updateEmployeeDetails(employee);
          LOGGER.info("Data Updated Successfully");
        }  catch (IdNotFoundException exception) {
            LOGGER.error(exception);
        } catch (ConenctionNotFoundException exception) {
            LOGGER.error(exception);
        }    
    }
}    
	   
	

