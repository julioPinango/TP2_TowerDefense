package edu.fiuba.algo3.PruebasUnitarias.Pruebas;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import edu.fiuba.algo3.models.Cordenada;
import edu.fiuba.algo3.models.Defensas.TorreBlanca;
import edu.fiuba.algo3.models.Defensas.TrampaArenosa;
import edu.fiuba.algo3.models.Defensas.Estados.Estado;
import edu.fiuba.algo3.models.Enemigos.Enemigo;

public class PruebaTrampaArenosa {
    @Test
    public void TestPuedeAtacar(){
        Cordenada cordenada = mock(Cordenada.class);
        Estado estado = mock(Estado.class);

        when(estado.puedoAtacar()). thenReturn(true);

        TrampaArenosa trampa = new TrampaArenosa(cordenada, estado);
        assertTrue(trampa.puedoAtacar());
    }

    @Test
    public void TestNoPuedeAtacar(){
        Cordenada cordenada = mock(Cordenada.class);
        Estado estado = mock(Estado.class);

        when(estado.puedoAtacar()). thenReturn(false);

        TrampaArenosa trampa = new TrampaArenosa(cordenada, estado);
        assertFalse(trampa.puedoAtacar());
    }
    
    @Test
    public void TestAtacar(){
        Cordenada cordenada = mock(Cordenada.class);
        Estado estado = mock(Estado.class);

        List<Enemigo> lista = new ArrayList<Enemigo>();
        Enemigo araña = Mockito.mock(Enemigo.class);

        lista.add(araña);

        TrampaArenosa trampa = new TrampaArenosa(cordenada, estado);
        trampa.atacar(lista);

        verify(araña).ralentizar();
        //verify()
    }
    
}
