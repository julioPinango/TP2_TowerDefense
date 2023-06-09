package edu.fiuba.algo3.models.Defensas;

public class EnConstruccion implements Estado{


    protected int tiempoDeConstruccion=0;

    EnConstruccion(int turnos)
    {
        this.tiempoDeConstruccion=turnos;
    }
    public boolean puedoAtacar() {
        if(this.tiempoDeConstruccion>0)
        {
            this.tiempoDeConstruccion=tiempoDeConstruccion-1;
            return false;
        }

        return true;
    }
    
}
