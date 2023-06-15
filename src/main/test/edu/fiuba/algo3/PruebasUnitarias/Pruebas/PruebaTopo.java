package edu.fiuba.algo3.PruebasUnitarias.Pruebas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.models.Cordenada;
import edu.fiuba.algo3.models.Jugador;
import edu.fiuba.algo3.models.Enemigos.Araña;
import edu.fiuba.algo3.models.Enemigos.Hormiga;
import edu.fiuba.algo3.models.Enemigos.Topo;
import edu.fiuba.algo3.models.Parcelas.Pasarela;

public class PruebaTopo {
    @Test
    public void TestgetCordenada(){
        Queue<Pasarela> pasarelas = new LinkedList<>();
        Pasarela pasarela1 = mock(Pasarela.class);
        Pasarela pasarela2 = mock(Pasarela.class);
        Pasarela pasarela3 = mock(Pasarela.class);

        Cordenada cordenada = mock(Cordenada.class);
        
        when(pasarela2.getCordenada()).thenReturn(cordenada);

        pasarelas.add(pasarela1);
        pasarelas.add(pasarela2);
        pasarelas.add(pasarela3);


        Topo topo = new Topo(pasarelas);
        topo.mover();
        assertEquals(topo.getCordenada(),cordenada);
    }
    @Test
    public void TestMoverRalentizado(){
        Queue<Pasarela> pasarelas = new LinkedList<>();
        Pasarela pasarela1 = mock(Pasarela.class);
        Pasarela pasarela2 = mock(Pasarela.class);
        Cordenada cordenada = mock(Cordenada.class);
        
        when(pasarela2.getCordenada()).thenReturn(cordenada);

        pasarelas.add(pasarela1);
        pasarelas.add(pasarela2);

        Topo topo = new Topo(pasarelas);
        topo.ralentizar();
        topo.mover();
        assertEquals(topo.getCordenada(),cordenada);
    }

    @Test
    public void TestOtorgaCreditos(){
        Queue<Pasarela> pasarelas = new LinkedList<>();
        Jugador jugador = mock(Jugador.class);

        when(jugador.getHormigasDestruidas()). thenReturn(0);

        Topo topo = new Topo(pasarelas);
        topo.otorgarCreditos(jugador);
        
        verify(jugador).agregarCreditos(0);
    }

    @Test
    public void TestRecibirAtaque(){
        Queue<Pasarela> pasarelas = new LinkedList<>();

        Topo topo = new Topo(pasarelas);

        assertFalse(topo.recibirAtaque(anyInt()));
    }

    @Test
    public void TestAtacarJugador(){
        Queue<Pasarela> pasarelas = new LinkedList<>();
        Jugador jugador = mock(Jugador.class);

        Topo topo = new Topo(pasarelas);
        topo.atacarJugador(jugador, 7);

        verify(jugador).recibirAtaque(anyInt());
    }
}