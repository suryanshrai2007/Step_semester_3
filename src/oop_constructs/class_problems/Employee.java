package oop_constructs.class_problems;

public class Employee {
    String empId;
    double salary;

    public Employee(String empId, double salary) {
        this.empId = empId;
        this.salary = salary;
    }

    void raiseSalary(double salary) {
        this.salary = this.salary + salary;
    }

    public void printSalary() {
        System.out.println(empId + " | Final Salary: Rs " + salary);
    }

    public static void main(String[] args) {
        double[] startingSalaries = {40000, 55000, 62000, 48000};
        Employee[] employees = new Employee[startingSalaries.length];

        for (int i = 0; i < startingSalaries.length; i++) {
            employees[i] = new Employee("E-10" + (i + 1), startingSalaries[i]);
            employees[i].raiseSalary(5000);
            employees[i].printSalary();
        }
    }
}