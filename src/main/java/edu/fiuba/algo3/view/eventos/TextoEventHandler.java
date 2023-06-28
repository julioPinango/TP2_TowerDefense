package edu.fiuba.algo3.view.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class TextoEventHandler implements EventHandler<KeyEvent> {

    EventHandler evento;

    public TextoEventHandler(EventHandler a){
        this.evento = a;

    }


    @Override
    public void handle(KeyEvent keyEvent) {
        if(keyEvent.getCode() == KeyCode.ENTER){
            evento.handle(new ActionEvent());
        }
    }
}

