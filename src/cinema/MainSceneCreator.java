package cinema;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.input.MouseEvent;

public class MainSceneCreator extends SceneCreator implements EventHandler<MouseEvent>{
    FlowPane rootflowPane;
    Button handleScreeningsbutton , handlePartiesButton;

    public MainSceneCreator(double width, double height) {
        super(width, height);

        rootflowPane = new FlowPane();

        handleScreeningsbutton = new Button("Handle Screenings");
        handlePartiesButton = new Button("Handle Parties");

    }

    @Override
    Scene createScene() {
    rootflowPane.getChildren().add(handleScreeningsbutton);
    rootflowPane.getChildren().add(handlePartiesButton);
    
    handleScreeningsbutton.setOnMouseClicked(this);
    handlePartiesButton.setOnMouseClicked(this);

    return new Scene(rootflowPane, width, height);
}

@Override
public void handle(MouseEvent event) {
    if (event.getSource() == handleScreeningsbutton) {
       App.primaryStage.setScene(App.ScreeningScene);
       App.primaryStage.setTitle("Screenings");
    } else if (event.getSource() == handlePartiesButton) {
        App.primaryStage.setScene(App.PartyScene);
        App.primaryStage.setTitle("Parties");
    }
}
}