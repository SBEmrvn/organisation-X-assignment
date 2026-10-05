public class Employee {
    int id;
    String name;
    String department;
    double baseSalary;
    double overtimeHours;

    public Employee(int id, String name, String department, double baseSalary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.baseSalary = baseSalary;
        this.overtimeHours = 0;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Department: " + department +
               ", Base Salary: " + baseSalary + ", Overtime Hours: " + overtimeHours;
    }
}
