package edu.fiuba.algo3.models.Enemigos;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import edu.fiuba.algo3.models.Cordenada;
import edu.fiuba.algo3.models.Jugador;
import edu.fiuba.algo3.models.Log;
import edu.fiuba.algo3.models.Parcelas.Pasarela;

public class Lechuza extends Enemigo
{
    private Cordenada coordenadaActual;
    private Cordenada coordenadaObjetivo;

    public Lechuza(Queue<Pasarela> pasarelas)
    {
        this.Energia = 5;
        this.Velocidad = 5;
        this.Danio = 0;
        this.nombre = "Lechuza";
        this.pasarelas=pasarelas; //se mueve por cualquier parcela

        List<Pasarela> listaPasarelas = new ArrayList<>(pasarelas);
        int tamaño = listaPasarelas.size();
        
        coordenadaActual=listaPasarelas.get(0).getCordenada();

        coordenadaObjetivo = listaPasarelas.get(tamaño - 1).getCordenada();
    }

    public void mover(Jugador jugador) {
        if (pasarelas.size()<6)
        {
            Energia=0;
            //atacarJugador(jugador);//Como el danio es 0 no tiene efecto en la vida del jugador.
        }
        else 
        {
            volar();           
        }
    }
    public void sumarEnemigoMuerto(Jugador jugador) {
    }

    public Cordenada getCordenada() {
        return coordenadaActual;
    }

    public void volar() {

        Integer mitadEnergia = 2;
        if (this.getEnergia() > mitadEnergia) {
            // La lechuza tiene más del 50% de vida, vuela en forma de L hacia la meta
            int catetoX = Math.abs(coordenadaObjetivo.getX() - coordenadaActual.getX());
            int catetoY = Math.abs(coordenadaObjetivo.getY() - coordenadaActual.getY());

            // Ajuste proporcional para moverse en forma de L
            if (catetoX > catetoY) {
                catetoY += catetoX - catetoY;
            } else {
                catetoX += catetoY - catetoX;
            }

                // Mover en forma de L hacia la meta
                int movimientosX = 2;
                int movimientosY = 3;

                int newCoordenadaX = coordenadaActual.getX();
                int newCoordenadaY = coordenadaActual.getY();

                if (movimientosX > 0) {
                if (coordenadaActual.getX() < coordenadaObjetivo.getX()) {
                    newCoordenadaX=(coordenadaActual.getX() + movimientosX);
                } else {
                    newCoordenadaX=(coordenadaActual.getX() - movimientosX);
                }
                }

                if (movimientosY > 0) {
                    if (coordenadaActual.getY() < coordenadaObjetivo.getY()) {
                        newCoordenadaY=(coordenadaActual.getY() + movimientosY);
                    } else {
                        newCoordenadaY=(coordenadaActual.getY() - movimientosY);
                    }
                }

                coordenadaActual=new Cordenada(newCoordenadaX, newCoordenadaY);
        } 
        else 
        {
            // La lechuza tiene menos del 50% de vida, vuela en línea recta directamente a la meta
            int distanciaX = coordenadaObjetivo.getX() - coordenadaActual.getX();
            int distanciaY = coordenadaObjetivo.getY() - coordenadaActual.getY();
            int hipotenusa = (int) Math.sqrt(distanciaX * distanciaX + distanciaY * distanciaY);

            // Mover en línea recta hacia la meta
            int pasoX = distanciaX / hipotenusa;
            int pasoY = distanciaY / hipotenusa;

            int newCoordenadaX = coordenadaActual.getX() + pasoX;
            int newCoordenadaY = coordenadaActual.getY() + pasoY;

            coordenadaActual=new Cordenada(newCoordenadaX, newCoordenadaY);
        }


    }
  

}
