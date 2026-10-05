import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem();
        PaymentProcessor payroll = new PaymentProcessor();
        ReportGenerator reports = new ReportGenerator();
        Scanner sc = new Scanner(System.in);
        int choice;

        System.out.println("=== Organization X HR System ===");

        do {
            System.out.println("\n1. Add Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Remove Employee");
            System.out.println("4. List Employees");
            System.out.println("5. Calculate Net Salary");
            System.out.println("6. Generate Payroll Report");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Enter ID: ");
                int id = sc.nextInt(); sc.nextLine();
                System.out.print("Enter Name: ");
                String name = sc.nextLine();
                System.out.print("Enter Department: ");
                String dept = sc.nextLine();
                System.out.print("Enter Base Salary: ");
                double salary = sc.nextDouble(); sc.nextLine();
                ems.addEmployee(new Employee(id, name, dept, salary));

            } else if (choice == 2) {
                System.out.print("Enter Employee ID to update: ");
                int id = sc.nextInt(); sc.nextLine();
                System.out.print("Enter New Name: ");
                String name = sc.nextLine();
                System.out.print("Enter New Department: ");
                String dept = sc.nextLine();
                System.out.print("Enter New Base Salary: ");
                double salary = sc.nextDouble(); sc.nextLine();
                ems.updateEmployee(id, name, dept, salary);

            } else if (choice == 3) {
                System.out.print("Enter Employee ID to remove: ");
                int id = sc.nextInt(); sc.nextLine();
                ems.removeEmployee(id);

            } else if (choice == 4) {
                ems.listEmployees();

            } else if (choice == 5) {
                System.out.print("Enter Employee ID: ");
                int id = sc.nextInt(); sc.nextLine();
                Employee e = ems.findEmployee(id);
                if (e == null) {
                    System.out.println("Employee not found.");
                } else {
                    System.out.print("Enter Overtime Hours (0 if none): ");
                    double ot = sc.nextDouble(); sc.nextLine();
                    e.overtimeHours = ot;
                    double gross = payroll.calculateGrossSalary(e);
                    double tax = payroll.calculateTax(gross);
                    double net = payroll.calculateNetSalary(e);
                    System.out.println("Gross Salary : " + gross);
                    System.out.println("Tax          : " + tax);
                    System.out.println("Net Salary   : " + net);
                }

            } else if (choice == 6) {
                reports.generatePayrollReport(ems);

            } else if (choice != 0) {
                System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 0);

        System.out.println("Goodbye.");
        sc.close();
    }
}
