package org.example;

import org.example.dao.EntrenamientoDAOImpl;
import org.example.dao.UsuarioDAOImpl;
import org.example.model.Entrenamiento;
import org.example.model.SesionUsuario;
import org.example.model.Usuario;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        UsuarioDAOImpl usuarioDAO =
                new UsuarioDAOImpl();

        EntrenamientoDAOImpl entrenamientoDAO =
                new EntrenamientoDAOImpl();

        int opcion;

        do {

            System.out.println("SISTEMA DEPORTIVO ");

            if (SesionUsuario.getNombre() != null) {

                System.out.println(
                        "Usuario activo: "
                                + SesionUsuario.getNombre()
                );

            } else {

                System.out.println(
                        "Usuario activo: Ninguno"
                );
            }

            System.out.println("1. Login");
            System.out.println("2. Registrar usuario");
            System.out.println("3. Ver usuarios");
            System.out.println("4. Registrar entrenamiento");
            System.out.println("5. Ver mis entrenamientos");
            System.out.println("6. Salir");

            System.out.print("Seleccione una opcion: ");

            opcion = Integer.parseInt(
                    scanner.nextLine()
            );

            switch (opcion) {

                case 1 -> {

                    System.out.print("Correo: ");
                    String correoLogin =
                            scanner.nextLine();

                    System.out.print("Password: ");
                    String passwordLogin =
                            scanner.nextLine();

                    boolean login =
                            usuarioDAO.login(
                                    correoLogin,
                                    passwordLogin
                            );

                    if (login) {

                        System.out.println(
                                "Login correcto. Bienvenido "
                                        + SesionUsuario.getNombre()
                        );

                    } else {

                        System.out.println(
                                "Correo o password incorrectos"
                        );
                    }
                }

                case 2 -> {

                    System.out.print("Nombre: ");
                    String nombre =
                            scanner.nextLine();

                    System.out.print("Correo: ");
                    String correoRegistro =
                            scanner.nextLine();

                    System.out.print("Password: ");
                    String passwordRegistro =
                            scanner.nextLine();

                    System.out.print("Edad: ");
                    int edad =
                            Integer.parseInt(
                                    scanner.nextLine()
                            );

                    System.out.print("Altura: ");
                    double altura =
                            Double.parseDouble(
                                    scanner.nextLine()
                            );

                    System.out.print("Peso actual: ");
                    double peso =
                            Double.parseDouble(
                                    scanner.nextLine()
                            );

                    Usuario usuario =
                            new Usuario(
                                    nombre,
                                    correoRegistro,
                                    passwordRegistro,
                                    edad,
                                    altura,
                                    peso
                            );

                    usuarioDAO.guardarUsuario(
                            usuario
                    );
                }

                case 3 -> {

                    usuarioDAO.mostrarUsuarios();
                }

                case 4 -> {

                    if (SesionUsuario.getUsuarioId() == 0) {

                        System.out.println(
                                "Debe iniciar sesion primero"
                        );

                    } else {

                        System.out.print(
                                "Tipo de entrenamiento: "
                        );

                        String tipo =
                                scanner.nextLine();

                        System.out.print(
                                "Duracion en minutos: "
                        );

                        int duracion =
                                Integer.parseInt(
                                        scanner.nextLine()
                                );

                        System.out.print("Fecha: ");

                        String fecha =
                                scanner.nextLine();

                        Entrenamiento entrenamiento =
                                new Entrenamiento(
                                        tipo,
                                        duracion,
                                        fecha,
                                        SesionUsuario.getUsuarioId()
                                );

                        entrenamientoDAO.guardar(
                                entrenamiento
                        );
                    }
                }

                case 5 -> {

                    if (SesionUsuario.getUsuarioId() == 0) {

                        System.out.println(
                                "Debe iniciar sesion primero"
                        );

                    } else {

                        entrenamientoDAO.mostrarPorUsuario(
                                SesionUsuario.getUsuarioId()
                        );
                    }
                }

                case 6 -> {

                    System.out.println(
                            "Saliendo del sistema..."
                    );
                }

                default -> {

                    System.out.println(
                            "Opcion invalida"
                    );
                }
            }

        } while (opcion != 6);

        scanner.close();
    }
}