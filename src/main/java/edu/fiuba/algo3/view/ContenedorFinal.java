package edu.fiuba.algo3.view;

import edu.fiuba.algo3.models.Juego;
import edu.fiuba.algo3.models.Jugador;
import edu.fiuba.algo3.view.eventos.BotonIniciarEventHandler;
import edu.fiuba.algo3.view.eventos.OpcionesSalirDelJuegoEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ContenedorFinal extends VBox{

    public ContenedorFinal(Stage stage, Juego juego) {
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));

        Label resultadoJuego = new Label();
        if (juego.getResultado()=="Gana"){
            resultadoJuego.setText("Felicidades! Ganaste el juego");
        }else{
            resultadoJuego.setText("Perdiste el juego, será para la próxima!");
        }

        Button buttonCerrarJuego = new Button("Cerrar Juego");
    
        OpcionesSalirDelJuegoEventHandler iniciarEventHandler = new OpcionesSalirDelJuegoEventHandler(stage);
        buttonCerrarJuego.setOnAction(iniciarEventHandler);

        this.getChildren().addAll(
                resultadoJuego,
                buttonCerrarJuego
        );
    }
}
