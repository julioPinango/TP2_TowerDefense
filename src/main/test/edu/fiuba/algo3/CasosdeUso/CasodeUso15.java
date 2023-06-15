package edu.fiuba.algo3.CasosdeUso;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import edu.fiuba.algo3.models.Mapa;
import edu.fiuba.algo3.models.Parser;
import edu.fiuba.algo3.models.Enemigos.Araña;
import edu.fiuba.algo3.models.Enemigos.Enemigo;
import edu.fiuba.algo3.models.Enemigos.Hormiga;

public class CasodeUso15 {    
    @Test
    public void Prueba01(){

        String path="src/main/java/edu/fiuba/algo3/models/ArchivosJson/mapa.json";
        String path2="src/main/java/edu/fiuba/algo3/models/ArchivosJson/enemigosReducido.json";
        Parser parser = new Parser();
        Mapa mapa=new Mapa(path2,path,parser);
       
        // Crear la lista de listas
        List<List<Enemigo>> enemigos = new ArrayList<>();

        var camino=mapa.inicializarCaminoDeEnemigos(parser.formarCamino(path));

        var Hormiga=new Hormiga(camino);
        var Araña=new Araña(camino);

        // Crear el primer turno y añade a la lista de enemigos
        List<Enemigo> primerTurno = new ArrayList<>();        
        primerTurno.add(Hormiga);
        enemigos.add(primerTurno);

        // Crear el primer turno y añade a la lista de enemigos
        List<Enemigo> segundoTurno = new ArrayList<>();
        segundoTurno.add(Hormiga);
        segundoTurno.add(Araña);
        enemigos.add(segundoTurno);

        // Crear la tercera lista y añadirla a la lista de listas
        List<Enemigo> tercerTurno = new ArrayList<>();
        tercerTurno.add(Hormiga);
        tercerTurno.add(Hormiga);
        tercerTurno.add(Araña);
        enemigos.add(tercerTurno);

        assertEquals(enemigos.get(0).get(0),Hormiga);

        assertEquals(enemigos.get(2).get(2),Araña);

    }
}