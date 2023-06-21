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

public class VistaJuego extends GridPane{
    private Juego juego;

    public VistaJuego(Juego j) {
        this.juego = j;

        Image imagenTierra = new Image("file:src/main/img/tierra.jpg");
        Image imagenRocoso = new Image("file:src/main/img/rocoso.png");
        Image imagenPasarela = new Image("file:src/main/img/pasarela.png");
        Image imagenArenoso = new Image("file:src/main/img/arenoso.png");
        Image imagenMarco = new Image("file:src/main/img/marco (2).png");

        Map<String, Image> mapa = new HashMap<>();
        int tamañoMapa = juego.getTamañoParcelas();
        mapa.put("Tierra", imagenTierra);
        mapa.put("Rocoso", imagenRocoso);
        mapa.put("Pasarela", imagenPasarela);

        this.setPadding(new Insets(0));
        this.setHgap(0);
        this.setVgap(0);

        VBox cuadroInfoJugador = new VBox(); // VBox para organizar los Labels verticalmente
        cuadroInfoJugador.setStyle("-fx-background-color: white; -fx-border-color: black;"); // Personalizar el estilo del cuadro
        cuadroInfoJugador.setSpacing(0); // Espacio entre los Labels
        cuadroInfoJugador.setPadding(new Insets(0)); // Espacio interno del cuadro

        Label labelHormigasMuertas = new Label("Hormigas muertas: "); // Label para las hormigas muertas
        Label labelOtroDato = new Label("Otro dato: "); // Label para otro dato

        cuadroInfoJugador.getChildren().addAll(labelHormigasMuertas, labelOtroDato); // Agregar los Labels al VBox

        StackPane stackPaneCuadro = new StackPane(cuadroInfoJugador);
        stackPaneCuadro.setTranslateX(-20); // Desplazamiento horizontal
        stackPaneCuadro.setTranslateY(40); // Desplazamiento vertical

        AnchorPane anchorPaneCuadro = new AnchorPane(stackPaneCuadro);
        AnchorPane.setTopAnchor(anchorPaneCuadro, 0.0);
        AnchorPane.setRightAnchor(anchorPaneCuadro, 0.0);

        for (int fila = 0; fila < tamañoMapa; fila++) {
            for (int columna = 0; columna < tamañoMapa; columna++) {
                ImageView imageViewMarco = new ImageView(imagenMarco);
                imageViewMarco.setFitWidth(50);
                imageViewMarco.setFitHeight(50);
                imageViewMarco.setVisible(false);

                String tipo = this.juego.obtenerParcela(fila, columna);
                ImageView imageView = new ImageView(mapa.get(tipo));
                imageView.setFitWidth(50);
                imageView.setFitHeight(50);

                StackPane stackPane = new StackPane();
                stackPane.getChildren().addAll(imageView, imageViewMarco);

                movimientoMouse(imageViewMarco, stackPane);

                this.add(stackPane, fila, columna);
            }
        }

        this.add(anchorPaneCuadro, tamañoMapa, 0);
    }

    private void movimientoMouse(ImageView imagen, StackPane stackPane){
        MouseParcelasEventHandler mouseEnParcelas = new MouseParcelasEventHandler(imagen);
        stackPane.setOnMouseEntered(mouseEnParcelas);

        MouseFueraParcelasEventHandler mouseFueraParcelas = new MouseFueraParcelasEventHandler(imagen);
        stackPane.setOnMouseExited(mouseFueraParcelas);
    }
}

