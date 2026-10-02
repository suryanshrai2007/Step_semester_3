package assignment1;

class GymMember {
    protected String memberId;
    protected int monthlyFee;
    private int sessionsAttended;

    public GymMember(String memberId, int monthlyFee) {
        if (memberId == null || memberId.trim().isEmpty() || memberId.trim().length() < 4) {
            throw new IllegalArgumentException("Invalid memberId: " + memberId);
        }
        this.memberId = memberId;
        this.monthlyFee = monthlyFee;
    }

    public void attendSession() {
        sessionsAttended++;
    }

    public int getSessionsAttended() {
        return sessionsAttended;
    }
}

class PremiumMember extends GymMember {
    private String trainerName;

    public PremiumMember(String memberId, int monthlyFee, String trainerName) {
        super(memberId, monthlyFee);
        this.trainerName = trainerName;
    }
}

class GymSignup {
    static String signUpBatch(String[] memberIds, int monthlyFee) {
        int signedUp = 0, rejected = 0;
        for (String id : memberIds) {
            try {
                new GymMember(id, monthlyFee); // constructor does the validation
                signedUp++;
            } catch (IllegalArgumentException e) {
                rejected++;
            }
        }
        return "Signed Up: " + signedUp + " | Rejected: " + rejected;
    }
}

public class Assignment1 {
    public static void main(String[] args) {
        try {
            new GymMember("GM1", 1000);
        } catch (IllegalArgumentException e) {
            System.out.println("construction rejected");
        }

        PremiumMember p = new PremiumMember("MEM01", 2000, "Coach Riya");
        p.attendSession();
        p.attendSession();
        System.out.println(p.getSessionsAttended()); // 2

        System.out.println(GymSignup.signUpBatch(
                new String[]{"MEM1", "GM1", "MEM2", " ", "MEM3"}, 1000));
        // Signed Up: 3 | Rejected: 2
    }
}