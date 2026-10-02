package problem4;

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

    public String displayInfo() {
        return "General | Books: " + booksBorrowed;
    }
}

class StudentMember extends LibraryMember {
    private String course;

    public StudentMember(String memberId, int borrowLimit, String course) {
        super(memberId, borrowLimit);
        this.course = course;
    }

    public String getCourse() {
        return course;
    }

    @Override
    public String displayInfo() {
        return "Student | Course: " + course + " | Books: " + getBooksBorrowed();
    }
}

class ReportPrinter {
    static String batchPrint(LibraryMember[] members) {
        StringBuilder sb = new StringBuilder();

        for (LibraryMember m : members) {
            sb.append(m.displayInfo()); // polymorphic call, no instanceof chain

            if (m instanceof StudentMember) {
                StudentMember sm = (StudentMember) m; // guarded downcast
                sb.append(" [Course via downcast: ").append(sm.getCourse()).append("]");
            }
            sb.append(" | ");
        }

        return sb.toString();
    }
}

public class Problem4 {
    public static void main(String[] args) {
        LibraryMember[] members = {
                new LibraryMember("LB05", 3),
                new StudentMember("STU6", 3, "ECE")
        };
        System.out.println(ReportPrinter.batchPrint(members));
        // General | Books: 0 | Student | Course: ECE | Books: 0 [Course via downcast: ECE] |

        LibraryMember plain = new LibraryMember("LB06", 3);
        try {
            StudentMember bad = (StudentMember) plain; // compiles, fails at runtime
        } catch (ClassCastException e) {
            System.out.println("ClassCastException at runtime: " + e.getMessage());
        }
    }
}