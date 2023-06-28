package edu.fiuba.algo3.view;

import edu.fiuba.algo3.view.eventos.BotonIniciarEventHandler;
import edu.fiuba.algo3.view.eventos.TextoEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.shape.Box;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class ContenedorInicial extends VBox {

    public ContenedorInicial(Stage stage) {
        this.setAlignment(Pos.CENTER);
        this.setSpacing(15);
        this.setPadding(new Insets(100,25,25,25));
        Image imagen = new Image("file:src/main/img/inicio.png");
        BackgroundImage imagenFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true));
        this.setBackground(new Background(imagenFondo));


        Label aviso = new Label("*El nombre debe tener por lo menos 6 caracteres");
        aviso.setFont(new Font("Trebuchet MS", 18));
        aviso.setStyle("-fx-font-weight: bold;-fx-background-color: white;");
        

        Label label = new Label("Ingrese su nombre para iniciar el juego");
        label.setFont(new Font("Trebuchet MS", 18));
        label.setStyle("-fx-font-weight: bold; -fx-background-color: white;");


        TextField nombreJugador = new TextField();
        nombreJugador.setFont(new Font("Trebuchet MS", 18));
        nombreJugador.setPrefWidth(650);


        HBox b = new HBox(nombreJugador);
        b.setAlignment(Pos.CENTER);

        Button buttonIniciar = new Button("Iniciar juego");
        buttonIniciar.setDisable(true);
        buttonIniciar.disableProperty().bind(nombreJugador.textProperty().length().lessThan(6));
        BotonIniciarEventHandler iniciarEventHandler = new BotonIniciarEventHandler(stage, nombreJugador);
        buttonIniciar.setOnAction(iniciarEventHandler);
        buttonIniciar.setFont(new Font("Trebuchet MS", 18));

        TextoEventHandler tx = new TextoEventHandler(iniciarEventHandler);
        nombreJugador.setOnKeyPressed(tx);

        this.getChildren().addAll(
                label,
                aviso,
                buttonIniciar,
                b
        );

        
    }
}

