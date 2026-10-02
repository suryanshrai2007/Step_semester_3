package assigment_problems;

import java.util.*;

interface NotificationChannel {
    void send(String studentName, String message);
    String getChannelName();
}

class EmailChannel implements NotificationChannel {
    public void send(String studentName, String message) {
        System.out.println("[Email -> " + studentName + "] " + message);
    }
    public String getChannelName() { return "Email"; }
}

class SmsChannel implements NotificationChannel {
    public void send(String studentName, String message) {
        System.out.println("[SMS -> " + studentName + "] " + message);
    }
    public String getChannelName() { return "SMS"; }
}

class AppChannel implements NotificationChannel {
    public void send(String studentName, String message) {
        System.out.println("[App -> " + studentName + "] " + message);
    }
    public String getChannelName() { return "App"; }
}

class Student3 {
    String name;
    String department;
    List<NotificationChannel> preferredChannels;

    Student3(String name, String department, List<NotificationChannel> preferredChannels) {
        this.name = name;
        this.department = department;
        this.preferredChannels = preferredChannels;
    }
}

class Notice {
    String title;
    List<String> targetDepartments;

    Notice(String title, List<String> targetDepartments) {
        this.title = title;
        this.targetDepartments = targetDepartments;
    }
}

class NoticeBoard {
    private List<Student3> students = new ArrayList<>();

    void addStudent(Student3 student) {
        students.add(student);
    }

    void postNotice(Notice notice) {
        if (notice.title == null || notice.title.trim().isEmpty()) {
            System.out.println("Cannot post notice: Title is required.");
            return;
        }
        if (notice.targetDepartments == null || notice.targetDepartments.isEmpty()) {
            System.out.println("Cannot post notice: At least one target department is required.");
            return;
        }

        System.out.println("Notice '" + notice.title + "' posted to "
                + String.join(", ", notice.targetDepartments) + ".");

        for (Student3 student : students) {
            if (notice.targetDepartments.contains(student.department)) {
                for (NotificationChannel channel : student.preferredChannels) {
                    channel.send(student.name, notice.title);
                }
            }
        }
    }
}

public class Problem5 {
    public static void main(String[] args) {
        NoticeBoard board = new NoticeBoard();

        Student3 asha = new Student3("Asha", "CSE", Arrays.asList(new EmailChannel(), new AppChannel()));
        Student3 ravi = new Student3("Ravi", "ECE", Arrays.asList(new SmsChannel()));

        board.addStudent(asha);
        board.addStudent(ravi);

        board.postNotice(new Notice("Lab Closed Tomorrow", Arrays.asList("CSE")));
        board.postNotice(new Notice("Fee Deadline Extended", Arrays.asList("CSE", "ECE")));
        board.postNotice(new Notice("Sports Day", new ArrayList<>()));
    }
}