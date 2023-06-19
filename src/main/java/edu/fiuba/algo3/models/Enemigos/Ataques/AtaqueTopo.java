package edu.fiuba.algo3.models.Enemigos.Ataques;

import edu.fiuba.algo3.models.Jugador;
import edu.fiuba.algo3.models.Turno;


public class AtaqueTopo extends Ataque{

    
    Turno _Turno=null;

    public AtaqueTopo (Turno turno){
        _Turno=turno;
    }

    public void dañar(Jugador player){
        int danio=2;

        if(_Turno.esTurnoPar())            
            danio=danio+3;

        player.recibirAtaque(danio);        
    }
}

