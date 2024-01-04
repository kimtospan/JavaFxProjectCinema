package cinema;
import cinema.Seat;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
//Will make the reserved seats into a map, with the key being the event id and the value being the number 
//They have inside the 2d array of hall seats
public class Screening extends Event {
    private String screeningId;
    private String movieId;
    private String hallId;
    private String date;   
    private String timeOfScreening;
    private String fullSeats;
    private String reservedSeatsNumber;
    private Map<String, List<Seat>> reservedSeatsMap;
    

    

    public Screening(String screeningId, String movieId, String hallId, String date, String timeOfScreening, String fullSeats, String reservedSeatsNumber, Seat ReservedSeats) {
        this.screeningId = screeningId;
        this.movieId = movieId;
        this.hallId = hallId;
        this.date = date;
        this.timeOfScreening = timeOfScreening;
        this.fullSeats = fullSeats;
        this.reservedSeatsNumber = reservedSeatsNumber;
        this.reservedSeatsMap = new HashMap<>();
    }

    public void addReservedSeats(String eventId, List<Seat[]> list) {
        this.reservedSeatsMap.put(eventId, list);
    }

    public List<Seat> getReservedSeats(String eventId) {
        return this.reservedSeatsMap.get(eventId);
    }
}