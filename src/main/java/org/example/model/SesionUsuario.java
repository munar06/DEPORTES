package org.example.model;

public class SesionUsuario {

    private static int usuarioId;

    private static String nombre;

    public static int getUsuarioId() {
        return usuarioId;
    }

    public static void setUsuarioId(int usuarioId) {
        SesionUsuario.usuarioId = usuarioId;
    }

    public static String getNombre() {
        return nombre;
    }

    public static void setNombre(String nombre) {
        SesionUsuario.nombre = nombre;
    }

    @Override
    public String toString() {
        return "SesionUsuario{}";
    }
}