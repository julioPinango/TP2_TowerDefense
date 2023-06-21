package edu.fiuba.algo3.view;



import java.util.HashMap;
import java.util.Map;

import edu.fiuba.algo3.models.Juego;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class ContenedorPrincipal extends GridPane{
    private Stage stage;
    private Juego juego;

    public ContenedorPrincipal(Stage s, Juego j){
        this.stage=s;
        this.juego=j;
        this.add(new VistaJuego(j),0,0);
    }
}
