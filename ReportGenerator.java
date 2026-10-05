public class ReportGenerator {

    // FR-3: Generate payroll report
    public void generatePayrollReport(EmployeeManagementSystem ems) {
        if (ems.count == 0) {
            System.out.println("No employees found. Cannot generate report.");
            return;
        }

        PaymentProcessor pp = new PaymentProcessor();
        double total = 0;

        System.out.println("---- Payroll Report ----");
        for (int i = 0; i < ems.count; i++) {
            Employee e = ems.employees[i];
            double net = pp.calculateNetSalary(e);
            total += net;
            System.out.println(e.name + " -> Net Salary: " + net);
        }

        double average = total / ems.count;
        System.out.println("Number of Employees : " + ems.count);
        System.out.println("Total Net Payroll   : " + total);
        System.out.println("Average Net Salary  : " + average);
    }
}
