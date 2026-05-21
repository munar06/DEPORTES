package org.example;

public class Entrenamiento {

    private int id;
    private String tipo;
    private int duracion;
    private String fecha;
    private int usuarioId;

    public Entrenamiento(String tipo, int duracion, String fecha, int usuarioId) {
        this.tipo = tipo;
        this.duracion = duracion;
        this.fecha = fecha;
        this.usuarioId = usuarioId;
    }

    public String getTipo() { return tipo; }
    public int getDuracion() { return duracion; }
    public String getFecha() { return fecha; }
    public int getUsuarioId() { return usuarioId; }
}