class LibraryMember {
    private String membershipPin;
    String branchCode;
    protected double finesOwed;
    public String displayName;
    private String membershipId;
    private String name;
    private boolean premiumMember;
    private String securityAnswer;
    public LibraryMember() {
        membershipPin = "1234";
        branchCode = "BR01";
        finesOwed = 0;
        displayName = "Member";
    }
    public String getMembershipId() {
        return membershipId;
    }
    public void setMembershipId(String id) {
        if (membershipId == null) {
            membershipId = id;
        }
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public boolean isPremiumMember() {
        return premiumMember;
    }
    public void setPremiumMember(boolean premium) {
        premiumMember = premium;
    }
    public void setSecurityAnswer(String answer) {
        securityAnswer = Integer.toHexString(answer.hashCode());
    }
}
class AccessChecker {
    static String classifyAccess(String fieldModifier,
                                 String accessorContext) {
        if (fieldModifier.equals("private")) {
            if (accessorContext.equals("SAME_CLASS")) {
                return "ALLOWED";
            }
            return "DENIED";
        }
        if (fieldModifier.equals("default")) {
            if (accessorContext.equals("SAME_CLASS") ||
                    accessorContext.equals("SAME_PACKAGE")) {
                return "ALLOWED";
            }
            return "DENIED";
        }
        if (fieldModifier.equals("protected")) {
            if (accessorContext.equals("SAME_CLASS") ||
                    accessorContext.equals("SAME_PACKAGE") ||
                    accessorContext.equals(
                            "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE")) {
                return "ALLOWED";
            }
            return "DENIED";
        }
        if (fieldModifier.equals("public")) {
            return "ALLOWED";
        }
        return "DENIED";
    }
    static String summarizeByModifier(String[][] attempts) {
        int privateAllowed = 0;
        int privateDenied = 0;
        int defaultAllowed = 0;
        int defaultDenied = 0;
        int protectedAllowed = 0;
        int protectedDenied = 0;
        int publicAllowed = 0;
        int publicDenied = 0;
        for (int i = 0; i < attempts.length; i++) {
            String modifier = attempts[i][0];
            String context = attempts[i][1];
            String result =
                    classifyAccess(modifier, context);
            if (modifier.equals("private")) {
                if (result.equals("ALLOWED"))
                    privateAllowed++;
                else
                    privateDenied++;
            }
            else if (modifier.equals("default")) {
                if (result.equals("ALLOWED"))
                    defaultAllowed++;
                else
                    defaultDenied++;
            }
            else if (modifier.equals("protected")) {
                if (result.equals("ALLOWED"))
                    protectedAllowed++;
                else
                    protectedDenied++;
            }
            else if (modifier.equals("public")) {
                if (result.equals("ALLOWED"))
                    publicAllowed++;
                else
                    publicDenied++;
            }
        }
        return "private: " + privateAllowed +
                " allowed / " + privateDenied +
                " denied | default: " + defaultAllowed +
                " allowed / " + defaultDenied +
                " denied | protected: " +
                protectedAllowed + " allowed / " +
                protectedDenied + " denied | public: " +
                publicAllowed + " allowed / " +
                publicDenied + " denied";
    }
    static String firstDeniedAttempt(String[][] attempts) {
        for (int i = 0; i < attempts.length; i++) {
            String modifier = attempts[i][0];
            String context = attempts[i][1];
            String result =
                    classifyAccess(modifier, context);
            if (result.equals("DENIED")) {
                return modifier +
                        " via " +
                        context +
                        " (attempt #" +
                        (i + 1) +
                        ")";
            }
        }
        return "None Denied";
    }
}