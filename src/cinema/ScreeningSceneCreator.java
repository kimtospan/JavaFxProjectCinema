package cinema;

import javafx.beans.property.ReadOnlyStringWrapper;
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
        //i had done the mistake of using movie id instead of title as properties of a screening
        //so i use cellData.getValue() to get the screening object of the row and then getMovieTitleById() to get the title of the movie
        // the ReadOnlyStringWrapper wraps the movie in a observable value so that the table can observe it 
        movieTitleColumn.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getMovieTitleById()));

        TableColumn<Screening, String> timeOfScreeningColumn = new TableColumn<>("Time Of Screening");
        timeOfScreeningColumn.setCellValueFactory(new PropertyValueFactory<>("timeOfScreening"));
        
        TableColumn<Screening, Integer> availableSeatsColumn = new TableColumn<>("Available Seats");
        availableSeatsColumn.setCellValueFactory(new PropertyValueFactory<>("availableSeats"));


        //add columns to the table

        screeningTableView.getColumns().add(movieTitleColumn);
        screeningTableView.getColumns().add(timeOfScreeningColumn);
        screeningTableView.getColumns().add(availableSeatsColumn);

        Scene scene = new Scene(screeningTableView, width, height);
        return scene;

        }
        
        
        
        
        public void handle(MouseEvent event) {

        }
    

}