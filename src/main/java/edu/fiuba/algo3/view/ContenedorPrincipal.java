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
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ContenedorPrincipal extends BorderPane{
    private VistaMapa vistaMapa;

    public ContenedorPrincipal(Stage stage, Juego juego){

        this.setMenu(stage);
        this.vistaMapa=this.setMapa(juego);
        this.setOpcionesJugador(vistaMapa, juego, stage);
    }

    private void setMenu(Stage stage){
        VistaOpciones opcionesMenu = new VistaOpciones(stage);
        this.setTop(opcionesMenu);
    }

    private VistaMapa setMapa(Juego juego){
        VistaMapa vista= new VistaMapa(juego);
        this.setCenter(vista.mostrarMapa());
        return vista;
    }

    private void setOpcionesJugador(VistaMapa vista, Juego juego, Stage stage){
        VBox ContenedorMenu=new VBox();
        //Separator separator = new Separator(Orientation.HORIZONTAL);    S    
        //ContenedorMenu.getChildren().addAll(new VistaOpciones(s));
        //ContenedorMenu.getChildren().addAll(separator);
        VistaTurno turno=new VistaTurno(juego);
        VistaJugador vistaJugador = new VistaJugador(juego, vistaMapa,turno,stage);
        ContenedorMenu.getChildren().addAll(vistaJugador.mostrarDatos(),turno.mostrarTurno());
        this.setRight(ContenedorMenu);
    }
}
