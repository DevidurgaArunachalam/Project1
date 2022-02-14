package com.employee.service;

import java.time.LocalDate;
import com.employee.exception.CustomException.InvalidInputException;
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
    public static boolean checkEmployeeName(final String employeeName) {
         
        if (!employeeName.matches("^([A-Za-z]+\\s)*[a-zA-Z]+$|^[a-zA-z]$")) {
            return false;
        }      
        return true;
     }

    /**
     * <p>
     *     Checks the contactNumber as accepting only numeric values as in the pattern and returns
     *     the validated input to the Employee details class.
     * </p>
     * 
     * @return contactNumber
     */
    public static boolean checkContactNumber(final String contactNumber) {
         
         if (!contactNumber.matches("[6-9]{1}[0-9]{9}")) {
             return false;
         }      
         return true;
     }

     /**
      * <p>
      *     Checks the emailId as accepting the below given pattern and return the 
      *     validated input to the Employee details class.
      * </p>   
      * 
      * @return emailId
      */
     public  static boolean checkEmailId(final String emailId) {
         
         if (!emailId.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z]+.[a-z]+$")) {
             return false;
         }      
         return true;
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
     public static boolean checkSalary(final String salary) {
         
         if (!salary.matches("[0-9]+([,.][0-9]{1,2})?")) {
             return false;
         }      
         return true;
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
     public static boolean dateValidation(final String dateOfJoining) {
         
         try {
             final LocalDate inputDate = LocalDate.parse(dateOfJoining);
             final LocalDate currentDate = LocalDate.now();
            
             if (currentDate.plusDays(1).isAfter(inputDate)) {
                 return true;
             } else {
                 return false;
             }
         } catch (Exception exception) {
            throw new InvalidInputException("Invalid Input!!!...");
         }
     }
     
     /**
      * <p>
      *     Checks the employee Id as accepting
      *     only numerical values and return the validated input to the 
      *     Employee details class.
      * </p>  
      * 
      * @param employeeId
      * @return employeeId
      */
     public static boolean employeeIdValidation(final String employeeId) {
         
         if (!employeeId.matches("[0-9]{1,}")) {
            return false;
         }
        return true;
     }
     
     /**
      * <p>
      *     Checks the choice of the uer as accepting
      *     only numerical values from 1-5 and return the validated input to the 
      *     Employee details class.
      * </p>  
      * 
      * @param choice
      * @return choice
      */
     public static String choiceValidation(final String choice) {
        
         if (!choice.matches("[1-5]")) {
            System.out.println("Invalid Input!!!...\t Enter Numericals From (1-5)");
            return choiceValidation(EmployeeDetails.SCANNER.nextLine().trim());
         }
         return  choice;
     }
}
