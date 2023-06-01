package edu.fiuba.algo3.CasosdeUso;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import edu.fiuba.algo3.models.Defensas.Defensa;
import edu.fiuba.algo3.models.Defensas.TorreBlanca;
import edu.fiuba.algo3.models.Parcelas.Pasarela;
import edu.fiuba.algo3.models.Parcelas.Rocoso;
import edu.fiuba.algo3.models.Parcelas.Tierra;

public class CasodeUso4 {    
    @Test
    public void Prueba01(){        
        Tierra bloque=new Tierra();

        Defensa torre=new TorreBlanca();
        assertTrue(bloque.puedoConstruirDefensa(torre)); 
    }
    @Test
    public void Prueba02(){        
        Pasarela bloque=new Pasarela();
        Defensa torre=new TorreBlanca();
        assertFalse(bloque.puedoConstruirDefensa(torre)); 
    }
    @Test
    public void Prueba03(){        
        Rocoso bloque=new Rocoso();
        Defensa torre=new TorreBlanca();
        assertFalse(bloque.puedoConstruirDefensa(torre)); 
    }
}
