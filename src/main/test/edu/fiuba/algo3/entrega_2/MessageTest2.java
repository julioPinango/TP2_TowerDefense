package edu.fiuba.algo3.entrega_2;


import edu.fiuba.algo3.modelo.Message;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import edu.fiuba.algo3.models.Jugador;

public class MessageTest2 {
    @Test
    public void messageGreeting() {
        Message message = new Message("Hola Mundo!", "Hello world!");

        assertEquals("Hello world!", message.greet("us"));
    }

    @Test
    public void messageGreetingDefaultLanguage() {
        Message message = new Message("Hola Mundo!", "Hello world!");

        assertEquals("Hola Mundo!", message.greet());
    }
   
    @Test
    public void Prueba01(){
        Jugador prueba=new Jugador();
        assertTrue(prueba.getCreditos()==100);
        assertTrue(prueba.getVida()==10);
    }
}
