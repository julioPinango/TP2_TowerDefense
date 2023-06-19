package edu.fiuba.algo3.models.Enemigos;

import java.util.Queue;
import java.util.Random;

import edu.fiuba.algo3.models.Jugador;
import edu.fiuba.algo3.models.Log;
import edu.fiuba.algo3.models.Enemigos.Ataques.Ataque;
import edu.fiuba.algo3.models.Enemigos.Movimientos.Movimiento;
import edu.fiuba.algo3.models.Enemigos.Movimientos.MovimientoHormigaRalentizado;
import edu.fiuba.algo3.models.Enemigos.Movimientos.MovimientoTopo;
import edu.fiuba.algo3.models.Enemigos.Movimientos.MovimientoTopoRalentizado;
import edu.fiuba.algo3.models.Parcelas.Pasarela;

public class Topo extends Enemigo
{
    protected int contMovimientos ;

    public Topo(Queue<Pasarela> pasarelas,Movimiento mov)
    {
        this.Energia = 1; //nunca lo atacan asi que no se que poner en energia
        this.Velocidad = 1; //va aumentando
        this.nombre = "Topo";
        this.pasarelas=pasarelas;
        this.contMovimientos= 0;
        this.movimiento=mov;
    }

    public void mover() {
        if (pasarelas.size()<(this.Velocidad+1))
        {
            Energia=0;
           // atacarJugador(jugador);
        }
        else 
        {
            this.pasarelas=movimiento.mover(pasarelas,contMovimientos);
            this.movimiento=new MovimientoTopo();  
        }
        this.contMovimientos++;      

    }
    public boolean recibirAtaque(int danio) {
        return false; //nunca lo atacan
    }
 

    public void ralentizar() {
        this.movimiento=new MovimientoTopoRalentizado();
    }    
}