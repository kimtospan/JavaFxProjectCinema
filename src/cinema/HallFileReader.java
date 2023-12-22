package cinema;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//Class to read the halls from the file halls.txt

public class HallFileReader {
    public List<Hall> ReadHallsFromLine(String filePath) {
        List<Hall> Halls = new ArrayList<>();
        
        //It opens the file at the given path.
        //It reads the file line by line.
        //For each line, it splits the line into parts using the comma as a delimiter.
        //It trims each part to remove leading and trailing whitespace.
        //It creates a new Hall object using the parts as the fields.
        //It adds the Hall object to a list.
        //After all lines have been read, it returns the list of halls.
        //The same logic that is used for movies

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                
                String[] parts = line.split(",");
                if (parts.length != 4) {
                    System.out.println("Invalid line: " + line);
                    continue;
                }
                String hallId = parts[0].trim();
                String description = parts[1].trim();
                int rows = Integer.parseInt(parts[2].trim());
                int columns = Integer.parseInt(parts[3].trim());

                Hall hall = new Hall(hallId, description, rows, columns, null);
                Halls.add(hall);
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return Halls;
    }
}
