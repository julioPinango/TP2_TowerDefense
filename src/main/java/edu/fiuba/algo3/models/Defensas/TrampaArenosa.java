package edu.fiuba.algo3.models.Defensas;

import edu.fiuba.algo3.models.Cordenada;

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
    
}