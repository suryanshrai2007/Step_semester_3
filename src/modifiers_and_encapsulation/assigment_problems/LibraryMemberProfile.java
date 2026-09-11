public class LibraryMemberProfile {

    public static void main(String[] args) {
        System.out.println(
                AccessChecker.classifyAccess(
                        "private",
                        "SAME_CLASS"
                )
        );


        String[][] attempts = {

                {"private", "SAME_CLASS"},

                {"private", "SAME_PACKAGE"},

                {"default", "SAME_PACKAGE"},

                {"default", "DIFFERENT_PACKAGE"},

                {"protected", "SAME_PACKAGE"},

                {"protected", "SAME_CLASS"},

                {"public", "DIFFERENT_PACKAGE"}
        };


        System.out.println(
                AccessChecker.summarizeByModifier(attempts)
        );


        // =========================
        // PROBLEM 2
        // =========================

        String[][] attempts2 = {

                {"public",
                        "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"},

                {"protected",
                        "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"},

                {"protected",
                        "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"}
        };


        System.out.println(
                AccessChecker.firstDeniedAttempt(attempts2)
        );


        // =========================
        // PROBLEM 4
        // =========================

        LibraryMember m = new LibraryMember();


        m.setMembershipId("LIB-8841");

        m.setName("Priya Nair");

        m.setPremiumMember(true);


        System.out.println(
                m.getMembershipId()
        );


        // Second assignment ignored
        m.setMembershipId("FAKE-0000");


        System.out.println(
                m.getMembershipId()
        );


        System.out.println(
                m.isPremiumMember()
        );


        // Write-only property
        m.setSecurityAnswer("BlueMountain");
    }
}