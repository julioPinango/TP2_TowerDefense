package edu.fiuba.algo3.view.eventos;

import edu.fiuba.algo3.models.Juego;
import edu.fiuba.algo3.models.Jugador;
import edu.fiuba.algo3.models.Mapa;
import edu.fiuba.algo3.models.Parser;
import edu.fiuba.algo3.models.Turno;
import edu.fiuba.algo3.view.ContenedorInicial;
import edu.fiuba.algo3.view.ContenedorPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
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
        String nombre = nombreJugador.getText();
        Juego nuevoJuego = iniciarJuego(nombre);

        ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(stage, nuevoJuego);
        Scene proximaVentana = new Scene(contenedorPrincipal, 1080, 720);

        stage.setScene(proximaVentana);
       // stage.setFullScreen(false);
    }

    private Juego iniciarJuego(String nombreJugador) {
        //String path = "src/main/java/edu/fiuba/algo3/models/ArchivosJson/JSONdeEnemigosDefinitivo.json";
        String path = "src/main/java/edu/fiuba/algo3/models/ArchivosJson/enemigos12Hormigas.json";

        String path2 = "src/main/java/edu/fiuba/algo3/models/ArchivosJson/mapa.json";

        Parser parser = new Parser();
        Mapa mapa = new Mapa(path, path2, parser);
        Turno turno = new Turno();
        Jugador jugador = new Jugador(nombreJugador);
        Juego juego = new Juego(jugador, mapa, turno);

        return juego;
    }
}