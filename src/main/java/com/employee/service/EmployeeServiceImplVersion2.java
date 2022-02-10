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
        boolean isDeleted = EMPLOYEE_DAO.deleteEmployee(employeeId);
        
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
        boolean isUpdated = EMPLOYEE_DAO.updateEmployeeDetails(employee);
        
        if (isUpdated) {
            return true;
        }
        else {
            throw new IdNotFoundException("Employee Id Not Found!!!...");
        }
    }
}
