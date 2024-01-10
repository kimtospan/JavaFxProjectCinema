package cinema;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class ScreeningSceneCreator extends SceneCreator implements EventHandler<MouseEvent>{

    private TableView<Screening> screeningTableView;

    public ScreeningSceneCreator(double width, double height) {
        super(width, height);
        screeningTableView = new TableView<>();
    }

    @Override
        Scene createScene() {
        // define the table columns
        TableColumn<Screening, String> movieTitleColumn = new TableColumn<>("Movie Title");
        movieTitleColumn.setCellValueFactory(new PropertyValueFactory<>("movieTitle"));

        TableColumn<Screening, String> timeOfScreeningColumn = new TableColumn<>("Time Of Screening");
        timeOfScreeningColumn.setCellValueFactory(new PropertyValueFactory<>("timeOfScreening"));
        
        TableColumn<Screening, Integer> availableSeatsColumn = new TableColumn<>("Available Seats");
        availableSeatsColumn.setCellValueFactory(new PropertyValueFactory<>("availableSeats"));


        //add columns to the table

        screeningTableView.getColumns().add(movieTitleColumn);
        screeningTableView.getColumns().add(timeOfScreeningColumn);
        screeningTableView.getColumns().add(availableSeatsColumn);

        }
        
        
        
        
        public void handle(MouseEvent event) {

        }
    

}