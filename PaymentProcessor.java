public class PaymentProcessor {

    // FR-2: Calculate gross salary including overtime
    public double calculateGrossSalary(Employee e) {
        double hourlyRate = e.baseSalary / 160;
        double overtimePay = e.overtimeHours * hourlyRate * 1.5;
        return e.baseSalary + overtimePay;
    }

    // FR-2: Calculate tax based on gross salary brackets
    public double calculateTax(double grossSalary) {
        if (grossSalary >= 500000) {
            return grossSalary * 0.30;
        } else if (grossSalary >= 200000) {
            return grossSalary * 0.20;
        } else {
            return grossSalary * 0.10;
        }
    }

    // FR-2: Calculate net salary
    public double calculateNetSalary(Employee e) {
        double gross = calculateGrossSalary(e);
        double tax = calculateTax(gross);
        return gross - tax;
    }
}
