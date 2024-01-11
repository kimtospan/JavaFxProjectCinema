package cinema;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ScreeningFileReader {
    private static final String DELIMITER = ",";
//this method will read the screenings from the file and return a list of screenings to use 
//in the screening scene creator
    public List<Screening> readScreenings(String screeningsFilePath, String seatStatesFilePath) throws IOException {
        List<Screening> screenings = new ArrayList<>();

        try (BufferedReader screeningsReader = new BufferedReader(new FileReader(screeningsFilePath));
             BufferedReader seatStatesReader = new BufferedReader(new FileReader(seatStatesFilePath))) {

            String screeningsLine;
            String seatStatesLine;
            while ((screeningsLine = screeningsReader.readLine()) != null
                    && (seatStatesLine = seatStatesReader.readLine()) != null) {
                String[] screeningsData = screeningsLine.split(DELIMITER);

                String eventId = screeningsData[0];
                String movieTitle = screeningsData[1];
                String hallId = screeningsData[2];
                String date = screeningsData[3];
                String timeOfScreening = screeningsData[4];
                byte fullSeats = Byte.parseByte(screeningsData[5]);
                byte reservedSeatsNumber = Byte.parseByte(screeningsData[6]);

                List<Seat> reservedSeats = readSeatStates(seatStatesLine);

                screenings.add(new Screening(eventId, movieTitle, hallId, date, timeOfScreening, fullSeats, reservedSeatsNumber, reservedSeats));
            }
        }

        return screenings;
    }

    //this method will read the seat states from the file and return a list of seats to use
    //in the seat states scene creator

    public List<Seat> readSeatStates(String seatStatesLine) {
        List<Seat> reservedSeats = new ArrayList<>();
        String[] seatStatesData = seatStatesLine.split(DELIMITER);
        if (seatStatesData.length > 1) {
            String[] seatsData = seatStatesData[1].substring(1, seatStatesData[1].length() - 1).split("\\)\\(");
            for (String seatData : seatsData) {
                String seatDataWithoutParentheses = seatData.replace("(", "").replace(")", "");
                String[] seatComponents = seatDataWithoutParentheses.split("\\.");
                if (seatComponents.length == 2){
                    try {
                        int row = Integer.parseInt(seatComponents[0]);
                        int column = Integer.parseInt(seatComponents[1]);
                        reservedSeats.add(new Seat(row, column, true));
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid format for seat data: " + seatData);
                    }
                } else {
                    System.out.println("Invalid format for seat data: " + seatData);
                }
            }
        }
        return reservedSeats;
    }
}