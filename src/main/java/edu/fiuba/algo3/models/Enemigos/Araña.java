package edu.fiuba.algo3.models.Enemigos;

import java.util.Queue;

import edu.fiuba.algo3.models.Parcelas.Pasarela;

public class Araña extends Enemigo
{
    public Araña(Queue<Pasarela> pasarelas)
    {
        this.Energia = 2;
        this.Velocidad = 2;
        this.Danio = 2;
        //this.Creditos=1;
        this.pasarelas=pasarelas;
    }

    public void mover() {
        pasarelas.poll();        
        pasarelas.poll();        

    }
}