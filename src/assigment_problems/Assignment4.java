package assignment4;

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
        return "Standard | Sessions: " + sessionsAttended;
    }
}

class PremiumMember extends GymMember {
    private String trainerName;

    public PremiumMember(String memberId, int monthlyFee, String trainerName) {
        super(memberId, monthlyFee);
        this.trainerName = trainerName;
    }

    public String getTrainerName() {
        return trainerName;
    }

    @Override
    public String displayInfo() {
        return "Premium | Trainer: " + trainerName + " | Sessions: " + getSessionsAttended();
    }
}

class AnnouncementPrinter {
    static String batchPrint(GymMember[] members) {
        StringBuilder sb = new StringBuilder();

        for (GymMember m : members) {
            sb.append(m.displayInfo()); // polymorphic call, no instanceof chain

            if (m instanceof PremiumMember) {
                PremiumMember pm = (PremiumMember) m; // guarded downcast
                sb.append(" [Trainer via downcast: ").append(pm.getTrainerName()).append("]");
            }
            sb.append(" | ");
        }

        return sb.toString();
    }
}

public class Assignment4 {
    public static void main(String[] args) {
        GymMember[] members = {
                new GymMember("MEM06", 1000),
                new PremiumMember("MEM7", 2000, "Coach Riya")
        };
        System.out.println(AnnouncementPrinter.batchPrint(members));
        // Standard | Sessions: 0 | Premium | Trainer: Coach Riya | Sessions: 0 [Trainer via downcast: Coach Riya] |

        GymMember plain = new GymMember("MEM08", 1000);
        try {
            PremiumMember bad = (PremiumMember) plain; // compiles, fails at runtime
        } catch (ClassCastException e) {
            System.out.println("ClassCastException at runtime: " + e.getMessage());
        }
    }
}