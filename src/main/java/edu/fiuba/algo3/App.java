package edu.fiuba.algo3;

import edu.fiuba.algo3.view.ContenedorInicial;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
    
        stage.setTitle("Tower Defense");

        //StackPane layout = new StackPane();
        ContenedorInicial contenedorInicial = new ContenedorInicial(stage);
        Scene scene = new Scene(contenedorInicial ,500,270);
        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}