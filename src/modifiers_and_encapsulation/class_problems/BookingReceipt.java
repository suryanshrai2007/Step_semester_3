package modifiers_and_encapsulation.class_problems;

import java.util.Arrays;

public class BookingReceipt {
    final String bookingId;
    final String[] seatNumbers;

    public BookingReceipt(String bookingId, String[] seatNumbers) {
        this.bookingId = bookingId;
        this.seatNumbers = Arrays.copyOf(seatNumbers, seatNumbers.length);
    }

    String[] getSeatNumbers() {
        return Arrays.copyOf(seatNumbers, seatNumbers.length);
    }

    BookingReceipt withUpdatedSeat(int index, String newSeat) {
        String[] updatedSeats = Arrays.copyOf(seatNumbers, seatNumbers.length);
        updatedSeats[index] = newSeat;
        return new BookingReceipt(bookingId, updatedSeats);
    }

    public static void main(String[] args) {
        BookingReceipt b = new BookingReceipt("CH-1001", new String[]{"A1", "A2"});
        String[] seats = b.getSeatNumbers();
        seats[0] = "X";
        System.out.println(b.getSeatNumbers()[0]);

        BookingReceipt updated = b.withUpdatedSeat(1, "A3");
        System.out.println(Arrays.toString(b.getSeatNumbers()));
        System.out.println(Arrays.toString(updated.getSeatNumbers()));
    }
}