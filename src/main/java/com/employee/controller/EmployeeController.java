package com.employee.controller;

import com.employee.service.EmployeeServiceImplVersion2;

import java.util.Map;

import com.employee.model.Employee;

/**
 * <p>
 *    This controller class is used for getting the request from main and 
 *    gives it to the service.
 *    The input data fetched in view are processed and then called in employee main class.
 * </p>   
 */
public class EmployeeController {
    private final EmployeeServiceImplVersion2 EMPLOYEE_IMPL = new EmployeeServiceImplVersion2();
    
	public void addEmployee(final Employee employee) {
	    EMPLOYEE_IMPL.addEmployee(employee);
	}

	public Map<Integer, Employee> viewEmployeeDetails() {
        return EMPLOYEE_IMPL.viewEmployeeData();  
	}
	 
	public void updateEmployeeDetails(Employee employee) {
	    EMPLOYEE_IMPL.updateEmployeeDetails(employee);
	}

	public void deleteEmployee(int employeeId) {
	    EMPLOYEE_IMPL.deleteEmployee(employeeId);
    }
}
