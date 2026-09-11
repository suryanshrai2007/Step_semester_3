package modifiers_and_encapsulation.class_problems;

public class GroupBookingReceipt extends BookingReceipt {
    final int groupSize;

    public GroupBookingReceipt(String bookingId, String[] seatNumbers, int groupSize) {
        super(bookingId, seatNumbers);
        this.groupSize = groupSize;
    }
}