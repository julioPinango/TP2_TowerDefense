package edu.fiuba.algo3.models.Parcelas;

import edu.fiuba.algo3.models.Cordenada;
import edu.fiuba.algo3.models.Defensas.Defensa;

public class Pasarela extends Parcela
{

    public Pasarela(Cordenada cordenada)
    {
       this.cordenadas=cordenada;
    }
    //private ListOF(enemigos) Listaenemigos;
    public boolean puedoConstruirDefensa(Defensa defensaNueva) {
        return defensaNueva.puedoConstruirEnPasarela();
     }

   
}