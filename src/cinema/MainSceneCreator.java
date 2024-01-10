package cinema;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.input.MouseEvent;

public class MainSceneCreator extends SceneCreator implements EventHandler<MouseEvent>{

    public MainSceneCreator(double width, double height) {
        super(width, height);
    }

    @Override
    Scene createScene() {
        Pane layout = new Pane();
        // Add your main scene creation logic here
        return new Scene(layout, width, height);
    }

    @Override
    public void handle(MouseEvent event) {
        
    }
}