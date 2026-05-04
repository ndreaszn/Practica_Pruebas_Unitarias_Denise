package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidadorContrasenaTest {

    private ValidadorContrasena validador;

    @BeforeEach
    void setUp() {
        validador = new ValidadorContrasena();
    }

    @Test
    void testContrasenaValida() {
        String contrasena = "Segura12";

        boolean resultado = validador.esValida(contrasena);

        assertTrue(resultado);
    }

    @Test
    void testMenosDe8Caracteres() {
        String contrasena = "Corta1";

        boolean resultado = validador.esValida(contrasena);

        assertFalse(resultado);
    }

    @Test
    void testSinMayusculas() {
        String contrasena = "sinmayus1";

        boolean resultado = validador.esValida(contrasena);

        assertFalse(resultado);
    }

    @Test
    void testSinNumeros() {
        String contrasena = "SinNumeros";

        boolean resultado = validador.esValida(contrasena);

        assertFalse(resultado);
    }

    @Test
    void testCadenaVacia() {
        String contrasena = "";

        boolean resultado = validador.esValida(contrasena);

        assertFalse(resultado);
    }

    @Test
    void testContrasenaConEspacios() {
        String contrasena = "Segura 12";

        boolean resultado = validador.esValida(contrasena);

        assertFalse(resultado);
    }
}
