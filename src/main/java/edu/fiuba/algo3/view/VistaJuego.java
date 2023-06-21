package edu.fiuba.algo3.view;

import java.util.HashMap;
import java.util.Map;

import edu.fiuba.algo3.models.Juego;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class VistaJuego extends GridPane{
    private Juego juego;

    public VistaJuego(Juego j){
        this.juego=j;
    //}
    //public GridPane vistaMapa(){
        Image imagenTierra = new Image("file:src/main/img/tierra.jpg");
        Image imagenRocoso = new Image("file:src/main/img/rocoso.png");
        Image imagenPasarela = new Image("file:src/main/img/pasarela.png");
        Image imagenArenoso = new Image("file:src/main/img/arenoso.png");

        Map<String,Image> mapa = new HashMap<>();
        mapa.put("Tierra", imagenTierra);
        mapa.put("Rocoso", imagenRocoso);
        mapa.put("Pasarela", imagenPasarela);

        
        this.setPadding(new Insets(0));
        this.setHgap(0);
        this.setVgap(0);

        for (int fila = 0; fila < 15; fila++) {
            for (int columna = 0; columna < 15; columna++) {
                String tipo = this.juego.obtenerParcela(fila, columna);
                ImageView imageView = new ImageView(mapa.get(tipo)); 
                imageView.setFitWidth(50); 
                imageView.setFitHeight(50);                   
                this.add(imageView, fila, columna);
            }
        }
    }
}
