package cinema;

import java.util.List;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

public class ScreeningSceneCreator extends SceneCreator implements EventHandler<MouseEvent>{

    GridPane rootGridPane;
    Button backButton;
    TableView<Screening> screeningTableView;
    private List<Screening> screenings;


    public ScreeningSceneCreator(double width, double height, List<Screening> screenings) {
        super(width, height);
        this.screenings = screenings;

        this.rootGridPane = new GridPane();
        screeningTableView = new TableView<>();
        backButton = new Button("Back");

        rootGridPane.setVgap(10);
        rootGridPane.setHgap(10);
        rootGridPane.add(screeningTableView, 0, 0);
        screeningTableView.setPrefSize(500, 600);
       
        rootGridPane.add(backButton, 0, 1);

        backButton.setOnMouseClicked(this);
    }

    @Override
        Scene createScene() {
        // define the table columns
        TableColumn<Screening, String> movieTitleColumn = new TableColumn<>("Movie Title");
        movieTitleColumn.setCellValueFactory(new PropertyValueFactory<>("movieTitle"));


        TableColumn<Screening, String> dateColumn = new TableColumn<>("Date");
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));

        TableColumn<Screening, String> timeOfScreeningColumn = new TableColumn<>("Time Of Screening");
        timeOfScreeningColumn.setCellValueFactory(new PropertyValueFactory<>("timeOfScreening"));
        
        TableColumn<Screening, Integer> availableSeatsColumn = new TableColumn<>("Available Seats");
        availableSeatsColumn.setCellValueFactory(new PropertyValueFactory<>("availableSeats"));

        screeningTableView.setItems(FXCollections.observableArrayList(screenings));


        //add columns to the table

        screeningTableView.getColumns().add(movieTitleColumn);
        screeningTableView.getColumns().add(dateColumn);
        screeningTableView.getColumns().add(timeOfScreeningColumn);
        screeningTableView.getColumns().add(availableSeatsColumn);

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