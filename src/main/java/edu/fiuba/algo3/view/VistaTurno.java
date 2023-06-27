package edu.fiuba.algo3.view;

import java.util.HashMap;
import java.util.Map;

import edu.fiuba.algo3.models.Juego;
import edu.fiuba.algo3.view.eventos.BotonIniciarEventHandler;
import edu.fiuba.algo3.view.eventos.MouseFueraParcelasEventHandler;
import edu.fiuba.algo3.view.eventos.MouseParcelasEventHandler;
import edu.fiuba.algo3.view.eventos.OpcionesPantallaCompletaEventHandler;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VistaTurno extends GridPane{

    private Juego _juego;

    public VistaTurno(Juego juego) {     
        _juego=juego;      
    }    

    public GridPane mostrarTurno(){

        this.getChildren().clear();
        
        this.setPadding(new Insets(0));
        this.setHgap(0);
        this.setVgap(0);
        this.setStyle("-fx-background-color: DEEPSKYBLUE; -fx-border-color: black;");

        VBox cuadroTurno = new VBox();
        cuadroTurno.setSpacing(0); 
        cuadroTurno.setPadding(new Insets(10)); 

        Label turno = new Label("TURNO ACTUAL: "+_juego.getTurno());
        turno.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");        

        cuadroTurno.getChildren().addAll(turno);

        StackPane stackPaneCuadro = new StackPane(cuadroTurno);
        stackPaneCuadro.setTranslateX(0); 
        stackPaneCuadro.setTranslateY(0); 

        this.add(stackPaneCuadro, 0, 0);

        return this;
    }


}
