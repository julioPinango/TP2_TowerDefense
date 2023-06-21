package edu.fiuba.algo3.view.eventos;

import edu.fiuba.algo3.models.Juego;
import edu.fiuba.algo3.view.ContenedorPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class MouseParcelasEventHandler implements EventHandler<MouseEvent>{
    private Image img;

    public MouseParcelasEventHandler(Image imagen){
        this.img=imagen;
    }
     public void handle(MouseEvent mouseEvent){
        
    }
}