package edu.fiuba.algo3.view;

import java.util.HashMap;
import java.util.Map;

import edu.fiuba.algo3.models.Juego;
import edu.fiuba.algo3.view.eventos.BotonIniciarEventHandler;
import edu.fiuba.algo3.view.eventos.MouseFueraParcelasEventHandler;
import edu.fiuba.algo3.view.eventos.MouseParcelasEventHandler;
import edu.fiuba.algo3.view.eventos.OpcionesPantallaCompletaEventHandler;
import edu.fiuba.algo3.view.eventos.OpcionesSalirDelJuegoEventHandler;
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

public class VistaOpciones extends GridPane{

    private Juego juego;

    public VistaOpciones(Stage stage) {     

        // Submenú
        MenuButton subMenuButton = new MenuButton("Opciones");
        MenuItem silenciarMusicaItem = new MenuItem("Silenciar música");
        MenuItem silenciarEfectosItem = new MenuItem("Silenciar efectos");
        MenuItem pantallaCompletaItem = new MenuItem("Pantalla completa");
        MenuItem SalirItem = new MenuItem("Salir del Juego");       

        subMenuButton.setPadding(new Insets(0,50,0,50)); 
        
        // Agregar los botones de submenú al submenú
        subMenuButton.getItems().addAll(silenciarMusicaItem, silenciarEfectosItem, pantallaCompletaItem,SalirItem);
       
        this.add(subMenuButton, 0, 0);

        OpcionesPantallaCompletaEventHandler clickPantallaCompleta = new OpcionesPantallaCompletaEventHandler(stage);
        pantallaCompletaItem.setOnAction(clickPantallaCompleta);

        OpcionesSalirDelJuegoEventHandler clickSalir = new OpcionesSalirDelJuegoEventHandler(stage);
        SalirItem.setOnAction(clickSalir);
    }    
}
