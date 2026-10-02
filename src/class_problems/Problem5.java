package problem5;

class LibraryMember {
    private static int counter = 0;

    public final String memberNumber;
    protected int borrowLimit;
    private int booksBorrowed;
    private String lastGenre;

    public LibraryMember(int borrowLimit) {
        counter++;
        this.memberNumber = "LIB-" + (100 + counter);
        this.borrowLimit = borrowLimit;
    }

    public void borrowBook() {
        if (booksBorrowed < borrowLimit) booksBorrowed++;
    }

    public void borrowBook(String genre) {
        this.lastGenre = genre;
        borrowBook(); // delegate to no-arg version
    }

    public int getBooksBorrowed() {
        return booksBorrowed;
    }

    static boolean isValidRenewalCode(String code) {
        if (code == null || code.length() != 4) return false;
        if (code.charAt(0) != 'R') return false;
        if (!Character.isDigit(code.charAt(1))) return false;
        if (!Character.isDigit(code.charAt(2))) return false;
        if (!Character.isUpperCase(code.charAt(3))) return false;
        return true;
    }

    static int getMembersEnrolled() {
        return counter;
    }
}

class FacultyMember extends LibraryMember {
    private String department;

    public FacultyMember(int borrowLimit, String department) {
        super(borrowLimit);
        this.department = department;
    }
}

class AuditSystem {
    static String processNightlyAudit(LibraryMember[] members) {
        int processed = 0, nullSkipped = 0, faculty = 0, regular = 0;

        for (LibraryMember m : members) {
            if (m == null) {
                nullSkipped++;
                continue;
            }
            processed++;
            if (m instanceof FacultyMember) faculty++;
            else regular++;
        }

        return processed + " processed | " + nullSkipped + " null skipped | "
                + faculty + " faculty | " + regular + " regular";
    }
}

public class Problem5 {
    public static void main(String[] args) {
        LibraryMember m1 = new LibraryMember(3);
        System.out.println(m1.memberNumber);                     // LIB-101
        System.out.println(LibraryMember.getMembersEnrolled());  // 1

        System.out.println(LibraryMember.isValidRenewalCode("R12A")); // true
        System.out.println(LibraryMember.isValidRenewalCode("R1A"));  // false
        System.out.println(LibraryMember.isValidRenewalCode("X12A")); // false

        m1.borrowBook();
        m1.borrowBook("Fiction");
        System.out.println(m1.getBooksBorrowed()); // 2

        LibraryMember[] batch = {
                new FacultyMember(5, "Physics"),
                null,
                new LibraryMember(3)
        };
        System.out.println(AuditSystem.processNightlyAudit(batch));
        // 2 processed | 1 null skipped | 1 faculty | 1 regular
    }
}