package edu.fiuba.algo3.view.eventos;

import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.effect.Effect;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class MouseFueraParcelasEventHandler implements EventHandler<MouseEvent>{
    private ImageView img;

    public MouseFueraParcelasEventHandler(ImageView imagen){
        this.img=imagen;
    }

     public void handle(MouseEvent mouseEvent){
         this.img.setVisible(false);
    }
}
