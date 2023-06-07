package edu.fiuba.algo3.models;

import java.util.Objects;

public class Cordenada {
    private int X;
    private int Y;

    public Cordenada(int x, int y) {
        this.X = x;
        this.Y = y;
    }

    public static int calcularDistancia(int x1, int y1, int x2, int y2) {
        int distanciaX = Math.abs(x2 - x1);
        int distanciaY = Math.abs(y2 - y1);
        int distanciaManhattan = distanciaX + distanciaY;
        return distanciaManhattan;
    }

    public static boolean estaEnRango(int rango, Cordenada cordenada1, Cordenada cordenada2) {
        int x1 = cordenada1.X;
        int y1 = cordenada1.Y;
        int x2 = cordenada2.X;
        int y2 = cordenada2.Y;

        int distancia = calcularDistancia(x1, y1, x2, y2);

        return distancia <= rango;
    }

    public String getCoordenadas() {
        return "(" + this.X + "," + this.Y + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cordenada cordenada = (Cordenada) o;
        return X == cordenada.X && Y == cordenada.Y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(X, Y);
    }
}


