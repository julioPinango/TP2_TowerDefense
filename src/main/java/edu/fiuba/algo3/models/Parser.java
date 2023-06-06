package edu.fiuba.algo3.models;



import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
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
}


