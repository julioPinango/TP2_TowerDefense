package edu.fiuba.algo3;

import edu.fiuba.algo3.view.ContenedorInicial;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
    
        stage.setTitle("Tower Defense");

        //StackPane layout = new StackPane();
        ContenedorInicial contenedorInicial = new ContenedorInicial();
        VBox vbox = contenedorInicial.ventanaInicial(stage);
        Scene scene = new Scene(vbox ,500,270);
        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}