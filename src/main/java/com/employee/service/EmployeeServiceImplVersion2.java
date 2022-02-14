package com.employee.service;

import java.util.Map;

import com.employee.dao.EmployeeDao;
import com.employee.dao.EmployeeDaoImpl;
import com.employee.exception.CustomException.DataNotFoundException;
import com.employee.exception.CustomException.IdAlreadyExistsException;
import com.employee.exception.CustomException.IdNotFoundException;
import com.employee.model.Employee;

/**
 * Implements the EmployeeDB interface
 */
 public class EmployeeServiceImplVersion2 implements EmployeeDao {
     
    final EmployeeDaoImpl EMPLOYEE_DAO = new EmployeeDaoImpl();
    
    /**
     * Adds the employee details to the database
     */
    public boolean addEmployee(Employee employee) { 

        if (EMPLOYEE_DAO.viewEmployeeData().containsKey(employee.getEmployeeId())) {
            throw new IdAlreadyExistsException("Employee Id Already Exists!!!...");
        } else {
            return EMPLOYEE_DAO.addEmployee(employee);
        } 
    }
 
    /**
     * Shows all the employee details from the database
     */
    public Map<Integer, Employee> viewEmployeeData() {     
        
        if (EMPLOYEE_DAO.viewEmployeeData().isEmpty()) {
           throw new DataNotFoundException("Data doesnot exists!!!...");
        }
        return EMPLOYEE_DAO.viewEmployeeData();  
    }

    /**
     * Deletes the employee deatails from the database
     */
    public boolean deleteEmployee(final int employeeId) {
        final boolean isDeleted = EMPLOYEE_DAO.deleteEmployee(employeeId);
        
        if (isDeleted) {
            return true;
        }
        else {
            throw new IdNotFoundException("Employee Id Not Found!!!...");
        }
    }

    /**
     * Updates the employee details from the database
     */
    public boolean updateEmployeeDetails(Employee employee) {
        final boolean isUpdated = EMPLOYEE_DAO.updateEmployeeDetails(employee);
        
        if (isUpdated) {
            return true;
        }
        else {
            throw new IdNotFoundException("Employee Id Not Found!!!...");
        }
    }
    
    /**
     * Checks the employeeId whether contained in the database and adds if not present 
     */
    public boolean employeeIdCorrect(int employeeId) {
      final boolean isEmployeeId = EMPLOYEE_DAO.viewEmployeeData().containsKey(employeeId);
    
      if (!isEmployeeId) {
        return true; 
      }
       throw new IdAlreadyExistsException("Employee Id Already Exists!!!...");
   }
    
    /**
     * Checks the employeeId whether contained in the database to update in the database
     */
    public boolean employeeIdCorrectUpdate(int employeeId) {
        final boolean isEmployeeId = EMPLOYEE_DAO.viewEmployeeData().containsKey(employeeId);
         
        if (isEmployeeId) {
            return true;
        }
        throw new IdNotFoundException("Employee Id Not Found!!!..."); 
    }
    
    /**
     * Checks the user choice to update the details to the employee database
     */
    public static boolean validateUserChoice(final String userChoice) {
        
        if (!userChoice.matches("(yes|no) |(YES|No)")) {
            return false;
         }
        return true;
    }
}

