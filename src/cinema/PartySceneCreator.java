package cinema;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class PartySceneCreator extends SceneCreator implements EventHandler<MouseEvent>{
   GridPane rootGridPane;

   
    public PartySceneCreator(double width, double height) {
        super(width, height);
        this.rootGridPane = new GridPane();
        this.rootGridPane.setVgap(10);
    }

    @Override
        Scene createScene() {
        
        
            
    
    
        Scene scene = new Scene(rootGridPane, width, height);
        return scene;

        }    
    
        public void handle(MouseEvent event) {

        }
    

}