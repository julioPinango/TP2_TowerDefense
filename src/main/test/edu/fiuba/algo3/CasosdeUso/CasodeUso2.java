package edu.fiuba.algo3.CasosdeUso;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import edu.fiuba.algo3.models.Cordenada;
import edu.fiuba.algo3.models.Defensas.Defensa;
import edu.fiuba.algo3.models.Defensas.TorreBlanca;
import edu.fiuba.algo3.models.Defensas.TorrePlateada;

public class CasodeUso2 {    
    @Test
    public void Prueba01(){
        Cordenada cordena=new Cordenada(2,1);
        
        Defensa torre=new TorrePlateada(cordena);
        
        torre.realizarTurno();
        assertFalse(torre.puedoAtacar());
        torre.realizarTurno();
        assertTrue(torre.puedoAtacar());
    }
    @Test
    public void Prueba02(){
        Cordenada cordena=new Cordenada(2,1);
        
        Defensa torre=new TorreBlanca(cordena);

        assertFalse(torre.puedoAtacar());

        torre.realizarTurno();
        
        assertTrue(torre.puedoAtacar());

    }
}
