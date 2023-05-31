package edu.fiuba.algo3.CasosdeUso;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import edu.fiuba.algo3.models.Juego;
import edu.fiuba.algo3.models.Jugador;
import edu.fiuba.algo3.models.Enemigos.Araña;
import edu.fiuba.algo3.models.Enemigos.Enemigo;
import edu.fiuba.algo3.models.Enemigos.Hormiga;
import edu.fiuba.algo3.models.Parcelas.PasarelaFinal;

public class CasodeUso12 {    
    @Test
    public void Prueba01(){

        PasarelaFinal pasarela=new PasarelaFinal();

        Jugador jugador=new Jugador();

        Enemigo araña=new Araña(pasarela);
        
        for(int i=0;i<9;i++)
        {
            jugador.recibirAtaque(araña);
        }
        //Esta en 2 de vida.

        Enemigo hormiga=new Hormiga(pasarela);
        
        jugador.recibirAtaque(hormiga);
        jugador.recibirAtaque(hormiga);

        //Esta en 0 de vida, perdio el juego.

        assertTrue(Juego.jugadorDerrotado(jugador)); 
    }
}
