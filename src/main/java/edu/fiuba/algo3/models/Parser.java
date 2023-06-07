package edu.fiuba.algo3.models;


import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import edu.fiuba.algo3.models.Parcelas.Parcela;
import edu.fiuba.algo3.models.Parcelas.Pasarela;
import edu.fiuba.algo3.models.Parcelas.Rocoso;
import edu.fiuba.algo3.models.Parcelas.Tierra;



public class Parser {

    public static List<List<String>> desglosarEnemigos(String rutaArchivo) {
        try{
            String json = new String(Files.readAllBytes(Paths.get(rutaArchivo)));
            List<List<String>> listaEnemigos = new ArrayList<>();

            JSONArray jsonArray = new JSONArray(json);

            for (int i = 0; i < jsonArray.length(); i++) {
                //Leo el json
                JSONObject turnoObj = jsonArray.getJSONObject(i);
                JSONObject enemigosObj = turnoObj.getJSONObject("enemigos");
                //Segun lo leido lo ingreso a la lista de enemigos segun corresponda.
                List<String> enemigos = new ArrayList<>();
                //enemigos.add("Turno: " + turnoObj.getInt("turno"));
                enemigos.add("Hormigas: " + enemigosObj.getInt("hormiga"));
                enemigos.add("Aranas: " + enemigosObj.getInt("arana"));
                listaEnemigos.add(enemigos);
            }
            return listaEnemigos; //Devolver el mapa como una lista de listas de cadenas
        }    
        catch (IOException e) {
            // Manejar el error si ocurre una excepción de lectura del archivo
            e.printStackTrace();
            return null; // Devolver null solo en caso de error
        }

    }




    public Map<Cordenada, Parcela> leerMapa(String rutaArchivo) {
        try{
        
        String json = new String(Files.readAllBytes(Paths.get(rutaArchivo)));
        Map<Cordenada, Parcela> mapa = new HashMap<>();  // Diccionario que almacenará el mapa
        JSONObject jsonObject = new JSONObject(json);  // Crear un objeto JSONObject a partir de la cadena JSON proporcionada
        JSONObject mapaObj = jsonObject.getJSONObject("Mapa");  // Obtener el objeto JSON que representa el mapa
            for (int i = 0; i < mapaObj.length(); i++) {  // Recorrer cada elemento en el objeto del mapa
                JSONArray filaArray = mapaObj.getJSONArray(String.valueOf(i+1));  // Obtener el array JSON que representa una fila del mapa
                for (int j = 0; j < filaArray.length(); j++) {
                    String elemento = filaArray.getString(j);  // Obtener el elemento de la fila actual como una cadena
                    Cordenada cordenada=new Cordenada(i,j);
                    Parcela nuevParcela=null;
                    switch(elemento)
                    {
                        case "Tierra":
                            nuevParcela=new Tierra(cordenada);
                            break;
                        case "Rocoso":
                            nuevParcela=new Rocoso(cordenada);
                            break;
                        case "Pasarela":
                            nuevParcela=new Pasarela(cordenada);
                            break;
                        default:
                            //Errror
                        break;
                    }
                    mapa.put(cordenada,nuevParcela);  // Agregar el elemento al hash
                }
            }
            return mapa;  // Devolver el mapa como un diccionario
        } 
        
        catch (IOException e) {
            // Manejar el error si ocurre una excepción de lectura del archivo
            e.printStackTrace();
            return null; // Devolver null solo en caso de error
        }
    }
}




