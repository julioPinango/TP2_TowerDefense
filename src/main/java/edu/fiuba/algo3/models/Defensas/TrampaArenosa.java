package edu.fiuba.algo3.models.Defensas;

import java.util.List;

import edu.fiuba.algo3.models.Cordenada;
import edu.fiuba.algo3.models.Defensas.Estados.Estado;
import edu.fiuba.algo3.models.Defensas.Estados.EstadoDestruido;
import edu.fiuba.algo3.models.Defensas.Estados.EstadoEnConstruccion;
import edu.fiuba.algo3.models.Enemigos.Enemigo;

public class TrampaArenosa extends Defensa{

    private int contadorTurnos;

    public TrampaArenosa(Cordenada cordenadas,Estado estado){
        this.Costo=25;
        this.RangoAtaque=0;
        this.danio=0;
        this.nombre= "Trampa Arenosa";
        this.contadorTurnos=3;
        this.cordenadas=cordenadas;
        this.estado=estado;
    }
    public boolean puedoAtacar(){
        return(this.estado.puedoAtacar());
    }

    public void atacar(List<Enemigo> enemigos){ //implementar un atacar distinto

        for (Enemigo enemigo : enemigos) {
            enemigo.ralentizar();            
        }

        contadorTurnos=contadorTurnos-1;

        if(contadorTurnos==0)
            destruir();
    }
    
    public boolean puedoConstruirEnPasarela(){
        return true;
    }

    public boolean puedoConstruirEnTierra(Boolean estaLibre){
        return false;
    }
    
}