package edu.fiuba.algo3.models.Parcelas;

import edu.fiuba.algo3.models.Defensas.Defensa;

public class Pasarela extends Parcela
{
    //private ListOF(enemigos) Listaenemigos;
    public boolean puedoConstruirDefensa(Defensa defensaNueva) {
        return defensaNueva.puedoConstruirEnPasarela();
     }
}