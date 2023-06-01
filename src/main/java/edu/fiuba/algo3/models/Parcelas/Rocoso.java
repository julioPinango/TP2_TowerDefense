package edu.fiuba.algo3.models.Parcelas;

import edu.fiuba.algo3.models.Defensas.Defensa;

public class Rocoso extends Parcela
{
    public boolean puedoConstruirDefensa(Defensa defensaNueva) {
        return defensaNueva.puedoConstruirEnRocoso();
     }
}