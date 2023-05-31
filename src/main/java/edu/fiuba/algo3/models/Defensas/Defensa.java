package edu.fiuba.algo3.models.Defensas;

import edu.fiuba.algo3.models.Cordenada;
import edu.fiuba.algo3.models.Enemigos.Enemigo;

import java.util.List;

public abstract class Defensa
{
    protected Cordenada cordenada;

    protected int Costo;
    protected int TiempoConstruccion;
    protected int RangoAtaque;
    protected int danio ;

    public void atacar(List<Enemigo> enemigos){

    }

    public int getCosto(){
        return Costo;
    }
}
