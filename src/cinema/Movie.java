package cinema;

//The actors will be a list of strings, because a movie can have multiple actors.
public class Movie {
    private String uniqueId;
    private String title;
    private String productionDate;
    private String[] actors; // make actors an array of strings
    private int length;

    // Constructor
    public Movie(String uniqueId, String title, String productionDate, String[] actors, int length) {
        this.uniqueId = uniqueId;
        this.title = title;
        this.productionDate = productionDate;
        this.actors = actors;
        this.length = length;
    }

    // getters and setters
    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }
  
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(String productionDate) {
        this.productionDate = productionDate;
    }

    public String[] getActors() {
        return actors;
    }

    public void setActors(String[] actors) {
        this.actors = actors;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
