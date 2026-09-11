package modifiers_and_encapsulation.class_problems;

public class NightlySettlementProcessor {

    static String processNightlySettlement(BookingReceipt[] receipts) {
        int processedCount = 0;
        int nullSkipped = 0;
        int groupCount = 0;
        int individualCount = 0;

        for (BookingReceipt receipt : receipts) {
            if (receipt == null) {
                nullSkipped++;
                continue;
            }

            processedCount++;

            if (receipt instanceof GroupBookingReceipt) {
                groupCount++;
            } else {
                individualCount++;
            }
        }

        return processedCount + " processed | " + nullSkipped + " null skipped | "
                + groupCount + " group | " + individualCount + " individual";
    }

    public static void main(String[] args) {
        BookingReceipt[] batch = {
                new GroupBookingReceipt("CH-2002", new String[]{"B1", "B2"}, 2),
                null,
                new BookingReceipt("CH-3003", new String[]{"C1"})
        };

        System.out.println(processNightlySettlement(batch));
    }
}