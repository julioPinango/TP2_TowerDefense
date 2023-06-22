package edu.fiuba.algo3.view.eventos;

import edu.fiuba.algo3.models.Juego;
import edu.fiuba.algo3.view.VistaJugador;
import edu.fiuba.algo3.view.VistaMapa;
import edu.fiuba.algo3.view.VistaTurno;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class BotonPasarTurnoHandler implements EventHandler<ActionEvent> {

   private Juego _juego;
    private VistaMapa _vistaMapa;
    private VistaJugador _vistaJugador;
    private VistaTurno _VistaTurno;


    public BotonPasarTurnoHandler(Juego juego,VistaMapa vistaMapa,VistaJugador vistaJugador,VistaTurno vistaTurno){      
      _juego=juego;
      _vistaMapa=vistaMapa;
      _vistaJugador=vistaJugador;
      _VistaTurno=vistaTurno;

    }

    public void handle(ActionEvent mouseEvent){
    
      _juego.realizarTurno();

      _vistaMapa.mostrarMapa();

      _vistaJugador.mostrarDatos();

      _VistaTurno.mostrarTurno();


    }

}
