package edu.fiuba.algo3.view;

import java.util.HashMap;
import java.util.Map;

import edu.fiuba.algo3.models.Juego;
import edu.fiuba.algo3.view.eventos.MouseFueraParcelasEventHandler;
import edu.fiuba.algo3.view.eventos.MouseParcelasEventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class VistaJugador extends GridPane{
    private Juego juego;

    public VistaJugador(Juego j) {
        this.juego = j;

        this.setPadding(new Insets(0));
        this.setHgap(0);
        this.setVgap(0);

        VBox cuadroInfoJugador = new VBox();
        cuadroInfoJugador.setStyle("-fx-background-color: white; -fx-border-color: black;");
        cuadroInfoJugador.setSpacing(0); 
        cuadroInfoJugador.setPadding(new Insets(0)); 

        Label estadisticasDelJugador = new Label("Tus Estadisticas:");
        estadisticasDelJugador.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
        Label labelNombre = new Label("Nombre:"+ juego.obtenerNombreDelJugador()); 
        Label labelVidaRestante = new Label("Vida:"+ juego.obtenerVidaRestanteDelJugador()); 
        Label labelCreditos = new Label("Creditos Disponibles:"+ juego.obtenerCreditosDelJugador()); 
        Label labelHormigasMuertas = new Label("Hormigas muertas:"+ juego.obtenerCantidadDeHormigasEliminadasPorElJugador()); 
        Label labelOtroDato = new Label("Otro dato: "); 
        Label labelOtroDato1 = new Label("Otro dato: "); 
        Label labelOtroDato2 = new Label("Otro dato: "); 

        cuadroInfoJugador.getChildren().addAll(estadisticasDelJugador,labelNombre,labelVidaRestante,labelCreditos,labelHormigasMuertas);

        StackPane stackPaneCuadro = new StackPane(cuadroInfoJugador);
        stackPaneCuadro.setTranslateX(0); 
        stackPaneCuadro.setTranslateY(0); 

        this.add(stackPaneCuadro, 0, 0);
    }
}

