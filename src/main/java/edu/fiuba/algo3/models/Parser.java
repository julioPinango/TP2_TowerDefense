package edu.fiuba.algo3.models;



import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;



public class Parser {

    public static void parser() {

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

    public static List<List<String>> desglosarEnemigos(String json) {
        List<List<String>> listaEnemigos = new ArrayList<>();

        JSONArray jsonArray = new JSONArray(json);

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject turnoObj = jsonArray.getJSONObject(i);
            JSONObject enemigosObj = turnoObj.getJSONObject("enemigos");

            List<String> enemigos = new ArrayList<>();
            enemigos.add("Turno: " + turnoObj.getInt("turno"));
            enemigos.add("Hormigas: " + enemigosObj.getInt("hormiga"));
            enemigos.add("Aranas: " + enemigosObj.getInt("arana"));

            listaEnemigos.add(enemigos);
        }

        return listaEnemigos;
    }
}



