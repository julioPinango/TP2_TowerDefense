package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Message;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        

        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido por favor ingrese su nombre (6 Caracteres minimo): ");
        
        String nombre = scanner.nextLine();

        System.out.println("El nombre ingresado es:"+nombre);
App.main(args);
    }
}
