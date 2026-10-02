package assignment5;

class GymMember {
    private static int counter = 0;

    public final String membershipNumber;
    protected int monthlyFee;
    private int feesPaid;
    private String lastMode;

    public GymMember(int monthlyFee) {
        counter++;
        this.membershipNumber = "GYM-" + (2000 + counter);
        this.monthlyFee = monthlyFee;
    }

    public void payFee(int amount) {
        feesPaid += amount;
    }

    public void payFee(int amount, String mode) {
        this.lastMode = mode;
        payFee(amount); // delegate to one-arg version
    }

    public int getFeesPaid() {
        return feesPaid;
    }

    static boolean isValidReferralCode(String code) {
        if (code == null || code.length() != 4) return false;
        if (code.charAt(0) != 'G') return false;
        if (!Character.isDigit(code.charAt(1))) return false;
        if (!Character.isDigit(code.charAt(2))) return false;
        if (!Character.isUpperCase(code.charAt(3))) return false;
        return true;
    }

    static int getMembersEnrolled() {
        return counter;
    }
}

class GroupClassMember extends GymMember {
    private String className;

    public GroupClassMember(int monthlyFee, String className) {
        super(monthlyFee);
        this.className = className;
    }
}

class CheckInSystem {
    static String processWeeklyCheckIn(GymMember[] members) {
        int processed = 0, nullSkipped = 0, group = 0, individual = 0;

        for (GymMember m : members) {
            if (m == null) {
                nullSkipped++;
                continue;
            }
            processed++;
            if (m instanceof GroupClassMember) group++;
            else individual++;
        }

        return processed + " processed | " + nullSkipped + " null skipped | "
                + group + " group | " + individual + " individual";
    }
}

public class Assignment5 {
    public static void main(String[] args) {
        GymMember m1 = new GymMember(1000);
        System.out.println(m1.membershipNumber);                 // GYM-2001
        System.out.println(GymMember.getMembersEnrolled());      // 1

        System.out.println(GymMember.isValidReferralCode("G45B")); // true
        System.out.println(GymMember.isValidReferralCode("G4B"));  // false
        System.out.println(GymMember.isValidReferralCode("X45B")); // false

        m1.payFee(500);
        m1.payFee(500, "UPI");
        System.out.println(m1.getFeesPaid()); // 1000

        GymMember[] batch = {
                new GroupClassMember(1500, "Zumba"),
                null,
                new GymMember(1000)
        };
        System.out.println(CheckInSystem.processWeeklyCheckIn(batch));
        // 2 processed | 1 null skipped | 1 group | 1 individual
    }
}