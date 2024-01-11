package cinema;

public abstract class Event {

    protected String eventId;
    protected String type;
    protected String movieUniqueId;
    


public String getMovieUniqueId() {
    return movieUniqueId;
}

public void setMovieUniqueId(String movieUniqueId) {
    this.movieUniqueId = movieUniqueId;
}
}