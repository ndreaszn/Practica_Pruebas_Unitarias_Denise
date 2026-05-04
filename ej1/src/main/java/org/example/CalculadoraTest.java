package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {

    private Calculadora calculadora;

    @BeforeEach
    void setUp() {
        calculadora = new Calculadora();
    }

    // +

    @Test
    void testSumaPositivos() {
        double a = 5.0;
        double b = 3.0;

        double resultado = calculadora.sumar(a, b);

        assertEquals(8.0, resultado);
    }

    @Test
    void testSumaNegativos() {
        double a = -4.0;
        double b = -6.0;

        double resultado = calculadora.sumar(a, b);

        assertEquals(-10.0, resultado);
    }

    // -

    @Test
    void testRestaBasica() {
        double a = 10.0;
        double b = 4.0;

        double resultado = calculadora.restar(a, b);

        assertEquals(6.0, resultado);
    }

    // x

    @Test
    void testMultiplicacionPorCero() {
        double a = 99.0;
        double b = 0.0;

        double resultado = calculadora.multiplicar(a, b);

        assertEquals(0.0, resultado);
    }

    // :

    @Test
    void testDivisionCorrecta() {
        double a = 10.0;
        double b = 2.0;

        double resultado = calculadora.dividir(a, b);

        assertEquals(5.0, resultado);
    }

    @Test
    void testDivisionEntreCero() {
        assertThrows(ArithmeticException.class, () -> calculadora.dividir(10.0, 0.0));
    }

    @Test
    void testDivisionNegativos() {
        double a = -12.0;
        double b = 4.0;

        double resultado = calculadora.dividir(a, b);

        assertEquals(-3.0, resultado);
    }
}