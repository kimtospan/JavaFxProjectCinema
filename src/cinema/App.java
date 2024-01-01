package cinema;

import java.util.List;
import java.util.Scanner;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
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


         Parent root = FXMLLoader.load(getClass().getResource("hellofx.fxml"));
        
          primaryStage.setTitle("Cinema Management System");
          
          Scene scene = new Scene(root, 300, 250,Color.AQUA);
          primaryStage.setScene(scene);
          primaryStage.show();
         
    }
    public static void printMovies() {
        for (Movie movie : movies) {
            System.out.println(movie.getTitle());
        }
    }
    public static void printHalls() {
        for (Hall hall : halls) {
            System.out.print(hall.getHallId() + " " + hall.getDescription() + " ");
            System.out.println();
        }

    }

    public static void main(String[] args) {
        launch(args);

       

        System.out.println("Welcome to the Cinema Management System!");
        System.out.println("The greatest cinema management system ever created.");
        int choice = 1;
        
        do{
        System.out.println("Please select an option:");
        System.out.println("1. List movies");
        System.out.println("2. List halls");
        System.out.println("3. Issue ticket");
        System.out.println("4. Exit");
       

       
        
        try (Scanner scanner = new Scanner(System.in)) {
           
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("You selected option 1");
                    printMovies();
                   
                    break;
                case 2:
                    System.out.println("You selected option 2");
                    printHalls();
                    break;
                case 3:
                    System.out.println("You selected option 3");
                    //This will issue a ticket and occupy a seat
                    break;
                case 4:
                    System.out.println("You selected option 4");

                    // Close application
                    System.exit(0);
                    break;
                
                default:
                    System.out.println("Invalid option");
                    break;
            
        }
        }
    }while(choice != 4);

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