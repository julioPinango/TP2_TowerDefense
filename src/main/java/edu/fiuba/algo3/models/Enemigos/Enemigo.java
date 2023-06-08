package edu.fiuba.algo3.models.Enemigos;


import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

import edu.fiuba.algo3.models.Cordenada;
import edu.fiuba.algo3.models.Jugador;
import edu.fiuba.algo3.models.Log;
import edu.fiuba.algo3.models.Parcelas.Pasarela;

public abstract class Enemigo{

    protected int Velocidad ;
    protected int Danio ;
    protected int Energia ;
    protected String nombre;

    protected Queue<Pasarela> pasarelas = new LinkedList<>();

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Enemigo otra = (Enemigo) obj;
        return Objects.equals(Velocidad, otra.Velocidad) &&
               Objects.equals(Danio, otra.Danio)&&
               Objects.equals(Energia, otra.Energia)&&
               Objects.equals(nombre, otra.nombre);
    }

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

    public void atacarJugador(Jugador jugador){
        jugador.recibirAtaque(Danio);
        var log = Log.obtenetInstancia();
        log.imprimirDanioEnemigo(this);
        Energia=0;
    }
}