package edu.fiuba.algo3.models.Parcelas;

import edu.fiuba.algo3.models.Cordenada;
import edu.fiuba.algo3.models.Defensas.Defensa;

public class Rocoso extends Parcela
{
    public Rocoso(Cordenada cordenada)
    {
       this.cordenadas=cordenada;
    }

    public boolean puedoConstruirDefensa(Defensa defensaNueva) {
        return defensaNueva.puedoConstruirEnRocoso();
     }
}