package edu.fiuba.algo3.models;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
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

    public static List<List<String>> desglosarEnemigos(String json) {
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

        return listaEnemigos;
    }

    public Map<Cordenada, Parcela> leerMapa(String rutaArchivo) {
        try{
        
        String json = new String(Files.readAllBytes(Paths.get(rutaArchivo)));

        Map<Cordenada, Parcela> mapa = new HashMap<>();  // Lista que almacenará el mapa
    
        JSONObject jsonObject = new JSONObject(json);  // Crear un objeto JSONObject a partir de la cadena JSON proporcionada
    
        JSONObject mapaObj = jsonObject.getJSONObject("Mapa");  // Obtener el objeto JSON que representa el mapa

        for (int i = 0; i < mapaObj.length(); i++) {  // Recorrer cada elemento en el objeto del mapa

            JSONArray filaArray = mapaObj.getJSONArray(String.valueOf(i+1));  // Obtener el array JSON que representa una fila del mapa
                
                for (int j = 0; j < filaArray.length(); j++) {
                    String elemento = filaArray.getString(j);  // Obtener el elemento de la fila actual como una cadena
                    var cordenada=new Cordenada(i,j);

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
        return mapa;  // Devolver el mapa como una lista de listas de cadenas

    } catch (IOException e) {
        // Manejar el error si ocurre una excepción de lectura del archivo
        e.printStackTrace();
        return null; // Devolver null solo en caso de error
    }
    }
/* 
    public Map<Cordenada, Parcela> leerMapaArchivoJson(String rutaArchivo) {
        try {
            // Leer el contenido del archivo JSON
            
    
            // Llamar a la función leerMapa pasando el contenido del archivo como argumento
            List<List<String>> resultado = leerMapa(contenidoJSON);
           
        
            // Hacer algo con el resultado...

            for (List<String> list : resultado) {
                
            }







             return resultado;
       
    }
    
*/






















    /*public static void parser() {

        String filePath = "ruta_del_archivo.json";

        BufferedReader reader = null;
        try {
            // Abrir el archivo
            reader = new BufferedReader(new FileReader(filePath));

            String line;
            StringBuilder fileContent = new StringBuilder();

            // Leer y almacenar cada línea del archivo
            while ((line = reader.readLine()) != null) {
                fileContent.append(line);
            }

            // Crear un objeto JSON a partir del contenido del archivo
            JSONObject jsonObject = new JSONObject(fileContent.toString());

            // Hacer algo con el objeto JSON, por ejemplo, imprimirlo
            System.out.println(jsonObject.toString());

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    // Cerrar el archivo
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void parser2(String jsoString) {
        String json = "[\n" +
                "    {\n" +
                "        \"turno\": 1,\n" +
                "        \"enemigos\": {\n" +
                "            \"hormiga\": 1,\n" +
                "            \"arana\": 0\n" +
                "        }\n" +
                "    },\n" +
                "    {\n" +
                "        \"turno\": 2,\n" +
                "        \"enemigos\": {\n" +
                "            \"hormiga\": 1,\n" +
                "            \"arana\": 1\n" +
                "        }\n" +
                "    },\n" +
                "    {\n" +
                "        \"turno\": 3,\n" +
                "        \"enemigos\": {\n" +
                "            \"hormiga\": 2,\n" +
                "            \"arana\": 1\n" +
                "        }\n" +
                "    },\n" +
                "    {\n" +
                "        \"turno\": 4,\n" +
                "        \"enemigos\": {\n" +
                "            \"hormiga\": 0,\n" +
                "            \"arana\": 1\n" +
                "        }\n" +
                "    },\n" +
                "    {\n" +
                "        \"turno\": 5,\n" +
                "        \"enemigos\": {\n" +
                "            \"hormiga\": 1,\n" +
                "            \"arana\": 1\n" +
                "        }\n" +
                "    },\n" +
                "    {\n" +
                "        \"turno\": 6,\n" +
                "        \"enemigos\": {\n" +
                "            \"hormiga\": 1,\n" +
                "            \"arana\": 2\n" +
                "        }\n" +
                "    },\n" +
                "    {\n" +
                "        \"turno\": 7,\n" +
                "        \"enemigos\": {\n" +
                "            \"hormiga\": 0,\n" +
                "            \"arana\": 1\n" +
                "        }\n" +
                "    },\n" +
                "    {\n" +
                "        \"turno\": 8,\n" +
                "        \"enemigos\": {\n" +
                "            \"hormiga\": 1,\n" +
                "            \"arana\": 0\n" +
                "        }\n" +
                "    },\n" +
                "    {\n" +
                "        \"turno\": 9,\n" +
                "        \"enemigos\": {\n" +
                "            \"hormiga\": 1,\n" +
                "            \"arana\": 0\n" +
                "        }\n" +
                "    },\n" +
                "    {\n" +
                "        \"turno\": 10,\n" +
                "        \"enemigos\": {\n" +
                "            \"hormiga\": 2,\n" +
                "            \"arana\": 0\n" +
                "        }\n" +
                "    },\n" +
                "    {\n" +
                "        \"turno\": 11,\n" +
                "        \"enemigos\": {\n" +
                "            \"hormiga\": 0,\n" +
                "            \"arana\": 1\n" +
                "        }\n" +
                "    },\n" +
                "    {\n" +
                "        \"turno\": 12,\n" +
                "        \"enemigos\": {\n" +
                "            \"hormiga\": 1,\n" +
                "            \"arana\": 2\n" +
                "        }\n" +
                "    }\n" +
                "]";

        JSONArray jsonArray = new JSONArray(json);

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject turnoObj = jsonArray.getJSONObject(i);
            int turno = turnoObj.getInt("turno");
            JSONObject enemigosObj = turnoObj.getJSONObject("enemigos");
            int hormigas = enemigosObj.getInt("hormiga");
            int aranas = enemigosObj.getInt("arana");

            System.out.println("Turno: " + turno);
            System.out.println("Hormigas: " + hormigas);
            System.out.println("Aranas: " + aranas);
            System.out.println();
        }
    }
*/
    
/* 
    public static List<List<String>> desglosarEnemigos2(String json) {
        List<List<String>> listaEnemigos = new ArrayList<>();  // Lista que almacenará los datos desglosados de los enemigos
    
        JSONArray jsonArray = new JSONArray(json);  // Crear un objeto JSONArray a partir de la cadena JSON proporcionada
    
        for (int i = 0; i < jsonArray.length(); i++) {  // Recorrer cada elemento en el JSONArray
            JSONObject turnoObj = jsonArray.getJSONObject(i);  // Obtener el objeto JSON que representa un turno de enemigos
    
            JSONObject enemigosObj = turnoObj.getJSONObject("enemigos");  // Obtener el objeto JSON que representa los enemigos en ese turno
    
            List<String> enemigos = new ArrayList<>();  // Crear una lista para almacenar los detalles del turno actual de los enemigos
    
            enemigos.add("Turno: " + turnoObj.getInt("turno"));  // Agregar el número de turno a la lista de enemigos
    
            enemigos.add("Hormigas: " + enemigosObj.getInt("hormiga"));  // Agregar el número de hormigas a la lista de enemigos
    
            enemigos.add("Aranas: " + enemigosObj.getInt("arana"));  // Agregar el número de arañas a la lista de enemigos
    
            listaEnemigos.add(enemigos);  // Agregar la lista de enemigos desglosados de un turno a la lista general de enemigos
        }
    
        return listaEnemigos;  // Devolver la lista de enemigos desglosados
    }*/

    
    /* 

     public List<List<String>> leerArchivoMapa() {
        String rutaArchivo = "ArchivosJson/mapaReducido.json"; // Reemplaza con la ruta correcta de tu archivo
        List<List<String>> mapa = new ArrayList<>();

        try {
            // Lee el contenido del archivo y almacénalo en una cadena de texto
            Path path = Paths.get(rutaArchivo);
            String contenidoJSON = new String(Files.readAllBytes(path));

            // Llama a la función leerMapa y pasa la cadena de texto con el JSON
            mapa = leerMapa(contenidoJSON);
        } catch (Exception e) {
            // Manejo de errores en caso de que ocurra alguna excepción
            e.printStackTrace();
        }

        return mapa;
    }*/

 
/* 
    public boolean leerArchivoMapa2() {
        String rutaArchivo = "ArchivosJson/mapaReducido.json"; // Reemplaza con la ruta correcta de tu archivo
        List<List<String>> mapa = new ArrayList<>();

        try {
            // Lee el contenido del archivo y almacénalo en una cadena de texto
            Path path = Paths.get(rutaArchivo);
            String contenidoJSON = new String(Files.readAllBytes(path));

            // Llama a la función leerMapa y pasa la cadena de texto con el JSON
            mapa = leerMapa(contenidoJSON);
            return true;
        } catch (Exception e) {
            // Manejo de errores en caso de que ocurra alguna excepción
            e.printStackTrace();
        }

        return false;
    }*/
}




