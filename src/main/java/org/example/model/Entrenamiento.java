package org.example.model;

public class Entrenamiento {

    private int id;
    private String tipo;
    private int duracion;
    private String fecha;
    private int usuarioId;

    public Entrenamiento() {
    }

    public Entrenamiento(
            String tipo,
            int duracion,
            String fecha,
            int usuarioId
    ) {

        this.tipo = tipo;
        this.duracion = duracion;
        this.fecha = fecha;
        this.usuarioId = usuarioId;
    }

    public int getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public int getDuracion() {
        return duracion;
    }

    public String getFecha() {
        return fecha;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    @Override
    public String toString() {
        return "Entrenamiento{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                ", duracion=" + duracion +
                ", fecha='" + fecha + '\'' +
                ", usuarioId=" + usuarioId +
                '}';
    }
}