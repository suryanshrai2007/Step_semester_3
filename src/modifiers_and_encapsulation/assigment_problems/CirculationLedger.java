public class CirculationLedger {
    static {
        System.out.println(
                "Circulation Ledger initialized"
        );
    }
    static String processNightlyCirculation(
            LoanReceipt[] receipts) {
        int processed = 0;
        int nullSkipped = 0;
        int referenceOnly = 0;
        int regular = 0;
        for (int i = 0; i < receipts.length; i++) {
            if (receipts[i] == null) {
                nullSkipped++;
                continue;}
            processed++;
            if (receipts[i]
                    instanceof ReferenceOnlyLoanReceipt) {
                referenceOnly++;
            }
            else {
                regular++;
            }
        }
        return processed +
                " processed | " +
                nullSkipped +
                " null skipped | " +
                referenceOnly +
                " reference-only | " +
                regular +
                " regular";
    }
    public static void main(String[] args) {
        LoanReceipt r =
                new LoanReceipt(
                        "LIB-8841",
                        new String[]{
                                "BK-100",
                                "BK-101"
                        }
                );
        String[] ids = r.getBookIds();
        ids[0] = "HACKED";
        System.out.println(
                r.getBookIds()[0]
        );
        LoanReceipt corrected =
                r.withCorrectedBook(
                        1,
                        "BK-102"
                );
        System.out.println(
                r.getBookIds()[0]
        );

        System.out.println(
                r.getBookIds()[1]
        );

        System.out.println(
                corrected.getBookIds()[0]
        );

        System.out.println(
                corrected.getBookIds()[1]
        );
  LoanReceipt[] receipts = {
                new ReferenceOnlyLoanReceipt(
                        "LIB-001",
                        new String[]{"BK-200"},
                        "Reading Room 3"
                ),
                null,
                new LoanReceipt(
                        "LIB-002",
                        new String[]{"BK-201"}
                )
        };
        System.out.println(
                processNightlyCirculation(receipts)
        );
    }
}