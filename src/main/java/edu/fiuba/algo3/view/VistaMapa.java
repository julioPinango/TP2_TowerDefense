package edu.fiuba.algo3.view;

import java.util.HashMap;
import java.util.Map;

import edu.fiuba.algo3.models.Juego;
import edu.fiuba.algo3.view.eventos.CrearDefensaEventHandler;
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

public class VistaMapa extends GridPane{
    private Juego juego;
    private Boolean parcelasHabilitadas;
    private String tipoDefensa;
    private VistaJugador vistaJugador;

    public VistaMapa(Juego j) {
        this.juego = j;
        this.parcelasHabilitadas=false;
    }

    public GridPane mostrarMapa(){
        Image imagenTierra = new Image("file:src/main/img/tierra.jpg");
        Image imagenRocoso = new Image("file:src/main/img/rocoso.png");
        Image imagenPasarela = new Image("file:src/main/img/pasarela.png");
        Image imagenMarco = new Image("file:src/main/img/marco (2).png");

        Image imgArenoso = new Image("file:src/main/img/arenoso.png");
        Image imgTorreBlanca = new Image("file:src/main/img/TorreBlancaTierra.png");
        Image imgTorrePlateada = new Image("file:src/main/img/TorrePlateadaTierra.png");


        Map<String, Image> mapa = new HashMap<>();
        int tamañoMapa = juego.getTamañoParcelas();
        mapa.put("Tierra", imagenTierra);
        mapa.put("Rocoso", imagenRocoso);
        mapa.put("Pasarela", imagenPasarela);
        mapa.put("Trampa Arenosa", imgArenoso);
        mapa.put("Torre Blanca", imgTorreBlanca);
        mapa.put("Torre Plateada", imgTorrePlateada);

        this.setPadding(new Insets(0));
        this.setHgap(0);
        this.setVgap(0);

        for (int fila = 0; fila < tamañoMapa; fila++) {
            for (int columna = 0; columna < tamañoMapa; columna++) {
                ImageView imageViewMarco = new ImageView(imagenMarco);
                imageViewMarco.setFitWidth(50);
                imageViewMarco.setFitHeight(50);
                imageViewMarco.setVisible(false);

                String tipo = this.juego.obtenerParcela(fila, columna);
                Image imagen;

                CrearDefensaEventHandler crearDefensa= new CrearDefensaEventHandler(this, juego, fila, columna, tipoDefensa);
               
                if (juego.hayDefensa(fila, columna)){

                    imagen = mapa.get(juego.devolverDefensa(fila, columna));
                }else{
                    imagen=mapa.get(tipo);
                    
                }

                ImageView imageView = new ImageView(imagen);

                imageView.setFitWidth(50);
                imageView.setFitHeight(50);

                StackPane stackPane = new StackPane();
                stackPane.getChildren().addAll(imageView, imageViewMarco);
                stackPane.setDisable(!parcelasHabilitadas);
                stackPane.setOnMouseClicked(crearDefensa);
                movimientoMouse(imageViewMarco, stackPane);

                this.add(stackPane, fila, columna);
            }
        }
        return this;
    }
    private void movimientoMouse(ImageView imagen, StackPane stackPane){
        MouseParcelasEventHandler mouseEnParcelas = new MouseParcelasEventHandler(imagen);
        stackPane.setOnMouseEntered(mouseEnParcelas);

        MouseFueraParcelasEventHandler mouseFueraParcelas = new MouseFueraParcelasEventHandler(imagen);
        stackPane.setOnMouseExited(mouseFueraParcelas);
    }

    public void setHabilitacionParcelas(boolean bolean){
        this.parcelasHabilitadas=bolean;
        this.mostrarMapa();
        this.vistaJugador.mostrarDatos();
    }

    public void setVistaJugador(VistaJugador vistJugador){
        this.vistaJugador=vistJugador;
    }

    public void setTipoDefensa(String tipo){
        this.tipoDefensa=tipo;
    }
}

