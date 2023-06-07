package edu.fiuba.algo3.models.Defensas;

import edu.fiuba.algo3.models.Cordenada;

public class TorreBlanca extends Defensa{
    public TorreBlanca(Cordenada cordenadas){
        this.Costo=10;
        this.RangoAtaque=3;
        this.danio=1;
        this.nombre= "Torre Blanca";
        
        this.cordenadas=cordenadas;
        this.estado=new EnConstruccion(1);
    }
    public boolean puedoAtacar(){
        return(this.estado.puedoAtacar());
    }
    
}