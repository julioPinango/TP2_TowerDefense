package edu.fiuba.algo3.CasosdeUso;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import edu.fiuba.algo3.models.Cordenada;
import edu.fiuba.algo3.models.Defensas.Defensa;
import edu.fiuba.algo3.models.Defensas.TorreBlanca;
import edu.fiuba.algo3.models.Defensas.TorrePlateada;
import edu.fiuba.algo3.models.Enemigos.Enemigo;

public class CasodeUso2 {    
    @Test
    public void Prueba01(){
        Cordenada cordena=new Cordenada(2,1);
        
        Defensa torre=new TorrePlateada(cordena);
        List<Enemigo> listaEnemigos = new ArrayList<>();

        torre.realizarTurno(listaEnemigos);
        assertFalse(torre.puedoAtacar());
        torre.realizarTurno(listaEnemigos);

        assertTrue(torre.puedoAtacar());
    }
    @Test
    public void Prueba02(){
        Cordenada cordena=new Cordenada(2,1);
        List<Enemigo> listaEnemigos = new ArrayList<>();        
        Defensa torre=new TorreBlanca(cordena);

        assertFalse(torre.puedoAtacar());
        torre.realizarTurno(listaEnemigos);
        
        assertTrue(torre.puedoAtacar());

    }
}
