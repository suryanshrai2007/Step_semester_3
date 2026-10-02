package assigment_problems;

import java.util.*;

abstract class Seat {
    String seatId;
    Seat(String seatId) { this.seatId = seatId; }
    abstract double getPrice();
}

class RegularSeat extends Seat {
    RegularSeat(String seatId) { super(seatId); }
    double getPrice() { return 150.0; }
}

class PremiumSeat extends Seat {
    PremiumSeat(String seatId) { super(seatId); }
    double getPrice() { return 250.0; }
}

class ReclinerSeat extends Seat {
    ReclinerSeat(String seatId) { super(seatId); }
    double getPrice() { return 400.0; }
}

class Customer {
    String name;
    Customer(String name) { this.name = name; }
}

class Show {
    String showName;
    private Set<String> bookedSeatIds = new HashSet<>();

    Show(String showName) { this.showName = showName; }

    boolean isSeatAvailable(String seatId) {
        return !bookedSeatIds.contains(seatId);
    }

    void markBooked(String seatId) { bookedSeatIds.add(seatId); }

    void releaseSeats(List<Seat> seats) {
        for (Seat s : seats) bookedSeatIds.remove(s.seatId);
    }
}

class Booking {
    Customer customer;
    Show show;
    List<Seat> seats;
    private boolean cancelled = false;

    Booking(Customer customer, Show show, List<Seat> seats) {
        this.customer = customer;
        this.show = show;
        this.seats = seats;
    }

    double getTotal() {
        double total = 0;
        for (Seat s : seats) total += s.getPrice();
        return total;
    }

    void cancel() {
        if (cancelled) return;
        cancelled = true;
        show.releaseSeats(seats);
        StringBuilder sb = new StringBuilder();
        for (Seat s : seats) sb.append(s.seatId).append(", ");
        sb.setLength(sb.length() - 2);
        System.out.println(customer.name + "'s booking cancelled. Seats " + sb + " released.");
    }
}

class BookingCounter {
    static Booking bookSeats(Customer customer, Show show, List<Seat> requestedSeats) {
        List<Seat> successfullyBooked = new ArrayList<>();
        for (Seat seat : requestedSeats) {
            if (!show.isSeatAvailable(seat.seatId)) {
                System.out.println("Seat " + seat.seatId + " is already booked for this show.");
                continue;
            }
            show.markBooked(seat.seatId);
            successfullyBooked.add(seat);
        }
        if (successfullyBooked.isEmpty()) return null;

        Booking booking = new Booking(customer, show, successfullyBooked);
        StringBuilder sb = new StringBuilder();
        for (Seat s : successfullyBooked) sb.append(s.seatId).append(", ");
        sb.setLength(sb.length() - 2);
        System.out.println("Booking confirmed for " + customer.name + ": " + sb
                + ". Total: Rs." + String.format("%.2f", booking.getTotal()));
        return booking;
    }
}

public class Problem3 {
    public static void main(String[] args) {
        Show show7pm = new Show("7 PM Show");
        Customer asha = new Customer("Asha");
        Customer ravi = new Customer("Ravi");
        Customer neha = new Customer("Neha");

        Booking ashaBooking = BookingCounter.bookSeats(asha, show7pm, Arrays.asList(
                new RegularSeat("A1"), new RegularSeat("A2"), new PremiumSeat("F5")));

        BookingCounter.bookSeats(ravi, show7pm, Arrays.asList(new RegularSeat("A2")));

        BookingCounter.bookSeats(ravi, show7pm, Arrays.asList(new ReclinerSeat("R1")));

        ashaBooking.cancel();

        BookingCounter.bookSeats(neha, show7pm, Arrays.asList(new RegularSeat("A2")));
    }
}