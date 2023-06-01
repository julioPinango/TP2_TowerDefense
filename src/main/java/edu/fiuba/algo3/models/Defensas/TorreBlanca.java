package edu.fiuba.algo3.models.Defensas;

public class TorreBlanca extends Defensa{
    public TorreBlanca(){
    this.Costo=10;
    this.RangoAtaque=3;
    this.danio=1;    
    this.estado=new EnConstruccion(1);
    }
    public boolean puedoAtacar(){
        return(this.estado.puedoAtacar());
    }
    public void realizarTurno(){
        if (this.puedoAtacar()) {
            this.estado=new Operativo();
            //ATACA
        }
        return;
    }
}