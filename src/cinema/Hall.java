package cinema;

public class Hall {
    private String hallId;
    private String description;
    private int rows;
    private int columns;
    // a 2d array to represent every seat in a movie hall
    private Seat[][] seats;

    public Hall(String hallId, String description, int rows, int columns, Seat[][] seats) {
        this.hallId = hallId;
        this.description = description;
        this.rows = rows;
        this.columns = columns;
        this.seats = new Seat[rows][columns];
        // when creating a hall, every seat is not reserved by default
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                seats[i][j] = new Seat(i, j, false);
            }
        }

    }

    // Get em and send em

    public String getHallId() {
        return hallId;
    }

    public void setHallId(String hallId) {
        this.hallId = hallId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

}
