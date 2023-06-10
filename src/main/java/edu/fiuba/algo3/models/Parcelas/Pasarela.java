package edu.fiuba.algo3.models.Parcelas;

import edu.fiuba.algo3.models.Cordenada;
import edu.fiuba.algo3.models.Defensas.Defensa;
import java.util.Objects;

public class Pasarela extends Parcela
{

   public Pasarela(Cordenada cordenada)
   {
      this.cordenadas=cordenada;
      this.TipoDeParcela="Pasarela";
   }

   public boolean puedoConstruirDefensa(Defensa defensaNueva) {
      return defensaNueva.puedoConstruirEnPasarela();
   }

   //-----------------------------------------------------------------
   // OTRA FORMA MAS BASICA Y SIMPLE
   //-----------------------------------------------------------------
   /*public boolean puedoConstruirDefensa(String tipo) {
      if (tipo=="Torre blanca") {
         return false;
      }
      else if (tipo=="Torre Plateada") {
         return false;
      }
      else if (tipo=="Trampa Arena") {
         return true;
      }
   }*/

}