package edu.fiuba.algo3.CasosdeUso;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import edu.fiuba.algo3.models.Jugador;
import edu.fiuba.algo3.models.Parser;
import edu.fiuba.algo3.models.Enemigos.Araña;
import edu.fiuba.algo3.models.Enemigos.Enemigo;
import edu.fiuba.algo3.models.Enemigos.Hormiga;

public class CasodeUso15 {    
    @Test
    public void Prueba01(){
      
        Parser parser= new Parser();

        String path="src/main/java/edu/fiuba/algo3/models/ArchivosJson/mapa.json";

       var camino=parser.formarCamino(path);

       String path2="src/main/java/edu/fiuba/algo3/models/ArchivosJson/enemigosReducido.json";

       var enemigosJson=parser.desglosarEnemigos(path2,camino);

        // Crear la lista de listas
        List<List<Enemigo>> enemigos = new ArrayList<>();


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


        assertEquals(enemigos,enemigosJson);




    }
}
