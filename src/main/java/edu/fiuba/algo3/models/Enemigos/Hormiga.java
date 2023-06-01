package edu.fiuba.algo3.models.Enemigos;

import java.util.Queue;

import edu.fiuba.algo3.models.Jugador;
import edu.fiuba.algo3.models.Parcelas.Pasarela;

public class Hormiga extends Enemigo
{


    //Queue<Pasarela> pasarelas = new LinkedList<>();

    public Hormiga(Queue<Pasarela> pasarelas)
    {
        this.Energia = 1;
        this.Velocidad = 1;
        this.Danio = 1;
        //this.Creditos=1;
        this.pasarelas=pasarelas;
        
    }
  
    public void mover(Jugador jugador) {

        if (pasarelas.size()==1)
        {
            jugador.recibirAtaque(this);
            Energia=0;
            
        }
        else 
            pasarelas.poll();

    }

    public void otorgarCreditos(Jugador jugador)
    {
        if(jugador.getHormigasDestruidas()<10)
            jugador.agregarCreditos(1);
        else
        jugador.agregarCreditos(2);

    }   
    public void sumarEnemigoMuerto(Jugador jugador) {
        jugador.sumarHormigaMuerta();
    }



}

