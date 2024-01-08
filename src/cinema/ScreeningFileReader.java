package cinema;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ScreeningFileReader {
    private static final String DELIMITER = ",";

    
    
    public List<Screening> readScreenings(String screeningsFilePath, String seatStatesFilePath) throws IOException {
        List<Screening> screenings = new ArrayList<>();

        try (BufferedReader screeningsReader = new BufferedReader(new FileReader(screeningsFilePath));
             BufferedReader seatStatesReader = new BufferedReader(new FileReader(seatStatesFilePath)))
              {

            String screeningsLine;
            String seatStatesLine;
            while ((screeningsLine = screeningsReader.readLine()) != null
                    && (seatStatesLine = seatStatesReader.readLine()) != null) {
                String[] screeningsData = screeningsLine.split(DELIMITER);
                String[] seatStatesData = seatStatesLine.split(DELIMITER);

                String eventId = screeningsData[0];
                String movieId = screeningsData[1];
                String hallId = screeningsData[2];
                String date = screeningsData[3];
                String timeOfScreening = screeningsData[4];
                String fullSeats = screeningsData[5];
                String reservedSeatsNumber = screeningsData[6];

                List<Seat> reservedSeats = new ArrayList<>();
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
                            //we assume that every seat found in the SeatStates.txt file is reserved
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid format for seat data: " + seatData);
                            // handle error
                        }
                    } else {
                        System.out.println("Invalid format for seat data: " + seatData);
                        System.out.println(Arrays.toString(seatComponents));
                        System.out.println("seatStatesData[1]: " + seatStatesData[1]);
                        System.out.println(Arrays.toString(seatsData));
                    }
                    }
                }

                screenings.add(new Screening(eventId, movieId, hallId, date, timeOfScreening, fullSeats, reservedSeatsNumber, reservedSeats));
            }
        }

        return screenings;
    }
}