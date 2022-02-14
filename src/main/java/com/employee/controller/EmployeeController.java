package com.employee.controller;

import com.employee.service.EmployeeDetailsValidation;
import com.employee.service.EmployeeServiceImplVersion2;
import com.employee.model.Employee;

import java.util.Map;

/**
 * <p>
 *    This controller class is used for getting the request from main and 
 *    gives it to the service.
 *    The input data fetched in view are processed and then called in employee main class.
 * </p>   
 */
public class EmployeeController {
    private final static EmployeeServiceImplVersion2 EMPLOYEE_IMPL = new EmployeeServiceImplVersion2();
    
    public boolean addEmployee(final Employee employee) {
        return EMPLOYEE_IMPL.addEmployee(employee);
    }

    public Map<Integer, Employee> viewEmployeeDetails() {
        return EMPLOYEE_IMPL.viewEmployeeData();  
    }
	 
    public boolean updateEmployeeDetails(Employee employee) {
	return EMPLOYEE_IMPL.updateEmployeeDetails(employee);
    }

    public boolean deleteEmployee(int employeeId) {
	return EMPLOYEE_IMPL.deleteEmployee(employeeId);
    }
	
    public static boolean checkEmployeeName(final String employeeName) {
        return EmployeeDetailsValidation.checkEmployeeName(employeeName);
    }

    public static boolean checkContactNumber(String contactNumber) {
        return EmployeeDetailsValidation.checkContactNumber(contactNumber);
    }

    public static boolean checkEmployeeId(String employeeId) {
        return EmployeeDetailsValidation.employeeIdValidation(employeeId);
    }

    public static boolean checkSalary(String salary) {
        return EmployeeDetailsValidation.checkSalary(salary);
    }

    public static boolean checkEmailId(String emailId) {
        return EmployeeDetailsValidation.checkEmailId(emailId);
    }

    public static boolean dateValidation(String dateOfJoining) {
        return EmployeeDetailsValidation.dateValidation(dateOfJoining);
    }

    public boolean employeeIdCorrect(final int employeeId) {
        return EMPLOYEE_IMPL.employeeIdCorrect(employeeId);
    }  
    
    public boolean employeeIdCorrectUpdate(final int employeeId) {
        return EMPLOYEE_IMPL.employeeIdCorrectUpdate(employeeId); 
    }
    
    public static boolean userChoiceValidation(final String userChoice) {
        return EmployeeServiceImplVersion2.validateUserChoice(userChoice); 
    }
}
