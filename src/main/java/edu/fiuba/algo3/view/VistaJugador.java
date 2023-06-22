package edu.fiuba.algo3.view;

import java.util.HashMap;
import java.util.Map;

import edu.fiuba.algo3.models.Juego;
import edu.fiuba.algo3.view.eventos.BotonIniciarEventHandler;
import edu.fiuba.algo3.view.eventos.BotonPasarTurnoHandler;
import edu.fiuba.algo3.view.eventos.MouseFueraParcelasEventHandler;
import edu.fiuba.algo3.view.eventos.MouseParcelasEventHandler;
import edu.fiuba.algo3.view.eventos.SeleccionDefensaEventHandle;
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
    private VistaMapa vistaMapa;
    private VistaTurno _VistaTurno;

    public VistaJugador(Juego j, VistaMapa vM,VistaTurno vT) {
        this.juego = j;
        this.vistaMapa = vM;
        this._VistaTurno=vT;
    }
    
    public GridPane mostrarDatos(){

        this.getChildren().clear();


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

        cuadroInfoJugador.getChildren().addAll(estadisticasDelJugador,labelNombre,labelVidaRestante,labelCreditos);

        StackPane stackPaneCuadro = new StackPane(cuadroInfoJugador);
        stackPaneCuadro.setTranslateX(0); 
        stackPaneCuadro.setTranslateY(0); 

        VBox cuadroBotones = new VBox();
        cuadroBotones.setSpacing(10);
        cuadroBotones.setPadding(new Insets(20));
        cuadroBotones.setAlignment(Pos.CENTER);

        Button botonPasarTurno = pasarTurno();

        this.listaDefensas();

        cuadroBotones.getChildren().addAll(botonPasarTurno);
        this.add(stackPaneCuadro, 0, 0);
        this.add(cuadroBotones, 0,2);


        return this;
    }

    private Button pasarTurno() {

        Button botonPasarTurno=new Button("Pasar Turno");

        BotonPasarTurnoHandler pasarTurno = new BotonPasarTurnoHandler(juego,vistaMapa,this,_VistaTurno);
        botonPasarTurno.setOnAction(pasarTurno);

        return botonPasarTurno;
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
        Image imgTorreBlanca = new Image("file:src/main/img/TorreBlanca.png");
        Image imgTorrePlateada = new Image("file:src/main/img/TorrePlateada.png");

        Image imgArenosoDeshabilitado = new Image("file:src/main/img/arenosoDeshabilitada.png");
        Image imgTorreBlancaDeshabilitada = new Image("file:src/main/img/TorreBlancaDeshabilitada.png");
        Image imgTorrePlateadaDeshabilitada= new Image("file:src/main/img/TorrePlateadaDeshabilitada.png");

        ImageView imageViewArena = new ImageView(imgArenoso);
        ImageView imageViewBlanca = new ImageView(imgTorreBlanca);
        ImageView imageViewPlateada = new ImageView(imgTorrePlateada);

         

        if (this.juego.obtenerCreditosDelJugador()<10){
           imageViewBlanca.setImage(imgTorreBlancaDeshabilitada);
            imageViewBlanca.setDisable(true);
        }
        if(this.juego.obtenerCreditosDelJugador()<20){
            imageViewPlateada.setImage(imgTorrePlateadaDeshabilitada);
            imageViewPlateada.setDisable(true);
        }
         if (this.juego.obtenerCreditosDelJugador()<25){
            imageViewArena.setImage(imgArenosoDeshabilitado);
            imageViewArena.setDisable(true);
        }

        SeleccionDefensaEventHandle seleccionArena = new SeleccionDefensaEventHandle(this.vistaMapa, "Trampa Arenosa",this);
        SeleccionDefensaEventHandle seleccionBlanca = new SeleccionDefensaEventHandle(this.vistaMapa, "Torre Blanca", this);
        SeleccionDefensaEventHandle seleccionPlateada = new SeleccionDefensaEventHandle(this.vistaMapa, "Torre Plateada", this);

        imageViewArena.setOnMouseClicked(seleccionArena);
        imageViewBlanca.setOnMouseClicked(seleccionBlanca);
        imageViewPlateada.setOnMouseClicked(seleccionPlateada);
        
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

