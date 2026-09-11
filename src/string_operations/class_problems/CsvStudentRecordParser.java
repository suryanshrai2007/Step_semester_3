package string_operations.class_problems;

public class CsvStudentRecordParser {

    static void parseStudentRecord(String csvLine) {
        String[] fields = csvLine.split(",");

        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        String name = fields[0];
        String rollNumber = fields[1];
        String department = fields[2];

        System.out.println("Name: " + name + " | Roll No: " + rollNumber + " | Dept: " + department);
    }

    public static void main(String[] args) {
        String validRecord = "Ananya Verma,RA2211003010123,CSE";
        String invalidRecord = "Ananya Verma,CSE";

        parseStudentRecord(validRecord);
        parseStudentRecord(invalidRecord);
    }
}