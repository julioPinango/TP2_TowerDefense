package edu.fiuba.algo3.CasosdeUso;
import edu.fiuba.algo3.models.Defensas.TorreBlanca;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.*;

import edu.fiuba.algo3.models.Cordenada;
import edu.fiuba.algo3.models.Juego;
import edu.fiuba.algo3.models.Jugador;
import edu.fiuba.algo3.models.Mapa;
import edu.fiuba.algo3.models.Defensas.Defensa;
import edu.fiuba.algo3.models.Defensas.TorrePlateada;
import edu.fiuba.algo3.models.Enemigos.Araña;
import edu.fiuba.algo3.models.Enemigos.Enemigo;
import edu.fiuba.algo3.models.Enemigos.Hormiga;
import edu.fiuba.algo3.models.Parcelas.Parcela;
import edu.fiuba.algo3.models.Parcelas.Pasarela;
import edu.fiuba.algo3.models.Parcelas.Rocoso;
import edu.fiuba.algo3.models.Parcelas.Tierra;

public class CasodeUso8 {    
    @Test
    public void Prueba01(){
        
                
    
        Cordenada cordenada1 = new Cordenada(0, 0);
        Cordenada cordenada2 = new Cordenada(0, 1);
        Cordenada cordenada3 = new Cordenada(0, 2);

        Cordenada cordenada4 = new Cordenada(1, 0);
        Cordenada cordenada5 = new Cordenada(1, 1);
        Cordenada cordenada6 = new Cordenada(1, 2);

        Cordenada cordenada7 = new Cordenada(2, 0);
        Cordenada cordenada8 = new Cordenada(2, 1);
        Cordenada cordenada9 = new Cordenada(2, 2);
        
        var tierra1=new Tierra(cordenada1);
        var tierra2=new Tierra(cordenada4);
        var tierra3=new Tierra(cordenada7);
        
        var Roca1=new Rocoso(cordenada3);
        var Roca2=new Rocoso(cordenada6);
        var Roca3=new Rocoso(cordenada9);

        var Pasarela1=new Pasarela(cordenada2);
        var Pasarela2=new Pasarela(cordenada5);
        var Pasarela3=new Pasarela(cordenada8);


        Map<Cordenada, Parcela> parcelas = new HashMap<>();

        parcelas.put(cordenada1, tierra1);
        parcelas.put(cordenada4, tierra2);
        parcelas.put(cordenada7, tierra3);
        parcelas.put(cordenada2, Pasarela1);
        parcelas.put(cordenada5, Pasarela2);
        parcelas.put(cordenada8, Pasarela3);
        parcelas.put(cordenada3, Roca1);
        parcelas.put(cordenada6, Roca2);
        parcelas.put(cordenada9, Roca3);


        /*
        Parcela[][] parcelas = new Parcela[3][3];

        parcelas[0][0]=tierra1;
        parcelas[0][1]=tierra2;
        parcelas[0][2]=tierra3;

        parcelas[1][0]=Roca1;
        parcelas[1][1]=Roca2;
        parcelas[1][2]=Roca3;

        parcelas[2][0]=Pasarela1;
        parcelas[2][1]=Pasarela2;
        parcelas[2][2]=Pasarela3;

         */

        Defensa torre=new TorrePlateada(cordenada1);

        List<Defensa> listaDefensas = new ArrayList<>();

        listaDefensas.add(torre);
        
        Queue<Pasarela> pasarelas = new LinkedList<>();

        pasarelas.add(Pasarela1);
        pasarelas.add(Pasarela2);
        pasarelas.add(Pasarela3);

        Enemigo hormiga=new Hormiga(pasarelas);

        List<Enemigo> listaEnemigos = new ArrayList<>();

        listaEnemigos.add(hormiga);



        Mapa mapa=new Mapa(parcelas,listaDefensas,listaEnemigos);

        Jugador jugador=new Jugador("Juan Cruz");

        Juego juego=new Juego(jugador,mapa);

        juego.jugar(jugador);

        assertTrue(jugador.getCreditos()==101);

    }
    @Test
    public void Prueba02(){
        
                
    
        Cordenada cordenada1 = new Cordenada(0, 0);
        Cordenada cordenada2 = new Cordenada(0, 1);
        Cordenada cordenada3 = new Cordenada(0, 2);

        Cordenada cordenada4 = new Cordenada(1, 0);
        Cordenada cordenada5 = new Cordenada(1, 1);
        Cordenada cordenada6 = new Cordenada(1, 2);

        Cordenada cordenada7 = new Cordenada(2, 0);
        Cordenada cordenada8 = new Cordenada(2, 1);
        Cordenada cordenada9 = new Cordenada(2, 2);
        
        var tierra1=new Tierra(cordenada1);
        var tierra2=new Tierra(cordenada4);
        var tierra3=new Tierra(cordenada7);
        
        var Roca1=new Rocoso(cordenada3);
        var Roca2=new Rocoso(cordenada6);
        var Roca3=new Rocoso(cordenada9);

        var Pasarela1=new Pasarela(cordenada2);
        var Pasarela2=new Pasarela(cordenada5);
        var Pasarela3=new Pasarela(cordenada8);

        Map<Cordenada, Parcela> parcelas = new HashMap<>();

        parcelas.put(cordenada1, tierra1);
        parcelas.put(cordenada4, tierra2);
        parcelas.put(cordenada7, tierra3);
        parcelas.put(cordenada2, Pasarela1);
        parcelas.put(cordenada5, Pasarela2);
        parcelas.put(cordenada8, Pasarela3);
        parcelas.put(cordenada3, Roca1);
        parcelas.put(cordenada6, Roca2);
        parcelas.put(cordenada9, Roca3);

        Defensa torre=new TorrePlateada(cordenada1);

        List<Defensa> listaDefensas = new ArrayList<>();

        listaDefensas.add(torre);
        
        Queue<Pasarela> pasarelas = new LinkedList<>();
        
        pasarelas.add(Pasarela1);
        pasarelas.add(Pasarela2);
        pasarelas.add(Pasarela3);

        Enemigo Hormiga1=new  Hormiga(pasarelas);
        Enemigo Hormiga2=new  Hormiga(pasarelas);
        Enemigo Hormiga3=new  Hormiga(pasarelas);
        Enemigo Hormiga4=new  Hormiga(pasarelas);
        Enemigo Hormiga5=new  Hormiga(pasarelas);
        Enemigo Hormiga6=new  Hormiga(pasarelas);
        Enemigo Hormiga7=new  Hormiga(pasarelas);
        Enemigo Hormiga8=new  Hormiga(pasarelas);
        Enemigo Hormiga9=new  Hormiga(pasarelas);
        Enemigo Hormiga10=new Hormiga(pasarelas);
        Enemigo Hormiga11=new Hormiga(pasarelas);


        List<Enemigo> listaEnemigos = new ArrayList<>();

        listaEnemigos.add(Hormiga1);
        listaEnemigos.add(Hormiga2);
        listaEnemigos.add(Hormiga3);
        listaEnemigos.add(Hormiga4);
        listaEnemigos.add(Hormiga5);
        listaEnemigos.add(Hormiga6);
        listaEnemigos.add(Hormiga7);
        listaEnemigos.add(Hormiga8);
        listaEnemigos.add(Hormiga9);
        listaEnemigos.add(Hormiga10);
        listaEnemigos.add(Hormiga11);  



        Mapa mapa=new Mapa(parcelas,listaDefensas,listaEnemigos);

        Jugador jugador=new Jugador("Juan Cruz");

        Juego juego=new Juego(jugador,mapa);

        juego.jugar(jugador);

        assertTrue(jugador.getCreditos()==112);

    }

