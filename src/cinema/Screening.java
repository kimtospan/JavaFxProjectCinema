package cinema;

public class Screening extends Event {
    private String screeningId;
    private String movieId;
    private String hallId;
    private String date;   
    private String timeOfScreening;
    private String fullSeats;
    private String reservedSeats;

    

    public Screening(String screeningId, String movieId, String hallId, String date, String timeOfScreening, String fullSeats, String reservedSeats) {
        this.screeningId = screeningId;
        this.movieId = movieId;
        this.hallId = hallId;
        this.date = date;
        this.timeOfScreening = timeOfScreening;
        this.fullSeats = fullSeats;
        this.reservedSeats = reservedSeats;
    }
}