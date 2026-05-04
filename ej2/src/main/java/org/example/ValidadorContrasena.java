package org.example;

public class ValidadorContrasena {

    public boolean esValida(String contrasena) {
        if (contrasena == null || contrasena.length() < 8) return false;
        if (contrasena.contains(" ")) return false;
        if (!contrasena.chars().anyMatch(Character::isUpperCase)) return false;
        if (!contrasena.chars().anyMatch(Character::isDigit)) return false;
        return true;
    }
}
