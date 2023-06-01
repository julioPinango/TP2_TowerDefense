package edu.fiuba.algo3.CasosdeUso;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import edu.fiuba.algo3.models.Jugador;

public class CasodeUso1 {    
    @Test
    public void Prueba01(){
        Jugador prueba=new Jugador("Juan");
        
        assertTrue(prueba.getCreditos()==100);
        assertTrue(prueba.getNombre()=="Juan");
        assertTrue(prueba.getVida()==20);
    }
}
