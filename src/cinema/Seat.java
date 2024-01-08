package cinema;

import java.util.Objects;

//create a seat object so later we can create a 2d array to represent every seat in a hall. 

//a seat object has a row and a column to place it in space, and a boolean isReserved for availability
public class Seat {
    private int row;
    private int column;
    private boolean isReserved;

    public Seat(int row, int column, boolean isReserved) {
        this.row = row;
        this.column = column;
        this.isReserved = isReserved;
    }

    // Getters and setters
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }




    //ensure that when a new seat object is created is will corectly identify seats 
    //with the same row and column
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Seat seat = (Seat) obj;
        return row == seat.row && column == seat.column;
    }

      @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }
}
