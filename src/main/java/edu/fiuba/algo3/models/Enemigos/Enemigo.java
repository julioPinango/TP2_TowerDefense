package edu.fiuba.algo3.models.Enemigos;


import java.util.LinkedList;
import java.util.Queue;

import edu.fiuba.algo3.models.Cordenada;
import edu.fiuba.algo3.models.Parcelas.Pasarela;

public abstract class Enemigo{

    protected int idEnemigo ;
    protected int Velocidad ;
    protected int Danio ;
    protected int Energia ;
    //protected int Creditos ;

    protected Pasarela pasarela;

    Queue<Pasarela> pasarelas = new LinkedList<>();

    public int getdanio() {
        return Danio;
    }
    public int getEnergia() {
        return Energia;
    }
    public Cordenada getCordenada() {
        return pasarelas.peek().getCordenada();
    }

    public void recibirAtaque(int danio) {
        Energia=Energia-danio;
    }

    public void mover() {
          
    }
}