package org.example.model;

public class Usuario {

    private int id;
    private String nombre;
    private String correo;
    private String password;
    private int edad;
    private double altura;
    private double pesoActual;

    public Usuario() {
    }

    public Usuario(
            String nombre,
            String correo,
            String password,
            int edad,
            double altura,
            double pesoActual
    ) {

        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
        this.edad = edad;
        this.altura = altura;
        this.pesoActual = pesoActual;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getPassword() {
        return password;
    }

    public int getEdad() {
        return edad;
    }

    public double getAltura() {
        return altura;
    }

    public double getPesoActual() {
        return pesoActual;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", password='" + password + '\'' +
                ", edad=" + edad +
                ", altura=" + altura +
                ", pesoActual=" + pesoActual +
                '}';
    }
}