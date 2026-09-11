package modifiers_and_encapsulation.class_problems;

public class CineScreen {
    private int seatsTotal;
    private int seatsAvailable;
    private boolean validConstruction;

    public CineScreen(int seatsTotal) {
        if (seatsTotal <= 0) {
            this.validConstruction = false;
            System.out.println("construction rejected");
        } else {
            this.seatsTotal = seatsTotal;
            this.seatsAvailable = seatsTotal;
            this.validConstruction = true;
        }
    }

    void bookSeat() {
        if (seatsAvailable > 0) {
            seatsAvailable--;
        }
    }

    void cancelBooking() {
        if (seatsAvailable < seatsTotal) {
            seatsAvailable++;
        }
    }

    int getSeatsAvailable() {
        return seatsAvailable;
    }

    public static void main(String[] args) {
        CineScreen rejected = new CineScreen(0);

        CineScreen c = new CineScreen(2);
        c.bookSeat();
        c.bookSeat();
        c.bookSeat();
        System.out.println(c.getSeatsAvailable());

        c.cancelBooking();
        c.cancelBooking();
        c.cancelBooking();
        System.out.println(c.getSeatsAvailable());
    }
}