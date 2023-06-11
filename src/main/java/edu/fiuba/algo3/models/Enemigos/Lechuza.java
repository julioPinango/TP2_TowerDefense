package edu.fiuba.algo3.models.Enemigos;

import java.util.Queue;
import java.util.Random;

import edu.fiuba.algo3.models.Jugador;
import edu.fiuba.algo3.models.Log;
import edu.fiuba.algo3.models.Parcelas.Pasarela;

public class Lechuza extends Enemigo
{
    public Lechuza(Queue<Pasarela> pasarelas)
    {
        this.Energia = 5;
        this.Velocidad = 5;
        this.Danio = 0;
        this.nombre = "Lechuza";
        this.pasarelas=pasarelas; //se mueve por cualquier parcela
    }

    public void mover(Jugador jugador) {
        if (pasarelas.size()<6)
        {
            atacarJugador(jugador);
        }
        else 
        {
            //Esto hay que corregirlo.
            pasarelas.poll();        
            pasarelas.poll(); 
            pasarelas.poll(); 
            pasarelas.poll(); 
            pasarelas.poll(); 
        }       

    }
    public void sumarEnemigoMuerto(Jugador jugador) {
    }
}