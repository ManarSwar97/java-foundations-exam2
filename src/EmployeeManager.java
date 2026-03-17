import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * EmployeeManager — manages a collection of employees.
 * Uses an ArrayList for ordered storage and a HashMap for fast ID lookups.
 *
 * YOUR TASKS:
 *   Part B — Complete: addEmployee, findById, getEmployeesByDepartment
 *   Part D — Complete: removeEmployee, promoteToManager
 */
public class EmployeeManager {

    private List<Employee> employees = new ArrayList<>();
    private Map<Integer, Employee> employeeMap = new HashMap<>();

    // ================================================================
    // PART B — Basic Operations (complete these 3 methods)
    // ================================================================

    /**
     * Add an employee to both the list and the map.
     * If an employee with the same ID already exists, throw IllegalArgumentException.
     *
     * @param employee the employee to add
     * @throws IllegalArgumentException if employee with same ID already exists
     */
    public void addEmployee(Employee employee) {
        // TODO: Check if ID already exists in the map
        // TODO: Add to both the list and the map
        if(employeeMap.containsKey(employee.getId())){
            throw new IllegalArgumentException("an employee with the same ID already exist");
        }
        else{
            employees.add(employee);
            employeeMap.put(employee.getId(), employee);
        }

    }

    /**
     * Find an employee by their ID using the HashMap.
     * Return null if not found.
     *
     * @param id the employee ID to search for
     * @return the Employee, or null if not found
     */
    public Employee findById(int id) {
        // TODO: Look up the employee in the map
        if(id != 0){
            return employeeMap.get(id);
        }
        else{
            throw new IllegalArgumentException("The Employee with the following id is not found");
        }

    }

    /**
     * Return a list of all employees in a given department.
     * The search should be case-insensitive.
     *
     * Example: getEmployeesByDepartment("engineering") should match
     *          employees in "Engineering", "ENGINEERING", etc.
     *
     * @param department the department name to filter by
     * @return list of matching employees (empty list if none found)
     */
    public List<Employee> getEmployeesByDepartment(String department) {
        // TODO: Loop through the employees list
        // TODO: Add matching employees to a results list
        // Hint: use .equalsIgnoreCase() for case-insensitive comparison
        List<Employee> result = new ArrayList<>();
        for(Employee emp : employees){
            if(emp.getDepartment().equalsIgnoreCase(department)){
                result.add(emp);
            }
        }

        return result;
    }

    /**
     * Get all employees.
     * (This one is done for you.)
     */
    public List<Employee> getAllEmployees() {
        return employees;
    }

    /**
     * Get total number of employees.
     * (This one is done for you.)
     */
    public int getEmployeeCount() {
        return employees.size();
    }

    // ================================================================
    // PART D — Exception Handling (complete these 2 methods)
    // ================================================================

    /**
     * Remove an employee by ID.
     * Must remove from BOTH the list and the map.
     *
     * @param id the employee ID to remove
     * @throws IllegalArgumentException if no employee with that ID exists
     */
    public void removeEmployee(int id) {
        // TODO: Find the employee by ID
        // TODO: If not found, throw IllegalArgumentException with message:
        //       "Employee with ID <id> not found"
        // TODO: Remove from both the list and the map
        Employee emp = findById(id);
        if(emp.getId() == id){
            throw new IllegalArgumentException("Employee with ID " + id + " not found!");
        }
        else{
            employees.remove(emp);
            employeeMap.remove(emp);
            System.out.println("The following employee has been deleted successfully");
        }


    }

    /**
     * Promote an employee to Manager.
     * This removes the existing employee and adds a new Manager
     * with the same id, name, department, salary, plus the given teamSize.
     *
     * @param id       the employee ID to promote
     * @param teamSize the team size for the new Manager
     * @return the newly created Manager
     * @throws IllegalArgumentException if no employee with that ID exists
     * @throws IllegalArgumentException if the employee is already a Manager
     */
    public Manager promoteToManager(int id, int teamSize) {

        Manager manager = null;
        Employee emp = findById(id);
        // TODO: Find the employee by ID (throw if not found)
            if (emp.getId() == id) {
                throw new IllegalArgumentException("no employee with that ID exists");
            } else {

                // TODO: Check if already a Manager (use instanceof), throw if so
                //       Message: "Employee <id> is already a Manager"
                if (emp instanceof Manager) {
                    throw new IllegalArgumentException("Employee " + id + " is already a Manager");
                }
                // TODO: Create a new Manager with the same details + teamSize
                manager = new Manager(emp.getId(), emp.getName(), emp.getDepartment(), emp.getSalary(), teamSize);


                // TODO: Remove the old employee, add the new Manager
                removeEmployee(id);

                addEmployee(manager);


            }
            // TODO: Return the new Manager
            return manager;
        }


    }

