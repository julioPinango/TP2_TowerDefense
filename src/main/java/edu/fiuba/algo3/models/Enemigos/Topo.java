package edu.fiuba.algo3.models.Enemigos;

import java.util.Queue;
import java.util.Random;

import edu.fiuba.algo3.models.Jugador;
import edu.fiuba.algo3.models.Log;
import edu.fiuba.algo3.models.Parcelas.Pasarela;

public class Topo extends Enemigo
{
    public Topo(Queue<Pasarela> pasarelas)
    {
        this.Energia = 0; //nunca lo atacan asi que no se que poner en energia
        this.Velocidad = 1; //va aumentando
        this.Danio = 2; //si el turno es impar causa 5
        this.nombre = "Topo";
        this.pasarelas=pasarelas;
    }

    public void mover(Jugador jugador) {
        if (pasarelas.size()<3)
        {
            atacarJugador(jugador);
        }
        else 
        {
            pasarelas.poll();         
        }       

    }
    public void sumarEnemigoMuerto(Jugador jugador) {
    }
    
}