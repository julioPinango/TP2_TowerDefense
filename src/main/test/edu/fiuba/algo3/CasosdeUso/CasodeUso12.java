package edu.fiuba.algo3.CasosdeUso;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.*;

import edu.fiuba.algo3.models.Cordenada;
import edu.fiuba.algo3.models.Juego;
import edu.fiuba.algo3.models.Jugador;
import edu.fiuba.algo3.models.Mapa;
import edu.fiuba.algo3.models.Parser;
import edu.fiuba.algo3.models.Turno;
import edu.fiuba.algo3.models.Defensas.Defensa;
import edu.fiuba.algo3.models.Enemigos.Araña;
import edu.fiuba.algo3.models.Enemigos.Enemigo;
import edu.fiuba.algo3.models.Parcelas.Parcela;
import edu.fiuba.algo3.models.Parcelas.Pasarela;
import edu.fiuba.algo3.models.Parcelas.Rocoso;
import edu.fiuba.algo3.models.Parcelas.Tierra;
public class CasodeUso12 {    
    @Test
    public void Prueba01(){
        
        String path="src/main/java/edu/fiuba/algo3/models/ArchivosJson/enemigos.json";
        String path2="src/main/java/edu/fiuba/algo3/models/ArchivosJson/mapa.json";
        Parser parser = new Parser();
        Mapa mapa=new Mapa(path,path2,parser);
        Turno turno=new Turno();
                Jugador jugador=new Jugador("Juan Cruz");
  

        Juego juego=new Juego(jugador,mapa,turno);

        do{
            juego.realizarTurno();              
        }
        while (juego.getResultado()=="En proceso") ; 

        assertTrue(juego.getResultado()=="Pierde"); 
    }
} 
 