package edu.fiuba.algo3.view.eventos;

import edu.fiuba.algo3.models.Juego;
import edu.fiuba.algo3.view.ContenedorFinal;
import edu.fiuba.algo3.view.ContenedorPrincipal;
import edu.fiuba.algo3.view.VistaJugador;
import edu.fiuba.algo3.view.VistaMapa;
import edu.fiuba.algo3.view.VistaTurno;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonPasarTurnoHandler implements EventHandler<ActionEvent> {

   private Juego _juego;
    private VistaMapa _vistaMapa;
    private VistaJugador _vistaJugador;
    private VistaTurno _VistaTurno;
    private Stage stage;


    public BotonPasarTurnoHandler(Juego juego,VistaMapa vistaMapa,VistaJugador vistaJugador,VistaTurno vistaTurno, Stage s){      
      _juego=juego;
      _vistaMapa=vistaMapa;
      _vistaJugador=vistaJugador;
      _VistaTurno=vistaTurno;
      stage=s;
    }

    public void handle(ActionEvent mouseEvent){
    
      _juego.realizarTurno();

      _vistaMapa.mostrarMapa();

      _vistaJugador.mostrarDatos();

      _VistaTurno.mostrarTurno();
      
      if (_juego.getResultado()!="En proceso"){
        ContenedorFinal contenedorPrincipal = new ContenedorFinal(stage, _juego);
        Scene proximaVentana = new Scene(contenedorPrincipal, 1080, 720);
        stage.setScene(proximaVentana);
      }

    }


}
