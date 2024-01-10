package cinema;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
//Class to read the movies from the file movies.txt

public class MovieFileReader {
    private static List<Movie> movies = new ArrayList<>();

    public List<Movie> readMoviesFromFile(String filePath) {
       movies.clear();
        
        //It opens the file at the given path.
        //It reads the file line by line.
        //For each line, it splits the line into parts using the comma as a delimiter.
        //It trims each part to remove leading and trailing whitespace.
        //It creates a new Movie object using the parts as the fields.
        //It adds the Movie object to a list.
        //After all lines have been read, it returns the list of movies.

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                
                String[] parts = line.split(",");
                if (parts.length != 5) {
                    System.out.println("Invalid line: " + line);
                    continue;
                }
                //Use trim() to remove leading and trailing whitespace
                String uniqueId = parts[0].trim();
                String title = parts[1].trim();
                String productionDate = parts[2].trim();
                String[] actors = parts[3].trim().split(";"); 
                int length = Integer.parseInt(parts[4].trim());

                Movie movie = new Movie(uniqueId, title, productionDate, actors, length);
                movies.add(movie);
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        

        return movies;
    }

    
    public static String getTitleFromId(String id){
        for (Movie movie : movies) {
            if (movie.getUniqueId().equals(id)) {
                return movie.getTitle();
            }
        }
        return null;
    }
}