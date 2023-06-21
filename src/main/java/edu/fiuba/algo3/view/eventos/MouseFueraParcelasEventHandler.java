package edu.fiuba.algo3.view.eventos;

import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class MouseFueraParcelasEventHandler implements EventHandler<MouseEvent>{
    private Image img;

    public MouseFueraParcelasEventHandler(Image imagen){
        this.img=imagen;
    }

     public void handle(MouseEvent mouseEvent){
        
    }
}
