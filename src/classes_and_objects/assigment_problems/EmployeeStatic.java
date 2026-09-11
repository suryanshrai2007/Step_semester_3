package classes_and_objects.assigment_problems;

public class EmployeeStatic {
    String empName;
    double salary;

    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    public EmployeeStatic(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    public static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }

    public static void main(String[] args) {
        EmployeeStatic e1 = new EmployeeStatic("A", 40000);
        EmployeeStatic e2 = new EmployeeStatic("B", 42000);
        EmployeeStatic e3 = new EmployeeStatic("C", 45000);

        EmployeeStatic.printCompanyInfo();
    }
}