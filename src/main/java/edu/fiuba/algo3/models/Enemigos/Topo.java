package edu.fiuba.algo3.models.Enemigos;

import java.util.Queue;
import java.util.Random;

import edu.fiuba.algo3.models.Jugador;
import edu.fiuba.algo3.models.Log;
import edu.fiuba.algo3.models.Parcelas.Pasarela;

public class Topo extends Enemigo
{
    protected int contMovimientos ;

    public Topo(Queue<Pasarela> pasarelas)
    {
        this.Energia = 1; //nunca lo atacan asi que no se que poner en energia
        this.Velocidad = 1; //va aumentando
        this.Danio = 2; //si el turno es impar causa 5
        this.nombre = "Topo";
        this.pasarelas=pasarelas;
        this.contMovimientos= 0;
    }

    public void mover(Jugador jugador) {
        if (pasarelas.size()<(this.Velocidad+1))
        {
            atacarJugador(jugador);
        }
        else 
        {
            if (this.contMovimientos==6){
                this.Velocidad=2;
            } 
            if (this.contMovimientos==11){
                this.Velocidad=3;
            }  
            for (var i =0; i<this.Velocidad; i++){
                pasarelas.poll();  
            }    
        }
        this.contMovimientos++;      

    }
    public void recibirAtaque(int danio) {
        return; //nunca lo atacan
    }
    public void atacarJugador(Jugador jugador){
        if (jugador.getTurno()%2!=0)
        {
            jugador.recibirAtaque(5);
        }
        else
        {
        jugador.recibirAtaque(Danio);
        }
        var log = Log.obtenetInstancia();
        log.imprimirDanioEnemigo(this);
        Energia=0;
    }
    
}