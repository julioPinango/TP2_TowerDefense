package edu.fiuba.algo3.PruebasUnitarias.Pruebas;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.models.Defensas.Estados.EstadoEnConstruccion;

public class PruebaEstadoEnConstruccion {
    
    @Test
    public void TestPuedoAtacar(){
        EstadoEnConstruccion enConstruccion = new EstadoEnConstruccion(0);

        assertTrue(enConstruccion.puedoAtacar());
    }

    @Test
    public void TestNoPuedoAtacar(){
        EstadoEnConstruccion enConstruccion = new EstadoEnConstruccion(2);

        assertFalse(enConstruccion.puedoAtacar());
    }

    @Test
    public void TestEstaDestruido(){
        EstadoEnConstruccion enConstruccion = new EstadoEnConstruccion(anyInt());

        assertFalse(enConstruccion.destruido());
    }
}