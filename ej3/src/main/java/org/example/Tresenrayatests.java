package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Tresenrayatests {

    private Tresenraya juego;

    @BeforeEach
    void setUp() {
        juego = new Tresenraya();
    }

    @Test
    void testColocarFichaCorrectamente() {
        juego.colocarFicha(0, 0);

        char[][] tablero = juego.getTablero();

        assertEquals('X', tablero[0][0]);
    }

    @Test
    void testColocarFichaFueraDelTablero() {
        juego.colocarFicha(3, 0);

        String error = juego.getError();

        assertEquals("Posición fuera del tablero", error);
    }

    @Test
    void testColocarFichaEnCasillaOcupada() {
        juego.colocarFicha(1, 1);
        juego.colocarFicha(1, 1);

        String error = juego.getError();

        assertEquals("Casilla ya ocupada", error);
    }


    @Test
    void testGanarPorFila() {
        juego.colocarFicha(0, 0); // X
        juego.colocarFicha(1, 0); // O
        juego.colocarFicha(0, 1); // X
        juego.colocarFicha(1, 1); // O
        juego.colocarFicha(0, 2); // X

        char ganador = juego.obtenerGanador();

        assertEquals('X', ganador);
    }

    @Test
    void testGanarPorColumna() {
        juego.colocarFicha(0, 0); // X
        juego.colocarFicha(0, 1); // O
        juego.colocarFicha(1, 0); // X
        juego.colocarFicha(0, 2); // O
        juego.colocarFicha(2, 0); // X

        char ganador = juego.obtenerGanador();

        assertEquals('X', ganador);
    }

    @Test
    void testGanarPorDiagonalPrincipal() {
        juego.colocarFicha(0, 0); // X
        juego.colocarFicha(0, 1); // O
        juego.colocarFicha(1, 1); // X
        juego.colocarFicha(0, 2); // O
        juego.colocarFicha(2, 2); // X

        char ganador = juego.obtenerGanador();

        assertEquals('X', ganador);
    }

    @Test
    void testGanarPorDiagonalSecundaria() {
        juego.colocarFicha(0, 2); // X
        juego.colocarFicha(0, 0); // O
        juego.colocarFicha(1, 1); // X
        juego.colocarFicha(0, 1); // O
        juego.colocarFicha(2, 0); // X 

        char ganador = juego.obtenerGanador();

        assertEquals('X', ganador);
    }

    @Test
    void testPartidaSinGanador() {
        juego.colocarFicha(0, 0); // X
        juego.colocarFicha(0, 1); // O
        juego.colocarFicha(0, 2); // X
        juego.colocarFicha(1, 2); // O
        juego.colocarFicha(1, 0); // X
        juego.colocarFicha(2, 0); // O
        juego.colocarFicha(1, 1); // X
        juego.colocarFicha(2, 2); // O
        juego.colocarFicha(2, 1); // X

        char ganador = juego.obtenerGanador();

        assertEquals(' ', ganador);
    }
}
