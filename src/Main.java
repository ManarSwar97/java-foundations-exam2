import java.util.ArrayList;

/**
 * Main — demonstrate your Employee Management System.
 *
 * YOUR TASKS:
 *   Part C — Create Manager and Intern objects, demonstrate polymorphism
 *   Part D — Add try/catch blocks for exception handling
 *
 * This file should compile and run, printing output that proves
 * all your code works correctly.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("=== PART A: Salary Utilities ===");
        // TODO: Test all 4 SalaryUtils methods and print results
        // Example:
           System.out.println("Annual salary: " + SalaryUtils.calculateAnnualSalary(5000));
           System.out.println("Tax on 25000: " + SalaryUtils.calculateTax(25000));
           System.out.println("Net salary: " + SalaryUtils.calculateNetSalary(6000));
           System.out.println("After 10% raise: " + SalaryUtils.applyRaise(3000, 10));




        System.out.println("\n=== PART B: Employee Manager ===");
        // TODO: Create an EmployeeManager
        EmployeeManager employeeManager = new EmployeeManager();
        // TODO: Create and add at least 3 employees to it
        employeeManager.addEmployee(new Employee(1, "Manar", "Engineering", 700));
        employeeManager.addEmployee(new Employee(2, "Sara", "Engineering", 900));
        employeeManager.addEmployee(new Employee(3, "Fatema", "IT", 900));
        employeeManager.addEmployee(new Employee(4, "Zainab", "IT", 900));
        // TODO: Demonstrate findById (found + not found)
        System.out.println(employeeManager.findById(3));
        // TODO: Demonstrate getEmployeesByDepartment
        System.out.println(employeeManager.getEmployeesByDepartment("Engineering"));

        System.out.println("\n=== PART C: Inheritance & Polymorphism ===");

        // TODO: Create at least 1 Manager and 1 Intern
        Employee manager = new Manager(5, "Ali", "Engineering", 500, 20);
        Employee intern = new Intern(6, "Mohammed", "IT", 200, "University of Bahrain");
        Employee employee = new Employee(7, "Ahmed", "Administration", 1000);
        // TODO: Add all employees (Employee, Manager, Intern) to the manager
        employeeManager.addEmployee(employee);
        employeeManager.addEmployee(manager);
        employeeManager.addEmployee(intern);

        Employee[] emp = {employee, manager, intern};
        // TODO: Loop through getAllEmployees() and call getBonus() on each
        //       Print: "<name> bonus: <amount>" for each one
        //       This demonstrates polymorphism — same method call, different behavior
        for(Employee employee1: employeeManager.getAllEmployees()){
            System.out.println("name: " + employee1.getName() + " has the following bonus: " + employee1.getBonus());
        }

        System.out.println("\n=== PART D: Exception Handling ===");
        // TODO: Use try/catch to demonstrate:
        //   1. Trying to remove an employee that doesn't exist
        try{
            employeeManager.removeEmployee(5);
        }catch(IllegalArgumentException e){
            System.out.println("The following id does not exist");
        }
        //   2. Trying to promote an employee that's already a Manager
        try{
            employeeManager.promoteToManager(6, 25);
        }catch(IllegalArgumentException e){
            System.out.println("The following employee is already a manager");
        }
        //   3. Trying to create an Employee with invalid data (negative salary)
        try{
            employeeManager.addEmployee(new Employee(8, "Ali", "Business", -5000));
        }catch(IllegalArgumentException e){
            System.out.println("Invalid data");
        }
        // Each try/catch should print the error message gracefully

    }
}
