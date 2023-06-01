package edu.fiuba.algo3.models.Defensas;

public class TorrePlateada extends Defensa
{
    public TorrePlateada()
    {
        this.Costo=20;
        this.RangoAtaque=3;
        this.danio=2;
        this.estado=new EnConstruccion(2);
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