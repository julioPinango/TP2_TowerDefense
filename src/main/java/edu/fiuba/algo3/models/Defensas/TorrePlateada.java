package edu.fiuba.algo3.models.Defensas;

import edu.fiuba.algo3.models.Cordenada;

public class TorrePlateada extends Defensa
{
    public TorrePlateada(Cordenada cordenadas)
    {
        this.Costo=20;
        this.RangoAtaque=3;
        this.danio=2;
        this.nombre= "Torre Plateada";
        
        this.cordenadas=cordenadas;
        this.estado=new EnConstruccion(2);
    }
    public boolean puedoAtacar(){
        return(this.estado.puedoAtacar());
    }
    
}