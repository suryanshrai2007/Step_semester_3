package problem1;

class LibraryMember {
    protected String memberId;
    protected int borrowLimit;
    private int booksBorrowed;

    public LibraryMember(String memberId, int borrowLimit) {
        if (memberId == null || memberId.trim().isEmpty() || memberId.trim().length() < 4) {
            throw new IllegalArgumentException("Invalid memberId: " + memberId);
        }
        this.memberId = memberId;
        this.borrowLimit = borrowLimit;
    }

    public void borrowBook() {
        if (booksBorrowed < borrowLimit) booksBorrowed++;
    }

    public int getBooksBorrowed() {
        return booksBorrowed;
    }
}

class StudentMember extends LibraryMember {
    private String course;

    public StudentMember(String memberId, int borrowLimit, String course) {
        super(memberId, borrowLimit);
        this.course = course;
    }
}

class Library {
    static String enrollBatch(String[] memberIds, int borrowLimit) {
        int enrolled = 0, rejected = 0;
        for (String id : memberIds) {
            try {
                new LibraryMember(id, borrowLimit); // constructor does the validation
                enrolled++;
            } catch (IllegalArgumentException e) {
                rejected++;
            }
        }
        return "Enrolled: " + enrolled + " | Rejected: " + rejected;
    }
}

public class Problem1 {
    public static void main(String[] args) {
        try {
            new LibraryMember("LB1", 3);
        } catch (IllegalArgumentException e) {
            System.out.println("construction rejected");
        }

        StudentMember s = new StudentMember("STU10", 3, "CSE");
        s.borrowBook();
        s.borrowBook();
        System.out.println(s.getBooksBorrowed()); // 2

        System.out.println(Library.enrollBatch(
                new String[]{"STU1", "LB1", "STU2", " ", "STU3"}, 3));
        // Enrolled: 3 | Rejected: 2
    }
}