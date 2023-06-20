package edu.fiuba.algo3.view;

import java.io.File;

import edu.fiuba.algo3.models.Juego;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ContenedorPrincipal{
    private Stage stage;
    private Juego juego;

    public ContenedorPrincipal(Stage s, Juego j){
        this.stage=s;
        this.juego=j;
    }
    public GridPane ventanaPrincipal() {
        Image imagen1 = new Image("file:src/main/img/tierra.jpg");
        Image imagen2 = new Image("file:src/main/img/rocoso.png");
        GridPane gridPane = new GridPane();
        gridPane.setHgap(0); 
        gridPane.setVgap(0); 
        gridPane.setPadding(new Insets(0));

        for (int fila = 0; fila < 15; fila++) {
            for (int columna = 0; columna < 15; columna++) {
                if (columna%2==0&&fila%2==0) {
                    ImageView imageView = new ImageView(imagen2); 
                    imageView.setFitWidth(30); 
                    imageView.setFitHeight(30); 
                    gridPane.add(imageView, columna, fila);
                }
                else{                    
                    ImageView imageView2 = new ImageView(imagen1); 
                    imageView2.setFitWidth(30); 
                    imageView2.setFitHeight(30); 
                    gridPane.add(imageView2, columna, fila);
                }
            }
        }   

        return gridPane;
    }
}
