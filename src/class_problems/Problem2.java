package problem2;

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
        return "General Member | Books Borrowed: " + booksBorrowed;
    }
}

class StudentMember extends LibraryMember {
    private String course;

    public StudentMember(String memberId, int borrowLimit, String course) {
        super(memberId, borrowLimit);
        this.course = course;
    }

    protected String getCourse() {
        return course;
    }

    @Override
    public String displayInfo() {
        return "Student Member | Course: " + course + " | Books Borrowed: " + getBooksBorrowed();
    }
}

class HonorsStudentMember extends StudentMember {
    private int bonusLimit;

    public HonorsStudentMember(String memberId, int borrowLimit, String course, int bonusLimit) {
        super(memberId, borrowLimit, course);
        this.bonusLimit = bonusLimit;
    }

    @Override
    public String displayInfo() {
        return "Honors Student Member | Course: " + getCourse()
                + " | Bonus Limit: " + bonusLimit
                + " | Books Borrowed: " + getBooksBorrowed();
    }
}

class FacultyMember extends LibraryMember {
    private String department;

    public FacultyMember(String memberId, int borrowLimit, String department) {
        super(memberId, borrowLimit);
        this.department = department;
    }

    @Override
    public String displayInfo() {
        return "Faculty Member | Department: " + department + " | Books Borrowed: " + getBooksBorrowed();
    }
}

class MembershipUtil {
    static String classifyGeneration(LibraryMember member) {
        if (member instanceof HonorsStudentMember) {
            return "Multilevel descendant (3 generations deep)";
        } else if (member instanceof FacultyMember) {
            return "Hierarchical sibling (independent branch)";
        } else if (member instanceof StudentMember) {
            return "Direct student subclass";
        } else {
            return "Base member";
        }
    }

    static int getTotalBooksBorrowed(LibraryMember[] members) {
        int total = 0;
        for (LibraryMember m : members) {
            total += m.getBooksBorrowed(); // polymorphic call
        }
        return total;
    }
}

public class Problem2 {
    public static void main(String[] args) {
        LibraryMember gen = new LibraryMember("STU1", 3);
        StudentMember student = new StudentMember("STU2", 3, "CSE");
        HonorsStudentMember honors = new HonorsStudentMember("STU3", 3, "ECE", 2);
        FacultyMember faculty = new FacultyMember("STU4", 5, "Physics");

        System.out.println(gen.displayInfo());
        System.out.println(student.displayInfo());
        System.out.println(honors.displayInfo());
        System.out.println(faculty.displayInfo());

        System.out.println(MembershipUtil.classifyGeneration(honors));  // Multilevel descendant...
        System.out.println(MembershipUtil.classifyGeneration(faculty)); // Hierarchical sibling...

        student.borrowBook();
        student.borrowBook();       // 2
        honors.borrowBook();        // 1
        faculty.borrowBook();
        faculty.borrowBook();
        faculty.borrowBook();       // 3

        int total = MembershipUtil.getTotalBooksBorrowed(
                new LibraryMember[]{student, honors, faculty});
        System.out.println(total); // 6
    }
}