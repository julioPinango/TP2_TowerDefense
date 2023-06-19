package edu.fiuba.algo3.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ContenedorInicial {
    
    public VBox ventanaInicial(Stage stage){
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(20);
        vbox.setPadding(new Insets(25));

        Label label = new Label("Ingrese su nombre para iniciar el juego");
       
        Label titulo = new Label("Tower Defense");
        titulo.setFont(new Font("Aria", 20));

        TextField nombreJugador = new TextField();

        Button buttonIniciar = new Button();
        buttonIniciar.setText("Iniciar juego");
        
        vbox.getChildren().addAll(
            titulo,
            label,
            nombreJugador,
            buttonIniciar
        );

        return vbox;
    }
}
