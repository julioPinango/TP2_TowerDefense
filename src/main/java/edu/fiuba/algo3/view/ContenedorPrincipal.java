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
        ImageView imageView1 = new ImageView(imagen1);

        GridPane gridPane = new GridPane();
        gridPane.setHgap(5); 
        gridPane.setVgap(5);
        gridPane.setPadding(new Insets(10)); 

        for (int fila = 0; fila < 5; fila++) {
            for (int columna = 0; columna < 5; columna++) {
                
               
                gridPane.add(imageView1, columna, fila);
            }
        }
                        

        return gridPane;
    }
}
