package cinema;

import java.io.IOException;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class PartySceneCreator extends SceneCreator implements EventHandler<MouseEvent>{

    PartyFileReader partyFileReader = new PartyFileReader();
    List<Party> parties = null;

    {
        try {
            parties = partyFileReader.readParties("src/cinema/Party.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    GridPane rootGridPane;
    Button backButton;
    Button bookParty;
    TableView<Party> partyTableView;

    public PartySceneCreator(double width, double height, List<Party> parties) {
        super(width, height);
        this.parties = parties;

        this.rootGridPane = new GridPane();
        partyTableView = new TableView<>();
        backButton = new Button("Back");
        bookParty = new Button("Book Party");

        rootGridPane.setVgap(10);
        rootGridPane.setHgap(10);
        rootGridPane.add(partyTableView, 0, 0);
        partyTableView.setPrefSize(500, 600);
       
        rootGridPane.add(backButton, 0, 1);
        rootGridPane.add(bookParty, 0, 2);

        backButton.setOnMouseClicked(this);
    }

    @Override
    Scene createScene() {
        // define the table columns
        TableColumn<Party, String> eventIdColumn = new TableColumn<>("Event ID");
        eventIdColumn.setCellValueFactory(new PropertyValueFactory<>("eventId"));

        TableColumn<Party, String> dateOfPartyColumn = new TableColumn<>("Date of Party");
        dateOfPartyColumn.setCellValueFactory(new PropertyValueFactory<>("dateOfParty"));

        TableColumn<Party, String> timeOfPartyColumn = new TableColumn<>("Time of Party");
        timeOfPartyColumn.setCellValueFactory(new PropertyValueFactory<>("timeOfParty"));

        TableColumn<Party, Integer> numberOfPeopleColumn = new TableColumn<>("Number of People");
        numberOfPeopleColumn.setCellValueFactory(new PropertyValueFactory<>("numberOfPeople"));

        // Add more columns as needed...

        partyTableView.setItems(FXCollections.observableArrayList(parties));

        //add columns to the table
        partyTableView.getColumns().add(eventIdColumn);
        partyTableView.getColumns().add(dateOfPartyColumn);
        partyTableView.getColumns().add(timeOfPartyColumn);
        partyTableView.getColumns().add(numberOfPeopleColumn);

        // Add more columns to the table as needed...

        Scene scene = new Scene(rootGridPane, width, height);
        return scene;
    }

    public void handle(MouseEvent event) {
        if (event.getSource() == backButton) {
            App.primaryStage.setScene(App.mainScene);
            App.primaryStage.setTitle("Main Menu");
        }
    }
}