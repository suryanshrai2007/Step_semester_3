package assigment_problems;

interface MembershipPlan {
    double calculateFee();
    int getDurationMonths();
    String getPlanName();
}

class MonthlyPlan implements MembershipPlan {
    public double calculateFee() { return 1000.0; }
    public int getDurationMonths() { return 1; }
    public String getPlanName() { return "Monthly"; }
}

class QuarterlyPlan implements MembershipPlan {
    public double calculateFee() { return 1000.0 * 3 * 0.90; }
    public int getDurationMonths() { return 3; }
    public String getPlanName() { return "Quarterly"; }
}

class AnnualPlan implements MembershipPlan {
    public double calculateFee() { return 1000.0 * 12 * 0.75; }
    public int getDurationMonths() { return 12; }
    public String getPlanName() { return "Annual"; }
}

enum MembershipStatus { ACTIVE, FROZEN, EXPIRED }

class Member {
    String name;
    Member(String name) { this.name = name; }
}

class Membership {
    Member member;
    MembershipPlan plan;
    private MembershipStatus status;

    Membership(Member member, MembershipPlan plan) {
        this.member = member;
        this.plan = plan;
        this.status = MembershipStatus.ACTIVE;
        System.out.println(plan.getPlanName() + " membership created for " + member.name
                + ". Fee: Rs." + String.format("%.2f", plan.calculateFee()) + ". Status: Active.");
    }

    void checkIn() {
        if (status == MembershipStatus.ACTIVE) {
            System.out.println(member.name + " checked in successfully.");
        } else {
            System.out.println("Check-in denied: " + member.name + "'s membership is "
                    + capitalize(status.name()) + ".");
        }
    }

    void freeze() {
        if (status == MembershipStatus.ACTIVE) {
            status = MembershipStatus.FROZEN;
            System.out.println(member.name + "'s membership frozen. Status: Frozen.");
        } else if (status == MembershipStatus.EXPIRED) {
            System.out.println("Cannot freeze an Expired membership.");
        } else {
            System.out.println("Membership is already frozen.");
        }
    }

    void unfreeze() {
        if (status == MembershipStatus.FROZEN) {
            status = MembershipStatus.ACTIVE;
            System.out.println(member.name + "'s membership unfrozen. Status: Active.");
        } else if (status == MembershipStatus.EXPIRED) {
            System.out.println("Cannot unfreeze an Expired membership.");
        }
    }

    void expire() {
        status = MembershipStatus.EXPIRED;
        System.out.println(member.name + "'s membership expired. Status: Expired.");
    }

    private String capitalize(String s) {
        return s.charAt(0) + s.substring(1).toLowerCase();
    }
}

public class Problem4 {
    public static void main(String[] args) {
        Member asha = new Member("Asha");
        Member ravi = new Member("Ravi");

        Membership ashaMembership = new Membership(asha, new QuarterlyPlan());
        Membership raviMembership = new Membership(ravi, new MonthlyPlan());

        ashaMembership.checkIn();
        ashaMembership.freeze();
        ashaMembership.checkIn();

        raviMembership.expire();
        raviMembership.freeze();
    }
}