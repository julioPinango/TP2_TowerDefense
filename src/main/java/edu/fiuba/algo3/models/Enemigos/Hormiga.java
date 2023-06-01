package edu.fiuba.algo3.models.Enemigos;

import java.util.Queue;

import edu.fiuba.algo3.models.Parcelas.Parcela;
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
  
    public void mover() {
        pasarelas.poll();        
    }
}

