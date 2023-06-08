package edu.fiuba.algo3.CasosdeUso;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.*;

import edu.fiuba.algo3.models.Cordenada;
import edu.fiuba.algo3.models.Juego;
import edu.fiuba.algo3.models.Jugador;
import edu.fiuba.algo3.models.Mapa;
import edu.fiuba.algo3.models.Defensas.Defensa;
import edu.fiuba.algo3.models.Defensas.TorrePlateada;
import edu.fiuba.algo3.models.Enemigos.Enemigo;
import edu.fiuba.algo3.models.Enemigos.Hormiga;
import edu.fiuba.algo3.models.Parcelas.Parcela;
import edu.fiuba.algo3.models.Parcelas.Pasarela;
import edu.fiuba.algo3.models.Parcelas.Rocoso;
import edu.fiuba.algo3.models.Parcelas.Tierra;

public class CasodeUso10 { 
    
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

        Defensa torre=new TorrePlateada(cordenada1);

        List<Defensa> listaDefensas = new ArrayList<>();

        listaDefensas.add(torre);
        
        Queue<Pasarela> pasarelas = new LinkedList<>();
        
        pasarelas.add(Pasarela1);
        pasarelas.add(Pasarela2);
        pasarelas.add(Pasarela3);

        Enemigo hormiga=new Hormiga(pasarelas);

        List<List<Enemigo>> listaEnemigos = new ArrayList<>();

        List<Enemigo> listaEnemigos2 = new ArrayList<>();

        listaEnemigos2.add(hormiga);

        listaEnemigos.add(listaEnemigos2);

        List<Enemigo> listaEnemigos3=new ArrayList<>();

        listaEnemigos.add(listaEnemigos3);
        listaEnemigos.add(listaEnemigos3);
        listaEnemigos.add(listaEnemigos3);
        listaEnemigos.add(listaEnemigos3);



        Mapa mapa=new Mapa(parcelas,listaEnemigos);

        mapa.colocarDefensaEnEstaPosicion(0,0,"Torre Blanca");

        Jugador jugador=new Jugador("Juan Cruz");

        Juego juego=new Juego(jugador,mapa);

        juego.jugar(jugador);

        assertTrue(juego.resultado()=="Gana");
    }
}
