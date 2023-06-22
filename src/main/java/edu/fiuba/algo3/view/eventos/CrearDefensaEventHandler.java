package edu.fiuba.algo3.view.eventos;

import java.util.HashMap;
import java.util.Map;

import edu.fiuba.algo3.models.Juego;
import edu.fiuba.algo3.models.Mapa;
import edu.fiuba.algo3.view.VistaJugador;
import edu.fiuba.algo3.view.VistaMapa;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class CrearDefensaEventHandler implements EventHandler<MouseEvent>{
    private VistaMapa vistaMapa;
    private Juego juego;
    private int X;
    private int Y;
    private String tipoDefensa;

    public CrearDefensaEventHandler(VistaMapa mapa,Juego j,int x,int y, String tipo){
        this.vistaMapa= mapa;
        this.juego=j;
        this.X=x;
        this.Y=y;
        this.tipoDefensa= tipo;
    }
    
    public void handle(MouseEvent mouseEvent) {
        if(this.juego.colocarDefensas(X, Y, tipoDefensa)){
            this.vistaMapa.setHabilitacionParcelas(false);
        }
    }
}
