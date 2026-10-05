public class EmployeeManagementSystem {
    Employee[] employees = new Employee[100];
    int count = 0;

    // FR-1: Add employee
    public void addEmployee(Employee e) {
        for (int i = 0; i < count; i++) {
            if (employees[i].id == e.id) {
                System.out.println("Error: Employee ID " + e.id + " already exists.");
                return;
            }
        }
        employees[count] = e;
        count++;
        System.out.println("Employee added successfully.");
    }

    // FR-1: Update employee
    public void updateEmployee(int id, String newName, String newDepartment, double newSalary) {
        for (int i = 0; i < count; i++) {
            if (employees[i].id == id) {
                employees[i].name = newName;
                employees[i].department = newDepartment;
                employees[i].baseSalary = newSalary;
                System.out.println("Employee updated successfully.");
                return;
            }
        }
        System.out.println("Error: Employee ID " + id + " not found.");
    }

    // FR-1: Remove employee
    public void removeEmployee(int id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].id == id) {
                for (int j = i; j < count - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                count--;
                System.out.println("Employee removed successfully.");
                return;
            }
        }
        System.out.println("Error: Employee ID " + id + " not found.");
    }

    // FR-1: List all employees
    public void listEmployees() {
        if (count == 0) {
            System.out.println("No employees found.");
            return;
        }
        System.out.println("--- Employee List ---");
        for (int i = 0; i < count; i++) {
            System.out.println(employees[i]);
        }
    }

    // Find employee by ID
    public Employee findEmployee(int id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].id == id) {
                return employees[i];
            }
        }
        return null;
    }
}
