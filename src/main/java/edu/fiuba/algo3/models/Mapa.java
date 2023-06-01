package edu.fiuba.algo3.models;

import edu.fiuba.algo3.models.Enemigos.Enemigo;
import edu.fiuba.algo3.models.Parcelas.Parcela;
import javafx.scene.layout.ColumnConstraints;
import edu.fiuba.algo3.models.Defensas.Defensa;
import edu.fiuba.algo3.models.Defensas.TorreBlanca;
import edu.fiuba.algo3.models.Defensas.TorrePlateada;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Mapa
{
    private List<Parcela> listaParcelas;
    private List<Defensa> listaDefensas;
    private List<Enemigo> listaEnemigos;
    private int Columna;
    private int Fila;
    private Parcela[][] Parcelas;
    private Map<String, Defensa> tiposDeTorre = new HashMap<>();

    public Mapa(int columnas, int filas){
        this.Columna=columnas;
        this.Fila=filas;
        this.Parcelas=new Parcela[filas][columnas];
        //tiposDeTorre.put("Torre Plateada", new TorrePlateada());
        tiposDeTorre.put("Torre Blanca", new TorreBlanca());
        tiposDeTorre.put("Torre Plateada", new TorrePlateada());
    }
    public void SiguienteTurno() {
        
    }

    private void colocarTipoParcela(Parcela parcela, int x, int y){
        this.Parcelas[x][y]=parcela;
    }
    boolean colocarDefensaEnEstaPosicion(int x,int y, String tipo){
        Defensa defensaNueva=this.tiposDeTorre.get(tipo);
        return (this.Parcelas[x][y].puedoConstruirDefensa(defensaNueva));
    }
}