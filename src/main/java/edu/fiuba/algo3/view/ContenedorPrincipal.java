package edu.fiuba.algo3.view;



import java.util.HashMap;
import java.util.Map;

import edu.fiuba.algo3.models.Juego;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ContenedorPrincipal extends GridPane{
    private Stage stage;
    private Juego juego;

    public ContenedorPrincipal(Stage s, Juego j){
        this.stage=s;
        this.juego=j;

        VistaMapa vistaMapa= new VistaMapa(j);
        this.add(vistaMapa.mostrarMapa(),0,0);

        VBox ContenedorMenu=new VBox();
        Separator separator = new Separator(Orientation.HORIZONTAL);        
        ContenedorMenu.getChildren().addAll(new VistaOpciones(s));
        ContenedorMenu.getChildren().addAll(separator);
        VistaTurno turno=new VistaTurno(j);
        VistaJugador vistaJugador = new VistaJugador(j, vistaMapa,turno);
        ContenedorMenu.getChildren().addAll(vistaJugador.mostrarDatos(),turno.mostrarTurno());

        this.add(ContenedorMenu,1,0);
    }
}
