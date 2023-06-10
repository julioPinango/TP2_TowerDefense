package edu.fiuba.algo3.models.Defensas;

import edu.fiuba.algo3.models.Cordenada;
import edu.fiuba.algo3.models.Enemigos.Enemigo;
import edu.fiuba.algo3.models.Log;

import java.util.List;

public abstract class Defensa
{
    protected Cordenada cordenadas;

    protected int Costo;
    protected int RangoAtaque;
    protected int danio ;
    protected Estado estado;
    protected String nombre;

    public String getNombre(){
        return nombre;
    }
    public int getCosto(){
        return Costo;
    }

    public boolean puedoConstruirEnPasarela(){
        return false;
    }

    public boolean puedoConstruirEnTierra(Boolean estaLibre){
        return estaLibre;
    }
    public void atacar(List<Enemigo> enemigos){
        
        if (this.estado.puedoAtacar()) {
            this.estado=new Operativo();
            for (Enemigo enemigo : enemigos) {
                
                if(Cordenada.estaEnRango(RangoAtaque, cordenadas, enemigo.getCordenada()))
                {
                    var log = Log.obtenetInstancia();
                    
                    enemigo.recibirAtaque(danio);
                    log.imprimirAtaque(this,enemigo,enemigo.getCordenada());
                    break;
                }
            }
            
        }
    }
}
