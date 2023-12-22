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

public class App extends Application {

    //@Override
      public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("hellofx.fxml"));
       /*  primaryStage.setTitle("Cinema Management System");
        Group root = new Group();
        Scene scene = new Scene(root, 300, 250,Color.AQUA);
        primaryStage.setScene(scene);
        primaryStage.show();*/
    }


    public static void main(String[] args) {
        //launch(args);
        System.out.println("Welcome to the Cinema Management System!");
        System.out.println("Please select an option:");
        System.out.println("1. List movies");
        System.out.println("2. List halls");
        System.out.println("3. Exit");
        int choice;
        
        MovieFileReader movieFileReader = new MovieFileReader();
        List<Movie> movies = movieFileReader.readMoviesFromFile("src\\cinema\\Movies.txt");
        HallFileReader hallFileReader = new HallFileReader();
        List<Hall> halls = hallFileReader.ReadHallsFromLine("src\\cinema\\Halls.txt");
        try ( Scanner scanner = new Scanner(System.in)){
        choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println("You selected option 1");
                for (Movie movie : movies) {
                    System.out.println(movie.getTitle());
                }
                break;
            case 2:
                System.out.println("You selected option 2");
                for (Hall hall : halls) {
                    System.out.print(hall.getHallId() + " " + hall.getDescription() + " ");
                    System.out.println();
                }
                break;
            case 3:
                System.out.println("You selected option 3");
                
                //Close application
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option");
                break;
        }   
    }
       
    }


   
   
}