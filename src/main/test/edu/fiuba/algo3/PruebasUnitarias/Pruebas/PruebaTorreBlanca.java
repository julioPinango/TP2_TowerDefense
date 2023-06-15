package edu.fiuba.algo3.PruebasUnitarias.Pruebas;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import edu.fiuba.algo3.models.Cordenada;
import edu.fiuba.algo3.models.Defensas.TorreBlanca;
import edu.fiuba.algo3.models.Defensas.Estados.Estado;
import edu.fiuba.algo3.models.Enemigos.Enemigo;

public class PruebaTorreBlanca {
    @Test
    public void TestPuedoAtacar(){
        Estado estado = mock(Estado.class);
        Cordenada cordenada = mock(Cordenada.class);

        when (estado.puedoAtacar()). thenReturn(true);

        TorreBlanca torreBlanca = new TorreBlanca(cordenada, estado);
        assertTrue(torreBlanca.puedoAtacar());
    }

    @Test
    public void TestAtacar(){
        Estado estado = Mockito.mock(Estado.class);
        Cordenada cordenada = Mockito.mock(Cordenada.class);
        List<Enemigo> lista = Mockito.mock(ArrayList.class);
        Enemigo araña = Mockito.mock(Enemigo.class);
        

        // Configuración del mock para el método getCordenada()
        Mockito.when(araña.getCordenada()).thenReturn(new Cordenada(0, 0));

        // Configuración del mock para el método getEnergia()
        Mockito.when(araña.getEnergia()).thenReturn(Mockito.anyInt());

        // Configuración del mock para el método recibirAtaque()
        Mockito.when(araña.recibirAtaque(1)).thenReturn(false);

        // Configuración del mock para el método estaEnRango()
        when(cordenada.estaEnRango(3, araña.getCordenada())).thenReturn(true);

        // Configuración del mock para el método puedoAtacar()
        Mockito.when(estado.puedoAtacar()).thenReturn(true);

        // Añadir el objeto araña a la lista
        Mockito.doNothing().when(lista).add(0, araña);

        TorreBlanca torreBlanca = new TorreBlanca(cordenada, estado);
    }
}
