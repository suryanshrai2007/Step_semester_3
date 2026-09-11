package modifiers_and_encapsulation.class_problems;

public class MovieTicket {
    private int seatNumber;
    int screenId;
    protected double ticketPrice;
    public String movieTitle;

    public MovieTicket(int seatNumber, int screenId, double ticketPrice, String movieTitle) {
        this.seatNumber = seatNumber;
        this.screenId = screenId;
        this.ticketPrice = ticketPrice;
        this.movieTitle = movieTitle;
    }
}