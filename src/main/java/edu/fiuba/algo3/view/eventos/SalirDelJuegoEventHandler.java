package edu.fiuba.algo3.view.eventos;

import edu.fiuba.algo3.models.Juego;
import edu.fiuba.algo3.view.ContenedorPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SalirDelJuegoEventHandler implements EventHandler<ActionEvent>{

    private Stage _Stage;

    public SalirDelJuegoEventHandler(Stage stage){
      _Stage=stage;
    }

    public void handle(ActionEvent mouseEvent){
        _Stage.close();
    }
}
