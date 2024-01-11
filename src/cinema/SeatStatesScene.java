package cinema;

import java.util.List;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
//The logic of this scene is a grid pane filled with rectangle where each rectangle represents a seat.
//The color of the button is red if the seat is reserved and green if it is not reserved.

public class SeatStatesScene extends Scene implements EventHandler<MouseEvent>{
    private Button backButton = new Button("Back");
    
    public SeatStatesScene(List<Seat> seats) {
        super(new GridPane(), 250, 250);
        GridPane grid = new GridPane();

        // a renctangle to represent the hall
        Rectangle hall = new Rectangle(200, 200);
        hall.setFill(Color.BLACK);
        hall.setStroke(Color.WHITE);
        hall.setStrokeWidth(2.0);
        
        //new grid for the seats?
        GridPane seatsGrid = new GridPane();

        for (Seat seat : seats) {
            Rectangle rect = new Rectangle(20, 20);
            rect.setFill(seat.isReserved() ? Color.RED : Color.GREEN);

            seatsGrid.add(rect, seat.getColumn(), seat.getRow());
        }
        grid.add(backButton, 1, 1);
        grid.add(seatsGrid, 2,2);
        backButton.setOnMouseClicked(this);

        grid.add(hall, 2, 2, 10, 10);

        this.setRoot(grid);
    }

    @Override
    public void handle(MouseEvent event) {
       if (event.getSource() == backButton) {
           App.primaryStage.setScene(App.ScreeningScene);
           App.primaryStage.setTitle("Screenings");
       }
    }
}