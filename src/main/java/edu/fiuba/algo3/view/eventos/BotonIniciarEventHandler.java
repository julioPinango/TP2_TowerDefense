package edu.fiuba.algo3.view.eventos;

import edu.fiuba.algo3.view.ContenedorPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class BotonIniciarEventHandler implements EventHandler<ActionEvent> {
    private Stage stage;
    private TextField nombreJugador;

    public BotonIniciarEventHandler(Stage stage, TextField nombre) {
        this.stage = stage;
        this.nombreJugador = nombre;
    }

    public void handle(ActionEvent actionEvent) {
        iniciarJuego nuevoJuego = new iniciarJuego(nombreJugador.getText());

        ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(stage, nuevoJuego.devolverJuego());

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(contenedorPrincipal);
        scrollPane.setPrefSize(200, 200);
        
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
        scrollPane.setVvalue(0.5); 
        scrollPane.setHvalue(0.5); 

        Scene proximaVentana = new Scene(scrollPane, 1080, 780);

        stage.setScene(proximaVentana);
        stage.centerOnScreen();
    }
}