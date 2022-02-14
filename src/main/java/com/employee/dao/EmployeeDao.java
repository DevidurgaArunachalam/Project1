package com.employee.dao;

import java.util.Map;

import com.employee.model.Employee;

/**
 * Inteface created for Employee database 
 */
public interface EmployeeDao {
    
    boolean addEmployee(final Employee employee);
    
    Map<Integer, Employee> viewEmployeeData();
    
    boolean deleteEmployee(final int employeeId);
    
    boolean updateEmployeeDetails(final Employee employee);
}
