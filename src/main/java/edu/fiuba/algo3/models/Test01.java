package edu.fiuba.algo3.models;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import edu.fiuba.algo3.models.Cordenada;
import edu.fiuba.algo3.models.Defensas.TorrePlateada;
import edu.fiuba.algo3.models.Defensas.Estados.Estado;
import edu.fiuba.algo3.models.Enemigos.Enemigo;

public class Test01 {    
   
    public static void Prueba01() throws IOException{
        Estado estado = Mockito.mock(Estado.class);
        Cordenada cordenada = Mockito.mock(Cordenada.class);
        List<Enemigo> lista = new ArrayList<Enemigo>();
        Enemigo araña = Mockito.mock(Enemigo.class);
        
        when(araña.getCordenada()).thenReturn(cordenada);
     
        when(araña.getEnergia()).thenReturn(2);
        
        when(araña.recibirAtaque(1)).thenReturn(true);

        when(cordenada.estaEnRango(5, cordenada)).thenReturn(true);

        when(estado.puedoAtacar()).thenReturn(true);

        lista.add(0, araña);

        TorrePlateada torrePlateada = new TorrePlateada(cordenada, estado);
        torrePlateada.atacar(lista);

        verify(estado).puedoAtacar();
        verify(cordenada).estaEnRango(5,araña.getCordenada());
        verify(araña,times(1)).getCordenada();
        verify(araña).getEnergia();
        verify(araña).recibirAtaque(1);
        
    }
    }
}
