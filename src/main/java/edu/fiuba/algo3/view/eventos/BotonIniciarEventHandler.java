package edu.fiuba.algo3.view.eventos;

import edu.fiuba.algo3.models.Juego;
import edu.fiuba.algo3.models.Jugador;
import edu.fiuba.algo3.view.ContenedorInicial;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonIniciarEventHandler implements EventHandler<ActionEvent>{
    Stage stage;
    String nombreJugador;

    public BotonIniciarEventHandler(Stage stage){
        this.stage = stage;
    }

    public void setNombreJugador(String nombre){
        this.nombreJugador = nombre;
    }

    
}
