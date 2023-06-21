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
    }
    public GridPane ventanaPrincipal() {
        Image imagenTierra = new Image("file:src/main/img/tierra.jpg");
        Image imagenRocoso = new Image("file:src/main/img/rocoso.png");
        Image imagenPasarela = new Image("file:src/main/img/pasarela.png");
        Image imagenArenoso = new Image("file:src/main/img/arenoso.png");

        Map<String,Image> mapa = new HashMap<>();
        mapa.put("Tierra", imagenTierra);
        mapa.put("Rocoso", imagenRocoso);
        mapa.put("Pasarela", imagenPasarela);

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(0));
        gridPane.setHgap(0);
        gridPane.setVgap(0);

        for (int fila = 0; fila < 15; fila++) {

            for (int columna = 0; columna < 15; columna++) {
                String tipo = this.juego.obtenerParcela(fila, columna);
                ImageView imageView = new ImageView(mapa.get(tipo)); 
                imageView.setFitWidth(50); 
                imageView.setFitHeight(50);                   
                gridPane.add(imageView, fila, columna);
            }
        }   

        return gridPane;
    }
}
