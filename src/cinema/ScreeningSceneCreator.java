package cinema;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;

public class ScreeningSceneCreator extends SceneCreator implements EventHandler<MouseEvent>{

    public ScreeningSceneCreator(double width, double height) {
        super(width, height);
    }

    @Override
        Scene createScene() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        public void handle(MouseEvent event) {

        }
    

}