package edu.fiuba.algo3.PruebasUnitarias.Pruebas;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import edu.fiuba.algo3.models.Cordenada;
import edu.fiuba.algo3.models.Defensas.TorreBlanca;
import edu.fiuba.algo3.models.Defensas.Estados.Estado;

public class PruebaTorreBlanca {
    @Test
    public void TestAtacar(){
        Estado estado = mock(Estado.class);
        Cordenada cordenada = mock(Cordenada.class);

        when (estado.puedoAtacar()). thenReturn(true);

        TorreBlanca torreBlanca = new TorreBlanca(cordenada, estado);

    }
}
