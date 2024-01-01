package cinema;

import java.util.List;
import java.util.Scanner;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import cinema.MovieFileReader;
import cinema.Movie;
import cinema.HallFileReader;
import cinema.Hall;

public class App extends Application {
    public static List<Hall> halls;
    public static List<Movie> movies;

    // @Override
    public void start(Stage primaryStage) throws Exception {
        //When application starts, load hall data from file and store it in a list
        //So we can implement a seat reservation system after 
        HallFileReader hallFileReader = new HallFileReader();
        halls = hallFileReader.ReadHallsFromLine("src\\cinema\\Halls.txt");

        //The same for movie 
        MovieFileReader movieFileReader = new MovieFileReader();
        movies = movieFileReader.readMoviesFromFile("src\\cinema\\Movies.txt");


        
        
          primaryStage.setTitle("Cinema Management System");
          Button btn = new Button();
            btn.setText("Say 'Hello World'");
            btn.setOnAction(new EventHandler<ActionEvent>() {
         
                @Override
                public void handle(ActionEvent event) {
                    System.out.println("Hello World!");
                }
            });

            Label welcomeLabel = new Label("Welcome to the Cinema Management System!");
            Button listMoviesButton = new Button("List movies");
            Button listHallsButton = new Button("List halls");
            Button bookScreeningButton = new Button("Create a Screening event");
            Button bookPartyButton = new Button("Create a Party event");

            listMoviesButton.setOnAction(event -> listMovies());
            listHallsButton.setOnAction(event -> listHalls());
            //bookScreeningButton.setOnAction(event -> bookScreening());
            //bookPartyButton.setOnAction(event -> bookParty());

            VBox layout = new VBox(10);
            layout.getChildren().addAll(welcomeLabel, listMoviesButton, listHallsButton, bookScreeningButton, bookPartyButton);
            //Create the scene
          
        
        
        Scene scene = new Scene(layout, 300, 250); 
        primaryStage.setScene(scene);
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
        // Ask the user for the hall ID, row, and column of the seat they want to reserve
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
        // You can use the information from the List<Hall> halls to check the seat availability
        // You may need to modify the Hall class to include a data structure to store the seat availability
        // Example implementation:
        // Hall hall = getHallById(hallId);
        // return hall.isSeatAvailable(row, column);
        return false; // Placeholder
    }

    private void reserveSeat(int hallId, int row, int column) {
        // Implement the logic to reserve the seat in the specified hall
        // You can use the information from the List<Hall> halls to reserve the seat
        // You may need to modify the Hall class to update the seat availability after reserving the seat
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
}