package problem3;

import java.util.Arrays;

class LibraryMember {
    protected String memberId;
    protected int borrowLimit;
    private int booksBorrowed;

    private int[] fineHistory = new int[10];
    private int fineCount = 0;

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

    protected void chargeFine(int amount) {
        if (fineCount < fineHistory.length) {
            fineHistory[fineCount++] = amount;
        }
    }

    int[] getFineHistory() {
        int[] copy = new int[fineCount];
        System.arraycopy(fineHistory, 0, copy, 0, fineCount);
        return copy; // defensive copy
    }

    int getTotalFine() {
        int total = 0;
        for (int i = 0; i < fineCount; i++) total += fineHistory[i];
        return total;
    }
}

class StudentMember extends LibraryMember {
    public StudentMember(String memberId, int borrowLimit, String course) {
        super(memberId, borrowLimit);
    }

    @Override
    protected void chargeFine(int amount) {
        super.chargeFine(amount / 2); // reuse parent's deduction + recording logic
    }
}

public class Problem3 {
    public static void main(String[] args) {
        StudentMember s = new StudentMember("STU5", 3, "CSE");
        s.chargeFine(100);
        System.out.println(s.getTotalFine()); // 50

        int[] history = s.getFineHistory();
        history[0] = 999; // tampering with returned copy
        System.out.println(Arrays.toString(s.getFineHistory())); // [50]
    }
}