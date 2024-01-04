package cinema;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ScreeningFileReader {
    
    //I got stuck here* for a day, i asked a programmer friend of mine for help and he gave me the pattern and matcher classes
    //*here = i couldnt think of how to read the seats and create the objects every startup. 
    //the idea i have is that we have 2 files Screening.txt that holds basic info about a screening event and a SeatStateScreening.txt
    //that will hold only 2 things, the eventId and a every seat that is reserved. (like s1, [(1,2)(4,3)])
    //Then we will read the SeatStateScreening.txt and create the 2d array, and every seat found in the file
    //will turn from isReserved = false to isReserved = true.
    //The help i received was the Pattern and Matcher classes

    private static Seat[][] parseSeats(String seatsString) {
        List<Seat[]> seatsList = new ArrayList<>();
        //this is what i didnt know how to do
        Pattern pattern = Pattern.compile("\\((\\d+),(\\d+)\\)");
        Matcher matcher = pattern.matcher(seatsString);
        while (matcher.find()) {
            int row = Integer.parseInt(matcher.group(1));
            int column = Integer.parseInt(matcher.group(2));
            seatsList.add(new Seat[]{new Seat(row, column, true)});
        }
        return seatsList.toArray(new Seat[0][0]);
    }

    public void readSeatStatesFromFile(String filePath, Screening screening) {
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                String eventId = parts[0];
                Seat[][] seats = parseSeats(parts[1]); // assuming the seats are the second part of the line
                screening.addReservedSeats(eventId, Arrays.asList(seats));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        }
    }

    public static List<Screening> readScreeningsFromFile(String filePath) {
        List<Screening> screenings = new ArrayList<>();
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                Seat[][] seats = parseSeats(parts[parts.length - 1]); // assuming the seats are the last part of the line
                // Create a Screening instance with the parsed seats
                // Example: Screening screening = new Screening(parts[0], parts[1], ..., seats);
                //          screenings.add(screening);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        }
        return screenings;
    }
}

