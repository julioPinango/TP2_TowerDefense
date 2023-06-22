package edu.fiuba.algo3.view;

import java.util.HashMap;
import java.util.Map;

import edu.fiuba.algo3.models.Juego;
import edu.fiuba.algo3.view.eventos.MouseFueraParcelasEventHandler;
import edu.fiuba.algo3.view.eventos.MouseParcelasEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
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
        this.setStyle("-fx-background-color: white; -fx-border-color: black;");

        VBox cuadroInfoJugador = new VBox();
        cuadroInfoJugador.setSpacing(0); 
        cuadroInfoJugador.setPadding(new Insets(20)); 

        Label estadisticasDelJugador = new Label("Tus Estadisticas");
        estadisticasDelJugador.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
        Label labelNombre = new Label("Nombre: "+ juego.obtenerNombreDelJugador()); 
        Label labelVidaRestante = new Label("Vida: "+ juego.obtenerVidaRestanteDelJugador()); 
        Label labelCreditos = new Label("Creditos Disponibles: "+ juego.obtenerCreditosDelJugador()); 
        Label labelHormigasMuertas = new Label("Hormigas derrotadoas: "+ juego.obtenerCantidadDeHormigasEliminadasPorElJugador()); 

        cuadroInfoJugador.getChildren().addAll(estadisticasDelJugador,labelNombre,labelVidaRestante,labelCreditos,labelHormigasMuertas);

        StackPane stackPaneCuadro = new StackPane(cuadroInfoJugador);
        stackPaneCuadro.setTranslateX(0); 
        stackPaneCuadro.setTranslateY(0); 

        VBox cuadroBotones = new VBox();
        cuadroBotones.setSpacing(10);
        cuadroBotones.setPadding(new Insets(20));
        cuadroBotones.setAlignment(Pos.CENTER);

        Button botonPasarTurno = new Button("Pasar Turno");
        Button botonCrearDefensa = new Button("Crear Defensa");

        cuadroBotones.getChildren().addAll(botonPasarTurno,botonCrearDefensa);
        this.add(stackPaneCuadro, 0, 0);
        this.listaDefensas();
        this.add(cuadroBotones, 0,2);
    }

    private void listaDefensas(){

        VBox cuadroDefensas = new VBox();
        cuadroDefensas.setSpacing(10);
        cuadroDefensas.setPadding(new Insets(15));
        cuadroDefensas.setAlignment(Pos.CENTER);

        VBox TrampaArenosaBox = new VBox();
        TrampaArenosaBox.setSpacing(0);
        TrampaArenosaBox.setAlignment(Pos.CENTER);

        VBox TorreBlancaBox = new VBox();
        TorreBlancaBox.setSpacing(0);
        TorreBlancaBox.setAlignment(Pos.CENTER);

        VBox TorrePlateadaBox = new VBox();
        TorrePlateadaBox.setSpacing(0);
        TorrePlateadaBox.setAlignment(Pos.CENTER);

        Image imgArenoso = new Image("file:src/main/img/arenoso.png");
        Image imgTorreBlanca = new Image("file:src/main/img/TorreBlancaTierra.png");
        Image imgTorrePlateada = new Image("file:src/main/img/TorrePlateadaTierra.png");

        ImageView imageViewArena = new ImageView(imgArenoso);
        ImageView imageViewBlanca = new ImageView(imgTorreBlanca);
        ImageView imageViewPlateada = new ImageView(imgTorrePlateada);

        Label trampaArenosa = new Label("Trampa Arenosa");
        Label costoTrampa = new Label("25 creditos");

        Label torrreBlanca = new Label("Torre Blanca");
        Label costoBlanca = new Label("10 creditos");

        Label torrePlateada = new Label("Torre Plateada");
        Label costoPlateada = new Label("20 creditos");

        imageViewArena.setFitWidth(100);
        imageViewArena.setFitHeight(100);

        imageViewBlanca.setFitWidth(100);
        imageViewBlanca.setFitHeight(100);

        imageViewPlateada.setFitWidth(100);
        imageViewPlateada.setFitHeight(100);

        TrampaArenosaBox.getChildren().addAll(trampaArenosa,imageViewArena,costoTrampa);
        TorreBlancaBox.getChildren().addAll(torrreBlanca,imageViewBlanca,costoBlanca);
        TorrePlateadaBox.getChildren().addAll(torrePlateada,imageViewPlateada,costoPlateada);

        cuadroDefensas.getChildren().addAll(
            TrampaArenosaBox,
            TorreBlancaBox,
            TorrePlateadaBox);

        this.add(cuadroDefensas,0,1);
    }
}

