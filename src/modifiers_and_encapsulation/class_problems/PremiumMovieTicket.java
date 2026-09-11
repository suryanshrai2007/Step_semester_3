package modifiers_and_encapsulation.class_problems;

public class PremiumMovieTicket extends MovieTicket {
    public PremiumMovieTicket(int seatNumber, int screenId, double ticketPrice, String movieTitle) {
        super(seatNumber, screenId, ticketPrice, movieTitle);
    }
}