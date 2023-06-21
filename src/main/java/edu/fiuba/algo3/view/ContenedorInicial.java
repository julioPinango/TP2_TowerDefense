package edu.fiuba.algo3.view;

import edu.fiuba.algo3.view.eventos.BotonIniciarEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ContenedorInicial extends VBox{
    
    public ContenedorInicial(Stage stage){
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));

        Label titulo = new Label("Tower Defense");
        titulo.setFont(new Font("Aria", 20));

        Label aviso = new Label("*El nombre debe tener mas de 4 caracteres");

        Label label = new Label("Ingrese su nombre para iniciar el juego");
       
        TextField nombreJugador = new TextField();

        Button buttonIniciar = new Button();
        buttonIniciar.setText("Iniciar juego");
        buttonIniciar.setDisable(true);
        buttonIniciar.disableProperty().bind(nombreJugador.textProperty().length().lessThan(5));
        BotonIniciarEventHandler iniciarEventHandler = new BotonIniciarEventHandler(stage);

        this.getChildren().addAll(
            titulo,
            label,
            nombreJugador,
            aviso,
            buttonIniciar
        );

        buttonIniciar.setOnAction(iniciarEventHandler);
    }
}
