package org.example;

public class Tresenraya {

    private char[][] tablero;
    private char jugadorActual;
    private String error;

    public Tresenraya() {
        tablero = new char[3][3];
        jugadorActual = 'X';
        error = "";
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                tablero[i][j] = ' ';
    }

    public void colocarFicha(int fila, int col) {
        if (fila < 0 || fila > 2 || col < 0 || col > 2) {
            error = "Posición fuera del tablero";
            return;
        }

        if (tablero[fila][col] != ' ') {
            error = "Casilla ya ocupada";
            return;
        }

        tablero[fila][col] = jugadorActual;
        jugadorActual = (jugadorActual == 'X') ? 'O' : 'X';
        error = "";
    }

    public char obtenerGanador() {
        for (int i = 0; i < 3; i++) {
            if (lineaGanadora(tablero[i][0], tablero[i][1], tablero[i][2]))
                return tablero[i][0];
            if (lineaGanadora(tablero[0][i], tablero[1][i], tablero[2][i]))
                return tablero[0][i];
        }
        if (lineaGanadora(tablero[0][0], tablero[1][1], tablero[2][2]))
            return tablero[0][0];
        if (lineaGanadora(tablero[0][2], tablero[1][1], tablero[2][0]))
            return tablero[0][2];

        return ' ';
    }

    private boolean lineaGanadora(char a, char b, char c) {
        return a != ' ' && a == b && b == c;
    }

    public String getError() { return error; }
    public char[][] getTablero() { return tablero; }
    public char getJugadorActual() { return jugadorActual; }
}