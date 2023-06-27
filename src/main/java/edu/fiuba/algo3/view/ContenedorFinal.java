package edu.fiuba.algo3.view;

import edu.fiuba.algo3.models.Juego;
import edu.fiuba.algo3.models.Jugador;
import edu.fiuba.algo3.view.eventos.BotonIniciarEventHandler;
import edu.fiuba.algo3.view.eventos.BotonReiniciarEventHandler;
import edu.fiuba.algo3.view.eventos.SalirDelJuegoEventHandler;
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

        Button buttonCerrarJuego = new Button("Cerrar juego");
        Button buttonReiniciar = new Button("Volver a jugar");
    
        SalirDelJuegoEventHandler iniciarEventHandler = new SalirDelJuegoEventHandler(stage);
        buttonCerrarJuego.setOnAction(iniciarEventHandler);

        BotonReiniciarEventHandler reiniciarEventHandler = new BotonReiniciarEventHandler(stage);
        buttonReiniciar.setOnAction(reiniciarEventHandler);

        this.getChildren().addAll(
                resultadoJuego,
                buttonCerrarJuego,
                buttonReiniciar
        );
    }
}
