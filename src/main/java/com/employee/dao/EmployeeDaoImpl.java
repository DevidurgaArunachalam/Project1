package com.employee.dao;

import com.employee.exception.CustomException.ConenctionNotFoundException;

import com.employee.model.Employee;

import java.sql.PreparedStatement;
import java.util.LinkedHashMap;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Date;
import java.util.Map;


/**
 * Database connectivity to store the values
 */
public class EmployeeDaoImpl implements EmployeeDao {
    private static final DBConnection DB_CONNECTION = new DBConnection();
   
   /**
    * Stores the data of employees in database
    * 
    * @param employee
    */
    public boolean addEmployee(final Employee employee) {
        final String query = "insert into employeedata (employeeId, employeeName, employeeSalary, employeeContactNumber, employeeEmailId, employeeDateOfBirth) values (?, ?, ?, ?, ?, ?)";
        
        try (Connection connection = DB_CONNECTION.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);){
           
            preparedStatement.setInt(1, employee.getEmployeeId());
            preparedStatement.setString(2, employee.getEmployeeName());
            preparedStatement.setString(3, employee.getSalary());
            preparedStatement.setString(4, employee.getContactNumber());
            preparedStatement.setString(5, employee.getEmailId());
            preparedStatement.setDate(6, employee.getDateOfBirth());

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException exception) {
            throw new ConenctionNotFoundException("Connection Error!!!...");
        }
    }

   /**
    * Shows the list of data in the database 
    * 
    * @return EMPLOYEE DETAILS
    */
    public Map<Integer, Employee> viewEmployeeData() {
        final Map<Integer, Employee> employeeDetails = new LinkedHashMap<>();
        final String query = "SELECT * FROM employeedata";

        try (Connection connection = DB_CONNECTION.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery();) {
            
            while (resultSet.next()) {
                final int employeeId = resultSet.getInt(1);
                final String employeeName = resultSet.getString(2);
                final String employeeSalary = resultSet.getString(3);
                final String employeeContactNumber = resultSet.getString(4);
                final String employeeEmailId = resultSet.getString(5);
                final Date employeeDateOfBirth = resultSet.getDate(6);
                Employee employee = new Employee(employeeId, employeeName, employeeSalary, employeeContactNumber,
                        employeeEmailId,  employeeDateOfBirth);
                
                employeeDetails.put(employeeId, employee);
             }
        } catch (SQLException exception) {
            throw new ConenctionNotFoundException("Connection Error!!!...");
        }
        return employeeDetails;
    }

   /**
    * Deletes the employee details by checking the employeeId 
    * 
    * @param employeeId
    */
    public boolean deleteEmployee(final int employeeId) {
        final String query = "DELETE FROM employeedata Where employeeId = ?";
        
        try (final Connection connection = DB_CONNECTION.getConnection();
               PreparedStatement preparedStatement = connection.prepareStatement(query);){
        
            preparedStatement.setInt(1, employeeId);
            return preparedStatement.executeUpdate() > 0;
            
        } catch (SQLException exception) {
            throw new ConenctionNotFoundException("Connection Error!!!...");
        }
    }

   /**
    * Updates the employee details as per the user's choice
    * 
    * @param employee
    */
    public boolean updateEmployeeDetails(final Employee employee) {
        
        try (Connection connection = DB_CONNECTION.getConnection();
            Statement statement = connection.createStatement();) { 
            final StringBuffer updateQuery= new StringBuffer();      
            String query = updateQuery.append("UPDATE employeedata set").toString();
            boolean hasNextColumn = false;   
                  
                if (employee.getEmployeeName() != null) {
                    query = updateQuery.append(" employeeName = '").append(employee.getEmployeeName()).append("'").toString();
                    hasNextColumn = true;
                    
                }  
                    
                if (employee.getSalary() != null) {
                    
                    if (hasNextColumn) {
                        query = updateQuery.append(",").toString(); 
                    }
                    query = updateQuery.append(" employeeSalary = '").append(employee.getSalary()).append("'").toString();
                    hasNextColumn = true;
                }
                    
               if (employee.getContactNumber() != null) {
                   
                   if (hasNextColumn) {
                       query = updateQuery.append(",").toString(); 
                   }
                    query = updateQuery.append(" employeeContactNumber = '").append(employee.getContactNumber()).append("'").toString();
                    hasNextColumn = true;
                }
                    
               if (employee.getEmailId() != null) {
                   
                   if (hasNextColumn) {
                       query = updateQuery.append(",").toString(); 
                   }
                    query = updateQuery.append(" employeeEmailId = '").append(employee.getEmailId()).append("'").toString();
                    hasNextColumn = true;
                }

               if (employee.getDateOfBirth() != null) {
                   
                   if (hasNextColumn) {
                       query = updateQuery.append(",").toString(); 
                   }
                    query = updateQuery.append(" employeeDateOfBirth = '").append(employee.getDateOfBirth()).append("'").toString();
                    hasNextColumn = true;
                }
            
                query = updateQuery.append(" WHERE employeeId = ").append(employee.getEmployeeId()).toString();
                System.out.println(query);
                return statement.executeUpdate(query) > 0 ;
        } catch (SQLException exception) {
            throw new ConenctionNotFoundException("Connection Error!!!...");          
        }
    }
}
