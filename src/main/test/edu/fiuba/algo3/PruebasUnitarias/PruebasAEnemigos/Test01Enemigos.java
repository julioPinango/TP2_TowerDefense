package edu.fiuba.algo3.PruebasUnitarias.PruebasAEnemigos;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import edu.fiuba.algo3.models.Cordenada;
import edu.fiuba.algo3.models.Juego;
import edu.fiuba.algo3.models.Jugador;
import edu.fiuba.algo3.models.Mapa;
import edu.fiuba.algo3.models.Parser;
import edu.fiuba.algo3.models.Enemigos.Lechuza;
import edu.fiuba.algo3.models.Parcelas.Parcela;
import edu.fiuba.algo3.models.Parcelas.Pasarela;
import edu.fiuba.algo3.models.Parcelas.Rocoso;
import edu.fiuba.algo3.models.Parcelas.Tierra;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Test01Enemigos {    
    @Test
    public void Prueba01() throws IOException{
   
        //Pruebo que la lechuza se mueve en forma de L

            String path="src/main/java/edu/fiuba/algo3/models/ArchivosJson/mapa.json";    
    
            var camino=Parser.formarCamino(path);          
    
            Lechuza lechuza=new Lechuza(camino);

            lechuza.volar();


            assertEquals(lechuza.getCordenada().getX(),2);
            assertEquals(lechuza.getCordenada().getY(),4);


    }
@Test
    public void Prueba02() throws IOException{
   
        //Pruebo que la lechuza elimina una torre   

            String path="src/main/java/edu/fiuba/algo3/models/ArchivosJson/mapa.json";
    
            var mapaParseado=Parser.leerMapa(path);
    
            var camino=Parser.formarCamino(path);          
    
            String path2="src/main/java/edu/fiuba/algo3/models/ArchivosJson/enemigosLechuza.json";
    
            var enemigosJson=Parser.desglosarEnemigos(path2,camino);
    
            var mapa=new Mapa(mapaParseado,enemigosJson);
    
            var Jugador=new Jugador("Julianna");
    
            var juego=new Juego(Jugador, mapa);

            juego.colocarDefensas(0, 1, "Torre Plateada");


            juego.realizarTurno(Jugador);         
            juego.realizarTurno(Jugador);         
            juego.realizarTurno(Jugador);         
            juego.realizarTurno(Jugador);         
            juego.realizarTurno(Jugador);         
            juego.realizarTurno(Jugador);         
    
            assertEquals(0,mapa.defensasDisponibles());
    }
    @Test
        public void Prueba03() throws IOException{
   
        //Pruebo que la lechuza no hace daño   

            String path="src/main/java/edu/fiuba/algo3/models/ArchivosJson/mapa.json";
    
            var mapaParseado=Parser.leerMapa(path);
    
            var camino=Parser.formarCamino(path);          
    
            String path2="src/main/java/edu/fiuba/algo3/models/ArchivosJson/enemigosLechuza.json";
    
            var enemigosJson=Parser.desglosarEnemigos(path2,camino);
    
            var mapa=new Mapa(mapaParseado,enemigosJson);
    
            var Jugador=new Jugador("Julianna");
    
            var juego=new Juego(Jugador, mapa);

            juego.colocarDefensas(0, 1, "Torre Plateada");


            juego.realizarTurno(Jugador);         
            juego.realizarTurno(Jugador);         
            juego.realizarTurno(Jugador);         
            juego.realizarTurno(Jugador);         
            juego.realizarTurno(Jugador);         
            juego.realizarTurno(Jugador);         
    
            assertEquals(20,Jugador.getVida());
    }
    @Test
    public void Prueba04() throws IOException{
   
        //Pruebo que la lechuza no da creditos  

            String path="src/main/java/edu/fiuba/algo3/models/ArchivosJson/mapa.json";
    
            var mapaParseado=Parser.leerMapa(path);
    
            var camino=Parser.formarCamino(path);          
    
            String path2="src/main/java/edu/fiuba/algo3/models/ArchivosJson/enemigosLechuza.json";
    
            var enemigosJson=Parser.desglosarEnemigos(path2,camino);
    
            var mapa=new Mapa(mapaParseado,enemigosJson);
    
            var Jugador=new Jugador("Julianna");
    
            var juego=new Juego(Jugador, mapa);

            juego.colocarDefensas(0, 1, "Torre Plateada");


            juego.realizarTurno(Jugador);         
            juego.realizarTurno(Jugador);         
            juego.realizarTurno(Jugador);         
            juego.realizarTurno(Jugador);         
            juego.realizarTurno(Jugador);         
            juego.realizarTurno(Jugador);         
    
            assertEquals(100,Jugador.getCreditos());
    }
}
