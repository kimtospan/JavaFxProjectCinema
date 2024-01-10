package cinema;
// party class , to be used in creating objects anew and from the file reader
public class Party extends Event{
    private String eventId;
    private String dateOfParty;
    private String timeOfParty;
    private short numberOfPeople;
    private String foodChoice;
    private boolean cake;
    private boolean clown;
    private boolean animater;

    public Party(String eventId, String dateOfParty, String timeOfParty, short numberOfPeople, String foodChoice ,  boolean cake, boolean clown, boolean animater) {
        this.eventId = eventId;
        this.dateOfParty = dateOfParty;
        this.timeOfParty = timeOfParty;
        this.numberOfPeople = numberOfPeople;
        this.foodChoice = foodChoice;
        this.cake = cake;
        this.clown = clown;
        this.animater = animater;
    }

    // Getters
    public String getEventId() {
        return eventId;
    }

    public String getDateOfParty() {
        return dateOfParty;
    }

    public String getTimeOfParty() {
        return timeOfParty;
    }

    public short getNumberOfPeople() {
        return numberOfPeople;
    }

    public String getFoodChoice() {
        return foodChoice;
    }

    public boolean hasCake() {
        return cake;
    }

    public boolean hasClown() {
        return clown;
    }

    public boolean hasAnimater() {
        return animater;
    }

    // Setters
    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public void setDateOfParty(String dateOfParty) {
        this.dateOfParty = dateOfParty;
    }

    public void setTimeOfParty(String timeOfParty) {
        this.timeOfParty = timeOfParty;
    }

    public void setNumberOfPeople(short numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public void setFoodChoice(String foodChoice) {
        this.foodChoice = foodChoice;
    }

    public void setCake(boolean cake) {
        this.cake = cake;
    }

    public void setClown(boolean clown) {
        this.clown = clown;
    }

    public void setAnimater(boolean animater) {
        this.animater = animater;
    }
}
    
