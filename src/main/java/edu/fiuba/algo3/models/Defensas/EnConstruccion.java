package edu.fiuba.algo3.models.Defensas;

public class EnConstruccion implements Estado{


    protected int contadordeTurnos=0;

    EnConstruccion(int turnos)
    {
        this.contadordeTurnos=turnos;
    }
    public boolean puedoAtacar() {
        if(this.contadordeTurnos>0)
        {
            this.contadordeTurnos=contadordeTurnos-1;
            return false;
        }

        return true;
    }
    
}
