package edu.fiuba.algo3.CasosdeUso;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


import edu.fiuba.algo3.models.Jugador;
import edu.fiuba.algo3.models.Defensas.TorreBlanca;
import edu.fiuba.algo3.models.Defensas.TorrePlateada;

public class CasodeUso3 {    
    @Test
    public void Prueba01(){
  
        Jugador jugador=new Jugador();

        TorrePlateada torre=new TorrePlateada();

        assertTrue(jugador.creditosSuficientes(torre));
    }
    @Test
    public void Prueba02(){
  
        Jugador jugador=new Jugador();

        TorreBlanca torre=new TorreBlanca();

        jugador.descontarCredito(100);

        assertFalse(jugador.creditosSuficientes(torre));
    }
    @Test
    public void Prueba03(){
  
        Jugador jugador=new Jugador();

        TorreBlanca torre=new TorreBlanca();

        jugador.descontarCredito(90);

        assertTrue(jugador.creditosSuficientes(torre));
    }
}
