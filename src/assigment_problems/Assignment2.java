package assignment2;

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

    public String displayInfo() {
        return "Standard Member | Sessions: " + sessionsAttended;
    }
}

class PremiumMember extends GymMember {
    private String trainerName;

    public PremiumMember(String memberId, int monthlyFee, String trainerName) {
        super(memberId, monthlyFee);
        this.trainerName = trainerName;
    }

    protected String getTrainerName() {
        return trainerName;
    }

    @Override
    public String displayInfo() {
        return "Premium Member | Trainer: " + trainerName + " | Sessions: " + getSessionsAttended();
    }
}

class EliteMember extends PremiumMember {
    private String lockerNumber;

    public EliteMember(String memberId, int monthlyFee, String trainerName, String lockerNumber) {
        super(memberId, monthlyFee, trainerName);
        this.lockerNumber = lockerNumber;
    }

    @Override
    public String displayInfo() {
        return "Elite Member | Trainer: " + getTrainerName()
                + " | Locker: " + lockerNumber
                + " | Sessions: " + getSessionsAttended();
    }
}

class GroupClassMember extends GymMember {
    private String className;

    public GroupClassMember(String memberId, int monthlyFee, String className) {
        super(memberId, monthlyFee);
        this.className = className;
    }

    @Override
    public String displayInfo() {
        return "Group Class Member | Class: " + className + " | Sessions: " + getSessionsAttended();
    }
}

class MembershipUtil {
    static String classifyGeneration(GymMember member) {
        if (member instanceof EliteMember) {
            return "Multilevel descendant (3 generations deep)";
        } else if (member instanceof GroupClassMember) {
            return "Hierarchical sibling (independent branch)";
        } else if (member instanceof PremiumMember) {
            return "Direct premium subclass";
        } else {
            return "Base member";
        }
    }

    static int getTotalSessionsAttended(GymMember[] members) {
        int total = 0;
        for (GymMember m : members) {
            total += m.getSessionsAttended(); // polymorphic call
        }
        return total;
    }
}

public class Assignment2 {
    public static void main(String[] args) {
        GymMember standard = new GymMember("MEM1", 1000);
        PremiumMember premium = new PremiumMember("MEM2", 2000, "Coach Riya");
        EliteMember elite = new EliteMember("MEM3", 3000, "Coach Arjun", "L12");
        GroupClassMember groupClass = new GroupClassMember("MEM4", 1500, "Zumba");

        System.out.println(standard.displayInfo());
        System.out.println(premium.displayInfo());
        System.out.println(elite.displayInfo());
        System.out.println(groupClass.displayInfo());

        System.out.println(MembershipUtil.classifyGeneration(elite));       // Multilevel descendant...
        System.out.println(MembershipUtil.classifyGeneration(groupClass));  // Hierarchical sibling...

        premium.attendSession();
        premium.attendSession();
        premium.attendSession();      // 3
        elite.attendSession();
        elite.attendSession();        // 2
        groupClass.attendSession();
        groupClass.attendSession();
        groupClass.attendSession();
        groupClass.attendSession();   // 4

        int total = MembershipUtil.getTotalSessionsAttended(
                new GymMember[]{premium, elite, groupClass});
        System.out.println(total); // 9
    }
}