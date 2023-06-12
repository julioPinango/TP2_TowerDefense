package edu.fiuba.algo3.models;


import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONString;

import edu.fiuba.algo3.models.Enemigos.Araña;
import edu.fiuba.algo3.models.Enemigos.Enemigo;
import edu.fiuba.algo3.models.Enemigos.EnemigoFactory;
import edu.fiuba.algo3.models.Enemigos.Hormiga;
import edu.fiuba.algo3.models.Parcelas.Parcela;
import edu.fiuba.algo3.models.Parcelas.ParcelaFactory;
import edu.fiuba.algo3.models.Parcelas.Pasarela;
import edu.fiuba.algo3.models.Parcelas.Rocoso;
import edu.fiuba.algo3.models.Parcelas.Tierra;



public class Parser {

    public static List<List<Enemigo>> desglosarEnemigos(String rutaArchivo,Queue<Pasarela> camino) {
        try{
            
            String json=new String(Files.readAllBytes(Paths.get(rutaArchivo)));
            

            List<List<Enemigo>> enemigosList = new ArrayList<>();
            JSONArray jsonArray = new JSONArray(json);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                JSONObject enemigosObj = jsonObject.getJSONObject("enemigos");
                List<Enemigo> enemigos = new ArrayList<>();
    
                for (String enemigoKey : enemigosObj.keySet()) {
                    int cantidad = enemigosObj.getInt(enemigoKey);
                    for (int j = 0; j < cantidad; j++) {
                        Enemigo enemigo=EnemigoFactory.obtenerEnemigo(camino, enemigoKey);    
                        enemigos.add(enemigo);
                    }
                }    
                enemigosList.add(enemigos);
            }
    
            return enemigosList;
        }    
        catch (IOException e) {
            // Manejar el error si ocurre una excepción de lectura del archivo
            e.printStackTrace();
            return null; // Devolver null solo en caso de error
        }

    }




    public static Map<Cordenada, Parcela> leerMapa(String rutaArchivo) {
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
                    Parcela nuevParcela=ParcelaFactory.obtenerParcela(cordenada,elemento);

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

    public static Queue<Pasarela> formarCamino(String rutaArchivo)
    {
        try{
        
            String json = new String(Files.readAllBytes(Paths.get(rutaArchivo)));
            Queue<Pasarela> camino = new LinkedList<>();  // Diccionario que almacenará el mapa
    
            JSONObject jsonObject = new JSONObject(json);  // Crear un objeto JSONObject a partir de la cadena JSON proporcionada
            JSONObject mapaObj = jsonObject.getJSONObject("Mapa");  // Obtener el objeto JSON que representa el mapa
                
            for (int i = 0; i < mapaObj.length(); i++) {  // Recorrer cada elemento en el objeto del mapa
                    
                JSONArray filaArray = mapaObj.getJSONArray(String.valueOf(i+1));  // Obtener el array JSON que representa una fila del mapa
                   
                    for (int j = 0; j < filaArray.length(); j++) {

                        String elemento = filaArray.getString(j);  // Obtener el elemento de la fila actual como una cadena
                        Cordenada cordenada=new Cordenada(i,j);
                        if(elemento.equals("Pasarela"))
                        {
                            Pasarela nuevParcela=ParcelaFactory.obtenerPasarela(cordenada);
                            camino.add(nuevParcela);
                        }

                          // Agregar el elemento al camino
                    }
                }
                return camino;  // Devolver el mapa como un diccionario
            } 
            
            catch (IOException e) {
                // Manejar el error si ocurre una excepción de lectura del archivo
                e.printStackTrace();
                return null; // Devolver null solo en caso de error
            }




    }





}




