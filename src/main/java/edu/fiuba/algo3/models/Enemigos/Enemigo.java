package edu.fiuba.algo3.models.Enemigos;


import java.util.LinkedList;
import java.util.Queue;

import edu.fiuba.algo3.models.Cordenada;
import edu.fiuba.algo3.models.Jugador;
import edu.fiuba.algo3.models.Parcelas.Pasarela;

public abstract class Enemigo{

    protected int Velocidad ;
    protected int Danio ;
    protected int Energia ;
    protected String nombre;

    protected Queue<Pasarela> pasarelas = new LinkedList<>();

    public int getdanio() {
        return Danio;
    }
    public int getEnergia() {
        return Energia;
    }
    public String getNombre(){
        return nombre;
    }
    public Cordenada getCordenada() {
        return pasarelas.peek().getCordenada();
    }

    public void recibirAtaque(int danio) {
        Energia=Energia-danio;
    }

    public void mover(Jugador jugador) {
          
    }
    public void sumarEnemigoMuerto(Jugador jugador) {
    }

    public void otorgarCreditos(Jugador jugador)
    {}
}