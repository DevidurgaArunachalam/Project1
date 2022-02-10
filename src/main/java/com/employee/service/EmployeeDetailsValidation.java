package com.employee.service;

import java.sql.Date;
import java.time.LocalDate;

import com.employee.view.EmployeeDetails;

public class EmployeeDetailsValidation {

   /**
    * <p>
    *     Checks the employee name as accepting only alphabets and returns the 
    *     validated input to the Employee Details class.
    * </p>
    * 
    * @return employeeName
    */
    public static String checkEmployeeName(final String employeeName) {
         
        if (!employeeName.matches("^([A-Za-z]+\\s)*[a-zA-Z]+$|^[a-zA-z]$")) {
            System.out.println("Invalid Input!!!...");
            return EmployeeDetails.getEmployeeName();
         } 
         
        return employeeName;
     }

   /**
    * <p>
    *     Checks the contactNumber as accepting only numeric values as in the pattern and returns
    *     the validated input to the Employee details class.
    * </p>
    * 
    * @return contactNumber
    */
    public static String checkContactNumber(final String contactNumber) {
         
         if (!contactNumber.matches("[6-9]{1}[0-9]{9}")) {
             System.out.println("Invalid Input!!!...");
             return EmployeeDetails.getContactNumber();
         } 
         
         return contactNumber;
     }

    /**
     * <p>
     *     Checks the emailId as accepting the below given pattern and return the 
     *     validated input to the Employee details class.
     * </p>   
     * 
     * @return emailId
     */
     public static String checkEmailId(final String emailId) {
         
         if (!emailId.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
             System.out.println("Invalid Input!!!...");
             return EmployeeDetails.getEmailId();
         } 
         
         return emailId;
     }

    /**
     * <p>
     *     Checks the employee salary as accepting
     *     only numerical values and return the validated input to the 
     *     Employee details class.
     * </p>    
     * 
     * @return salary
     */
     public static String checkSalary(final String salary) {
         
         if (!salary.matches("[0-9]{3,}")) {
             System.out.println("Invalid Input!!!...");
             return EmployeeDetails.getEmployeeSalary();
         } 
         
         return salary;
     }

    /**
     * <p>
     *     Validating employee joining date by checking day, month, year of default
     *     calendar method. If any input other than predefined values are given, then
     *     the method is called again to get desired input.
     * </p>    
     * 
     * @param dateOfBirth
     * @return date
     */
     public static Date dateValidation(final String dateOfBirth) {
         
         try {
             final LocalDate inputDate = LocalDate.parse(dateOfBirth);
             final LocalDate currentDate = LocalDate.now();
            
             if (currentDate.isAfter(inputDate)) {
                 return Date.valueOf(inputDate);
             }
         } catch (Exception exception) {
             System.out.println("Invalid Input!!!..");
             return EmployeeDetails.getDateOfBirth();
         }
         
          return Date.valueOf(dateOfBirth);
     }
}
