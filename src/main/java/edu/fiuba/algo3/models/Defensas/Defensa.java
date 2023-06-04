package edu.fiuba.algo3.models.Defensas;

import edu.fiuba.algo3.models.Cordenada;
import edu.fiuba.algo3.models.Enemigos.Enemigo;

import java.util.List;

public abstract class Defensa
{
    protected Cordenada cordenadas;

    protected int Costo;
    protected int RangoAtaque;
    protected int danio ;
    protected Estado estado;

    public void atacar(List<Enemigo> enemigos){
        for (Enemigo enemigo : enemigos) {
            
            if(Cordenada.estaEnRango(RangoAtaque, cordenadas, enemigo.getCordenada()))
            {
                enemigo.recibirAtaque(danio);
                break;
            }
        }
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
    public boolean puedoAtacar(){
       return false;
    }
    public void realizarTurno(List<Enemigo> listaEnemigos2){

        if (this.estado.puedoAtacar()) {
            this.estado=new Operativo();
            this.atacar(listaEnemigos2);
        }

        return;
    }

}
