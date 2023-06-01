package edu.fiuba.algo3.CasosdeUso;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import edu.fiuba.algo3.models.Cordenada;
import edu.fiuba.algo3.models.Juego;
import edu.fiuba.algo3.models.Jugador;
import edu.fiuba.algo3.models.Mapa;
import edu.fiuba.algo3.models.Defensas.Defensa;
import edu.fiuba.algo3.models.Enemigos.Enemigo;
import edu.fiuba.algo3.models.Enemigos.Hormiga;
import edu.fiuba.algo3.models.Parcelas.Parcela;
import edu.fiuba.algo3.models.Parcelas.Pasarela;
import edu.fiuba.algo3.models.Parcelas.Rocoso;
import edu.fiuba.algo3.models.Parcelas.Tierra;

public class CasodeUso11 {    
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

        

        List<Defensa> listaDefensas = new ArrayList<>();

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

        assertTrue(juego.resultado()=="Ganado");

    }
}
