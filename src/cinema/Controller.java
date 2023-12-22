package cinema;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Controller {

    @FXML
    private Label label;

    public void initialize() {
        // Welcome The User
        label.setText("Welcome to Cinema\nThe greatest management system for cinema employees!");
    }
}