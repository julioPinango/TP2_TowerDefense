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
    protected Estado estado;

    public void atacar(List<Enemigo> enemigos){

    }

    public int getCosto(){
        return Costo;
    }

    public boolean puedoConstruirEnPasarela(){
        return false;
    }

    public boolean puedoConstruirEnRocoso(){
        return false;
    }

    public boolean puedoConstruirEnTierra(Boolean estaLibre){
        return estaLibre;
    }
}
