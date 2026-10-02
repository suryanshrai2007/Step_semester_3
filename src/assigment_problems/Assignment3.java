package assignment3;

import java.util.Arrays;

class GymMember {
    protected String memberId;
    protected int monthlyFee;
    private int sessionsAttended;

    private int[] lateFeeHistory = new int[10];
    private int feeCount = 0;

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

    protected void chargeLateFee(int amount) {
        if (feeCount < lateFeeHistory.length) {
            lateFeeHistory[feeCount++] = amount;
        }
    }

    int[] getLateFeeHistory() {
        int[] copy = new int[feeCount];
        System.arraycopy(lateFeeHistory, 0, copy, 0, feeCount);
        return copy; // defensive copy
    }

    int getTotalLateFees() {
        int total = 0;
        for (int i = 0; i < feeCount; i++) total += lateFeeHistory[i];
        return total;
    }
}

class PremiumMember extends GymMember {
    public PremiumMember(String memberId, int monthlyFee, String trainerName) {
        super(memberId, monthlyFee);
    }

    @Override
    protected void chargeLateFee(int amount) {
        super.chargeLateFee(amount / 2); // reuse parent's deduction + recording logic
    }
}

public class Assignment3 {
    public static void main(String[] args) {
        PremiumMember p = new PremiumMember("MEM5", 2000, "Coach Riya");
        p.chargeLateFee(200);
        System.out.println(p.getTotalLateFees()); // 100

        int[] history = p.getLateFeeHistory();
        history[0] = 999; // tampering with returned copy
        System.out.println(Arrays.toString(p.getLateFeeHistory())); // [100]
    }
}