package edu.fiuba.algo3.models.Enemigos;

import java.util.Queue;
import java.util.Random;

import edu.fiuba.algo3.models.Jugador;
import edu.fiuba.algo3.models.Log;
import edu.fiuba.algo3.models.Parcelas.Pasarela;

public class Araña extends Enemigo
{
    public Araña(Queue<Pasarela> pasarelas)
    {
        this.Energia = 2;
        this.Velocidad = 2;
        this.Danio = 2;
        this.nombre = "Araña";
        this.pasarelas=pasarelas;
    }

    public void mover(Jugador jugador) {
        if (pasarelas.size()<3)
        {
            Energia=0;
           // atacarJugador(jugador);
        }
        else if(this.ralentizado==true)
        {  
            this.ralentizado=false;  
            pasarelas.poll();
        }
        else 
        {
            pasarelas.poll();        
            pasarelas.poll(); 
        }       

    }
    public void sumarEnemigoMuerto(Jugador jugador) {
    }
    public void otorgarCreditos(Jugador jugador)
    {
        Random random = new Random();
        int numeroAleatorio = random.nextInt(11);
        

        jugador.agregarCreditos(numeroAleatorio);

    }  
}