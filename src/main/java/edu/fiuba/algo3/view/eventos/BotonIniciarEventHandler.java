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

    public void handle(ActionEvent actionEvent){
        
        Juego nuevoJuego = this.iniciarJuego(this.nombreJugador);

        ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(this.stage, nuevoJuego);
        Scene proximaVentana = new Scene(contenedorPrincipal, 1080, 720);
        
        stage.setScene(proximaVentana);
        stage.setFullScreen(true);
    }

    private Juego iniciarJuego(String nombre){
        String path="src/main/java/edu/fiuba/algo3/models/ArchivosJson/Enemigos.json";
        String path2="src/main/java/edu/fiuba/algo3/models/ArchivosJson/mapa.json";
        
        Parser parser = new Parser();
        Mapa mapa=new Mapa(path,path2,parser);
        Turno turno=new Turno();
        Jugador jugador=new Jugador(nombre);   
        Juego juego=new Juego(jugador,mapa,turno);

        return juego;
    }
}
