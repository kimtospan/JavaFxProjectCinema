package cinema;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class PartySceneCreator extends SceneCreator implements EventHandler<MouseEvent>{
   GridPane rootGridPane;
   Button backButton;

   
    public PartySceneCreator(double width, double height) {
        super(width, height);
        this.rootGridPane = new GridPane();
        this.rootGridPane.setVgap(10);
        this.rootGridPane.setHgap(10);
        this.backButton = new Button("Back");

        this.rootGridPane.add(backButton, 0, 1);

        backButton.setOnMouseClicked(this);
    }

    @Override
        Scene createScene() {
        
        
            
    
    
        Scene scene = new Scene(rootGridPane, width, height);
        return scene;

        }    
    
        public void handle(MouseEvent event) {
            if (event.getSource() == backButton) {
                App.primaryStage.setScene(App.mainScene);
                App.primaryStage.setTitle("Cinema Management System");
            }

        }
    

}