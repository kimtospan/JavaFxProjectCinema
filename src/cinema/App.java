package cinema;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import cinema.MovieFileReader;
import cinema.Movie;
import cinema.HallFileReader;
import cinema.Hall;
import cinema.ScreeningFileReader;

public class App extends Application {
    static Stage primaryStage;
    static Scene mainScene;
    static Scene ScreeningScene;
    static Scene PartyScene;
    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;

        ScreeningFileReader screeningFileReader = new ScreeningFileReader();
        List<Screening> screenings = screeningFileReader.readScreenings("src/cinema/Screening.txt", "src/cinema/SeatStatesScreening.txt");

        PartyFileReader partyFileReader = new PartyFileReader();
        List<Party> parties = partyFileReader.readParties("src/cinema/Party.txt");



       
        SceneCreator mainSceneCreator = new MainSceneCreator(650, 300);
        mainScene = mainSceneCreator.createScene();

        SceneCreator ScreeningSceneCreator = new ScreeningSceneCreator(650, 300 , screenings); 
        ScreeningScene = ScreeningSceneCreator.createScene();
       
        SceneCreator PartySceneCreator = new PartySceneCreator(650, 300, parties);
        PartyScene = PartySceneCreator.createScene();

        primaryStage.setTitle("Cinema Management System");
        primaryStage.setScene(mainScene);
        primaryStage.show();

        

        
        

       
        

    }

    public void listMovies() {
        // Create a new Stage for the movie list
        Stage movieStage = new Stage();
        movieStage.setTitle("List of Movies");

        // Create a VBox layout for the movie list
        VBox layout = new VBox(10);

        // Use the MovieFileReader to read the list of movies
        MovieFileReader movieFileReader = new MovieFileReader();
        List<Movie> movies = movieFileReader.readMoviesFromFile("src/cinema/Movies.txt");

        // Create a Label for each movie and add it to the layout
        for (Movie movie : movies) {
            Label movieLabel = new Label(movie.getTitle());
            layout.getChildren().add(movieLabel);
        }

        // Create the scene with the layout and set it on the stage
        Scene scene = new Scene(layout, 300, 250);
        movieStage.setScene(scene);
        movieStage.show();
    }

    public void listHalls() {
        // Create a new Stage for the hall list
        Stage hallStage = new Stage();
        hallStage.setTitle("List of Halls");

        // Create a VBox layout for the hall list
        VBox layout = new VBox(10);

        // Use the HallFileReader to read the list of halls
        HallFileReader hallFileReader = new HallFileReader();
        List<Hall> halls = hallFileReader.ReadHallsFromLine("src/cinema/Halls.txt");

        // Create a Label for each hall and add it to the layout
        for (Hall hall : halls) {
            Label hallLabel = new Label(hall.getHallId() + " " + hall.getDescription());
            layout.getChildren().add(hallLabel);
        }

        // Create the scene with the layout and set it on the stage
        Scene scene = new Scene(layout, 300, 250);
        hallStage.setScene(scene);
        hallStage.show();
    }

    public static void main(String[] args) {
        launch(args);

    }

    public void issueTicket() {
        // Ask the user for the hall ID, row, and column of the seat they want to
        // reserve
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the hall ID:");
        int hallId = scanner.nextInt();
        System.out.println("Enter the row number:");
        int row = scanner.nextInt();
        System.out.println("Enter the column number:");
        int column = scanner.nextInt();

        // Check if the seat is available
        boolean seatAvailable = checkSeatAvailability(hallId, row, column);

        // If the seat is available, reserve it and print a ticket
        if (seatAvailable) {
            reserveSeat(hallId, row, column);
            printTicket(hallId, row, column);
        } else {
            // If the seat is not available, print an error message
            System.out.println("The seat is not available.");
        }
    }

    private boolean checkSeatAvailability(int hallId, int row, int column) {
        // Implement the logic to check if the seat is available in the specified hall
        // Return true if the seat is available, false otherwise
        // You can use the information from the List<Hall> halls to check the seat
        // availability
        // You may need to modify the Hall class to include a data structure to store
        // the seat availability
        // Example implementation:
        // Hall hall = getHallById(hallId);
        // return hall.isSeatAvailable(row, column);
        return false; // Placeholder
    }

    private void reserveSeat(int hallId, int row, int column) {
        // Implement the logic to reserve the seat in the specified hall
        // You can use the information from the List<Hall> halls to reserve the seat
        // You may need to modify the Hall class to update the seat availability after
        // reserving the seat
        // Example implementation:
        // Hall hall = getHallById(hallId);
        // hall.reserveSeat(row, column);
    }

    private void printTicket(int hallId, int row, int column) {
        // Implement the logic to print the ticket for the reserved seat
        // You can use the information from the List<Hall> halls to get the hall details
        // Example implementation:
        // Hall hall = getHallById(hallId);
        // Movie movie = getMovieByHallId(hallId);
        // System.out.println("Ticket Details:");
        // System.out.println("Movie: " + movie.getTitle());
        // System.out.println("Hall: " + hall.getDescription());
        // System.out.println("Seat: Row " + row + ", Column " + column);
    }

    private void listPlannedScreenings() {
        // This function's purpose is to execute the functions that read the text files
        // relating to a screening, create the objects, and list them
        ScreeningFileReader screeningFileReader = new ScreeningFileReader();
        // Create a new Stage for the hall list
        Stage plannedScreeningsStage = new Stage();
        plannedScreeningsStage.setTitle("List of Planned Screenings");
        try {
            List<Screening> screenings = screeningFileReader.readScreenings("src/cinema/Screening.txt",
                    "src/cinema/SeatStatesScreening.txt");

            // Create a VBox layout for the planned screening list
            VBox layout = new VBox(10);
            for (Screening screening : screenings) {
                Label screeningLabel = new Label(screening.getEventId() + " " + " "
                        + screening.getHallId() + " " + screening.getDate() + " " + screening.getTimeOfScreening() + " "
                        + screening.getFullSeats() + " " + screening.getReservedSeatsNumber());
                layout.getChildren().add(screeningLabel);
            }

            // Create the scene with the layout and set it on the stage
            Scene scene = new Scene(layout, 400, 350);
            plannedScreeningsStage.setScene(scene);
            plannedScreeningsStage.show();

        } catch (IOException e) {
            System.out.println("Error reading file" + e.getMessage());
        }
    }

    private void checkEventSeats() {
        /*
         * With this function a user will be able to choose an event , and see the seat
         * states
         * //of that event
         * // The logic is he presses the button "Check Event Seats" /new scene/
         * //in this scene there will be a dropdown menu with the eventIds
         * //When he chooses an event, /new scene/ a gridpane of buttons representing a
         * hall with its seats
         * //will appear.
         * //each button will have a color depending on its state
         * 
         * //all of this could be done in one scene only but i dont want to change what
         * already works
         * //if it wasnt for an exercise and i cared for actual user experience id do it
         * better
         */

        // Create a new scene with a dropdown list and a confirm button
        ScreeningFileReader screeningFileReader = new ScreeningFileReader();
        try{
        List<Screening> screenings = screeningFileReader.readScreenings("src/cinema/Screening.txt", "src/cinema/SeatStatesScreening.txt");
        ObservableList<String> eventIds = FXCollections.observableArrayList();
        
        for (Screening screening : screenings) {
            eventIds.add(screening.getEventId());
        }
        ComboBox<String> comboBox = new ComboBox<>(eventIds);
        Button confirmButton = new Button("Confirm");

        // Add an action listener to the confirm button
        confirmButton.setOnAction(e -> {
            String selectedEventId = comboBox.getValue();
            Screening selectedScreening = findScreeningByEventId(selectedEventId, screenings);
            List<Seat> reservedSeats = selectedScreening.getReservedSeats(selectedEventId);

            // Create a new scene to display the hall and its seats
            GridPane grid = new GridPane();
            //Before i put "10" i had hall.getRows() and hall.getColumns() but it didnt work lmao i dont got time
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    Button seatButton = new Button();
                    //use contains to check if the seat the user wants is reserved or not
                    if (reservedSeats.contains(new Seat(i, j, true))) {
                        seatButton.setStyle("-fx-background-color: red;"); // Reserved seat
                    } else {
                        seatButton.setStyle("-fx-background-color: green;"); // Available seat
                    }
                    grid.add(seatButton, j, i);
                }
            }
            

            // Show the new scene
            Scene scene = new Scene(grid);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        });
    }catch(IOException e){
            System.out.println("Error reading file" + e.getMessage());
        }
    }
    //This method has the purpose of finding the event for the methd above it 
    private Screening findScreeningByEventId(String selectedEventId, List<Screening> screenings) {
        for (Screening screening : screenings) {
            if (screening.getEventId().equals(selectedEventId)) {
                return screening;
            }
        }
        return null;
    }



    private void listParties() {
        // This function's purpose is to execute the functions that read the text files
        // relating to a party, create the objects, and list them
        PartyFileReader partyFileReader = new PartyFileReader();
        // Create a new Stage for the hall list
        Stage partyStage = new Stage();
        partyStage.setTitle("List of Parties");
        try {
            // List of party objexcts from the partyfilereader
            List<Party> parties = partyFileReader.readParties("src/cinema/Party.txt");

            // Create a VBox layout for the planned screening list
            VBox layout = new VBox(10);
            for (Party party : parties) {
                Label partyLabel = new Label(party.getEventId() + " " + party.getDateOfParty() + " "
                        + party.getTimeOfParty() + " " + party.getNumberOfPeople() + " " + party.getFoodChoice() + " "
                        + party.hasCake() + " " + party.hasClown() + " " + party.hasAnimater());
                layout.getChildren().add(partyLabel);
            }

            // Create the scene with the layout and set it on the stage
            Scene scene = new Scene(layout, 400, 350);
            partyStage.setScene(scene);
            partyStage.show();

        } catch (IOException e) {
            System.out.println("Error reading file" + e.getMessage());
        }
    }

    
    
}