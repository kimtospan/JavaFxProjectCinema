package cinema;
import cinema.Seat;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
//Will make the reserved seats into a map, with the key being the event id and the value being the number 
//They have inside the 2d array of hall seats

//represend a sreening event in a cinema system 
//use a hashmap to save the seats
public class Screening extends Event {
    private String eventId;
    private String movieId;
    private String hallId;
    private String date;   
    private String timeOfScreening;
    private String fullSeats;
    private String reservedSeatsNumber;
    private Map<String, List<Seat>> reservedSeatsMap;


    
    
    public Screening(String eventId, String movieId, String hallId, String date, String timeOfScreening, String fullSeats, String reservedSeatsNumber, List<Seat> reservedSeats) {
        this.eventId = eventId;
        this.movieId = movieId;
        this.hallId = hallId;
        this.date = date;
        this.timeOfScreening = timeOfScreening;
        this.fullSeats = fullSeats;
        this.reservedSeatsNumber = reservedSeatsNumber;
        this.reservedSeatsMap = new HashMap<>();
        if (eventId != null && reservedSeats != null) {
            this.reservedSeatsMap.put(eventId, new ArrayList<>(reservedSeats));
        }
    }

    public void addReservedSeats(String eventId, List<Seat> list) {
        this.reservedSeatsMap.put(eventId, list);
    }

    public List<Seat> getReservedSeats(String eventId) {
        return this.reservedSeatsMap.get(eventId);
    }

    // Getter and Setter methods for eventId
    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    // Getter and Setter methods for movieId
    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    // Getter and Setter methods for hallId
    public String getHallId() {
        return hallId;
    }

    public void setHallId(String hallId) {
        this.hallId = hallId;
    }

    // Getter and Setter methods for date
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    // Getter and Setter methods for timeOfScreening
    public String getTimeOfScreening() {
        return timeOfScreening;
    }

    public void setTimeOfScreening(String timeOfScreening) {
        this.timeOfScreening = timeOfScreening;
    }

    // Getter and Setter methods for fullSeats
    public String getFullSeats() {
        return fullSeats;
    }

    public void setFullSeats(String fullSeats) {
        this.fullSeats = fullSeats;
    }

    // Getter and Setter methods for reservedSeatsNumber
    public String getReservedSeatsNumber() {
        return reservedSeatsNumber;
    }

    public void setReservedSeatsNumber(String reservedSeatsNumber) {
        this.reservedSeatsNumber = reservedSeatsNumber;
    }

    // Getter and Setter methods for reservedSeatsMap
    public Map<String, List<Seat>> getReservedSeatsMap() {
        return reservedSeatsMap;
    }

    public void setReservedSeatsMap(Map<String, List<Seat>> reservedSeatsMap) {
        this.reservedSeatsMap = reservedSeatsMap;
    }
}
    
