package cinema;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class SeatStatesScene extends Scene implements EventHandler<MouseEvent>{
    public SeatStatesScene(List<Seat> seats) {
        GridPane grid = new GridPane();

        for (Seat seat : seats) {
            Rectangle rect = new Rectangle(20, 20);
            rect.setFill(seat.isReserved() ? Color.RED : Color.GREEN);

            grid.add(rect, seat.getColumn(), seat.getRow());
        }

        this.setRoot(grid);
    }

    @Override
    public void handle(MouseEvent arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handle'");
    }
}