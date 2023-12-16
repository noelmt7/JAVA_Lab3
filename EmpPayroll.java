package LAB_3;
import java.util.Scanner;

class Employee {
    int employeeId;
    String employeeName;
    String designation;
    double weeklyearnings;
    double weeklysalary;
    double calculateBonus() {
        return 0.0;
    }
   
    void display() {
        System.out.println("Employee ID: "+employeeId+"\nEmploye name: "+employeeName+
                "\nDesignation: "
                +designation+"\nWeekly Salary: "+weeklysalary+"\nAnnual Earnings: " +AnnualEarnings());
    }
    
    double AnnualEarnings() {
        return weeklyearnings * 52;
    }

}

class HourlyEmployee extends Employee {
    double hourlyRate;
    int hoursWorked;

    
    HourlyEmployee(double hourlyRate, int hoursWorked) {
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
        weeklyearnings = hourlyRate * hoursWorked;
    }

}
class SalariedEmployee extends Employee {
    double monthlySalary;
    
    SalariedEmployee(double mt) {
        this.monthlySalary = mt;
        weeklysalary = monthlySalary / 4;
    }
    
    void display() {
        super.display();
        System.out.println("Monthly salary: " + monthlySalary);
    }
    
    double AnnualEarnings() {
        return monthlySalary * 12;
    }

}
class ExecutiveEmployee extends SalariedEmployee {
    double bonusPercentage;

    ExecutiveEmployee(int employeeId, String employeeName, String designation, double bonusPercentage, double ms) {
        super(ms);
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.designation = designation;
        this.bonusPercentage = bonusPercentage;
        this.weeklyearnings = (monthlySalary + calculateBonus()) / 4;
    }

    double calculateBonus() {
        double baseBonus = super.calculateBonus();
        double executiveBonus = monthlySalary * (bonusPercentage / 100);
        weeklyearnings += executiveBonus;
        return baseBonus + executiveBonus;
    }
    
    void display() {
        super.display();
        System.out.println("Bonus Percentage: " + bonusPercentage);
        System.out.println("Weekly Earnings: " + weeklyearnings);
    }
   
    double AnnualEarnings() {
        return super.AnnualEarnings() + calculateBonus() * 12;
    }
}

public class EmpPayroll {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        System.out.println("Enter employeeid: ");
        int employeeId = input.nextInt();
        input.nextLine();
        System.out.println("Enter name:");
        String employeeName = input.nextLine();
        System.out.println("Enter designation:");
        String designation = input.nextLine();

        System.out.println("Enter monthly salary:");
        double monthlySalary = input.nextDouble();

        HourlyEmployee h = new HourlyEmployee(10.0, 20);
        ExecutiveEmployee ex = new ExecutiveEmployee(employeeId, employeeName,
                designation, 15.0, monthlySalary);
        ex.display();
    }
}
