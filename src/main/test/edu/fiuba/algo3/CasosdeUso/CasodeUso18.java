package edu.fiuba.algo3.CasosdeUso;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import edu.fiuba.algo3.models.Juego;
import edu.fiuba.algo3.models.Jugador;
import edu.fiuba.algo3.models.Mapa;
import edu.fiuba.algo3.models.Parser;

public class CasodeUso18 {    
    @Test
    public void Prueba01(){
        
        String path="src/main/java/edu/fiuba/algo3/models/ArchivosJson/mapaReducido.json";

        var mapaParseado=Parser.leerMapa(path);

        var camino=Parser.formarCamino(path);          

        String path2="src/main/java/edu/fiuba/algo3/models/ArchivosJson/enemigosSinEnemigos.json";

        var enemigosJson=Parser.desglosarEnemigos(path2,camino);

        var mapa=new Mapa(mapaParseado,enemigosJson);

        var Jugador=new Jugador("Julianna");

        var juego=new Juego(Jugador, mapa);

        juego.jugar(Jugador);

        assertEquals("Gana",juego.resultado());
    }
}