    @Test
    public void Prueba03(){
        
                
    
        Cordenada cordenada1 = new Cordenada(0, 0);
        Cordenada cordenada2 = new Cordenada(0, 1);
        Cordenada cordenada3 = new Cordenada(0, 2);

        Cordenada cordenada4 = new Cordenada(1, 0);
        Cordenada cordenada5 = new Cordenada(1, 1);
        Cordenada cordenada6 = new Cordenada(1, 2);

        Cordenada cordenada7 = new Cordenada(2, 0);
        Cordenada cordenada8 = new Cordenada(2, 1);
        Cordenada cordenada9 = new Cordenada(2, 2);
        
        var tierra1=new Tierra(cordenada1);
        var tierra2=new Tierra(cordenada4);
        var tierra3=new Tierra(cordenada7);
        
        var Roca1=new Rocoso(cordenada3);
        var Roca2=new Rocoso(cordenada6);
        var Roca3=new Rocoso(cordenada9);

        var Pasarela1=new Pasarela(cordenada2);
        var Pasarela2=new Pasarela(cordenada5);
        var Pasarela3=new Pasarela(cordenada8);

        Map<Cordenada, Parcela> parcelas = new HashMap<>();

        parcelas.put(cordenada1, tierra1);
        parcelas.put(cordenada4, tierra2);
        parcelas.put(cordenada7, tierra3);
        parcelas.put(cordenada2, Pasarela1);
        parcelas.put(cordenada5, Pasarela2);
        parcelas.put(cordenada8, Pasarela3);
        parcelas.put(cordenada3, Roca1);
        parcelas.put(cordenada6, Roca2);
        parcelas.put(cordenada9, Roca3);

        Defensa torre=new TorrePlateada(cordenada1);

        List<Defensa> listaDefensas = new ArrayList<>();

        listaDefensas.add(torre);
        
        Queue<Pasarela> pasarelas = new LinkedList<>();
        
        pasarelas.add(Pasarela1);
        pasarelas.add(Pasarela2);
        pasarelas.add(Pasarela3);

        Enemigo araña=new Araña(pasarelas);

        List<Enemigo> listaEnemigos = new ArrayList<>();

        listaEnemigos.add(araña);

        Mapa mapa=new Mapa(parcelas,listaDefensas,listaEnemigos);

        Jugador jugador=new Jugador("Juan Cruz");

        Juego juego=new Juego(jugador,mapa);

        juego.jugar(jugador);

        assertTrue(jugador.getCreditos()>=100);

    }
}
