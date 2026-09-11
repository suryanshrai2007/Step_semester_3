package oop_constructs.class_problems;

public class SrmStudent {
    String name;

    static String collegeName;
    static int academicYear;

    static {
        collegeName = "SRM Institute of Science and Technology";
        academicYear = 2026;
        System.out.println("College info loaded");
    }

    public SrmStudent(String name) {
        this.name = name;
        System.out.println("Student record created: " + name);
    }

    public static void main(String[] args) {
        String[] names = {"Ravi", "Meera", "Karthik", "Divya", "Anitha"};

        for (String name : names) {
            new SrmStudent(name);
        }
    }
}