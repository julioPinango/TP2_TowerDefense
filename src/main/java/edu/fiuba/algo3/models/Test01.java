package edu.fiuba.algo3.models;


import edu.fiuba.algo3.models.Cordenada;
import edu.fiuba.algo3.models.Juego;
import edu.fiuba.algo3.models.Jugador;
import edu.fiuba.algo3.models.Mapa;
import edu.fiuba.algo3.models.Parser;
import edu.fiuba.algo3.models.Enemigos.Araña;
import edu.fiuba.algo3.models.Enemigos.Enemigo;
import edu.fiuba.algo3.models.Enemigos.Hormiga;
import edu.fiuba.algo3.models.Enemigos.Lechuza;
import edu.fiuba.algo3.models.Parcelas.Parcela;
import edu.fiuba.algo3.models.Parcelas.Pasarela;
import edu.fiuba.algo3.models.Parcelas.Rocoso;
import edu.fiuba.algo3.models.Parcelas.Tierra;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Test01 {    
   
    public static void Prueba01() throws IOException{
   
             String path="src/main/java/edu/fiuba/algo3/models/ArchivosJson/mapa.json";
        String path2="src/main/java/edu/fiuba/algo3/models/ArchivosJson/enemigosReducido.json";
        Parser parser = new Parser();
        Mapa mapa=new Mapa(path2,path,parser);

       //var camino=parser.formarCamino(path);

       var enemigosJson=parser.desglosarEnemigos(path2);
       
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

        var hormigaaa=enemigos.get(0).get(0);
        var hormigaEE=enemigosJson.get(0).get(0);


    }
}
