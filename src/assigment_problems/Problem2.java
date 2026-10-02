package assigment_problems;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

abstract class Assignment {
    String title;
    LocalDate dueDate;
    int maxMarks;

    Assignment(String title, LocalDate dueDate, int maxMarks) {
        this.title = title;
        this.dueDate = dueDate;
        this.maxMarks = maxMarks;
    }

    abstract double applyLatePenalty(double awardedMarks, long daysLate);
}

class CodingAssignment extends Assignment {
    CodingAssignment(String title, LocalDate dueDate, int maxMarks) {
        super(title, dueDate, maxMarks);
    }

    double applyLatePenalty(double awardedMarks, long daysLate) {
        double penalty = 0.10 * daysLate;
        if (penalty > 1) penalty = 1;
        return awardedMarks * (1 - penalty);
    }
}

class WrittenAssignment extends Assignment {
    WrittenAssignment(String title, LocalDate dueDate, int maxMarks) {
        super(title, dueDate, maxMarks);
    }

    double applyLatePenalty(double awardedMarks, long daysLate) {
        double penalty = 0.20 * daysLate;
        if (penalty > 1) penalty = 1;
        return awardedMarks * (1 - penalty);
    }
}

class Student2 {
    String name;
    Student2(String name) { this.name = name; }
}

enum SubmissionStatus { SUBMITTED, GRADED }

class Submission {
    private Student2 student;
    private Assignment assignment;
    private LocalDate submissionDate;
    private SubmissionStatus status;
    private double finalMarks;

    Submission(Student2 student, Assignment assignment, LocalDate submissionDate) {
        this.student = student;
        this.assignment = assignment;
        this.submissionDate = submissionDate;
        this.status = SubmissionStatus.SUBMITTED;

        long daysLate = ChronoUnit.DAYS.between(assignment.dueDate, submissionDate);
        if (daysLate < 0) daysLate = 0;

        if (daysLate == 0) {
            System.out.println(student.name + "'s submission for '" + assignment.title
                    + "' received (on time). Status: Submitted.");
        } else {
            System.out.println(student.name + "'s submission for '" + assignment.title
                    + "' received (" + daysLate + " days late). Status: Submitted.");
        }
    }

    void grade(double awardedMarks) {
        if (status == SubmissionStatus.GRADED) {
            System.out.println("Cannot resubmit: '" + assignment.title + "' has already been graded.");
            return;
        }
        long daysLate = ChronoUnit.DAYS.between(assignment.dueDate, submissionDate);
        if (daysLate < 0) daysLate = 0;

        if (daysLate > 0) {
            double penaltyPercent = (assignment instanceof CodingAssignment ? 10 : 20) * daysLate;
            finalMarks = assignment.applyLatePenalty(awardedMarks, daysLate);
            status = SubmissionStatus.GRADED;
            System.out.println(student.name + " graded: " + (int) finalMarks + "/" + assignment.maxMarks
                    + " after " + penaltyPercent + "% late penalty. Status: Graded.");
        } else {
            finalMarks = awardedMarks;
            status = SubmissionStatus.GRADED;
            System.out.println(student.name + " graded: " + (int) finalMarks + "/" + assignment.maxMarks
                    + ". Status: Graded.");
        }
    }

    void attemptResubmit() {
        if (status == SubmissionStatus.GRADED) {
            System.out.println("Cannot resubmit: '" + assignment.title + "' has already been graded.");
        }
    }
}

public class Problem2 {
    public static void main(String[] args) {
        CodingAssignment linkedListLab = new CodingAssignment("Linked List Lab",
                LocalDate.of(2025, 3, 10), 50);
        WrittenAssignment designEssay = new WrittenAssignment("Design Essay",
                LocalDate.of(2025, 3, 12), 50);

        Student2 asha = new Student2("Asha");
        Student2 ravi = new Student2("Ravi");

        Submission ashaSub = new Submission(asha, linkedListLab, LocalDate.of(2025, 3, 10));
        Submission raviSub = new Submission(ravi, designEssay, LocalDate.of(2025, 3, 14));

        ashaSub.grade(45);
        raviSub.grade(40);

        ashaSub.attemptResubmit();
    }
}