package cinema;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
//follows the logic of every other file reader
//Using a comma as a delimiter , use buffered reader
//every part is a different attribute of the party object
public class PartyFileReader {

    public List<Party> readParties(String filePath) throws IOException {
        List<Party> parties = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            //you know the drill
            //if the line is not empty split and add
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" , ");
                String eventId = parts[0];
                String dateOfParty = parts[1];
                String timeOfParty = parts[2];
                short numberOfPeople = Short.parseShort(parts[3]);
                String foodChoice = parts[4];
                boolean cake = Boolean.parseBoolean(parts[5]);
                boolean clown = Boolean.parseBoolean(parts[6]);
                boolean animater = Boolean.parseBoolean(parts[7]);
                parties.add(new Party(eventId, dateOfParty, timeOfParty, numberOfPeople, foodChoice , cake, clown, animater));
            }
        }
        return parties;
    }
}