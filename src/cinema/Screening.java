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
    //byte since it will never surpass 100. byte is 127 max i am a memory god(if you ignore the 5 sources of memory leak in my code dont @ me)
    private byte fullSeats;
    private byte reservedSeatsNumber;
    private byte availableSeats;
    private Map<String, List<Seat>> reservedSeatsMap;


    
    
    public Screening(String eventId, String movieId, String hallId, String date, String timeOfScreening, byte fullSeats, byte reservedSeatsNumber, List<Seat> reservedSeats) {
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
        availableSeats = (byte) (fullSeats - reservedSeatsNumber);
    }

    public void addReservedSeats(String eventId, List<Seat> list) {
        this.reservedSeatsMap.put(eventId, list);
    }

    public void setAvailableSeats() {
        this.availableSeats = (byte) (fullSeats - reservedSeatsNumber);
    }
    public byte getAvailableSeats() {
        return availableSeats;
    }
    


    public List<Seat> getReservedSeats(String eventId) {
        return this.reservedSeatsMap.get(eventId);
    }
    //this will use the id to activate the getTitleFromId method from the MovieFileReader class
    public String getMovieTitleById(){
        return MovieFileReader.getTitleFromId(movieId);
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
    public byte getFullSeats() {
        return fullSeats;
    }

    public void setFullSeats(byte fullSeats) {
        this.fullSeats = fullSeats;
    }

    // Getter and Setter methods for reservedSeatsNumber
    public byte getReservedSeatsNumber() {
        return reservedSeatsNumber;
    }

    public void setReservedSeatsNumber(byte reservedSeatsNumber) {
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
    
