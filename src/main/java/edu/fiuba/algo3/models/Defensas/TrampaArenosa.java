package edu.fiuba.algo3.models.Defensas;

import java.util.List;

import edu.fiuba.algo3.models.Cordenada;
import edu.fiuba.algo3.models.Enemigos.Enemigo;

public class TrampaArenosa extends Defensa{
    public TrampaArenosa(Cordenada cordenadas){
        this.Costo=25;
        this.RangoAtaque=1;
        this.danio=0;
        this.nombre= "Trampa Arenosa";
        
        this.cordenadas=cordenadas;
        this.estado=new EnConstruccion(1); //cambiar
    }
    public boolean puedoAtacar(){
        return(this.estado.puedoAtacar());
    }

    public void atacar(List<Enemigo> enemigos){ //implementar un atacar distinto
        for (Enemigo enemigo : enemigos) {
            
            
        }
    }
    
    public boolean puedoConstruirEnPasarela(){
        return true;
    }

    public boolean puedoConstruirEnTierra(Boolean estaLibre){
        return false;
    }
    
}