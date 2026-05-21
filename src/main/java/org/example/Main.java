package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        EntrenamientoDAO entrenamientoDAO = new EntrenamientoDAO();

        int op;

        do {

            System.out.println("\n=== SISTEMA DEPORTIVO ===");
            System.out.println("Usuario: " + SesionUsuario.nombre);
            System.out.println("1. Login");
            System.out.println("2. Registrar usuario");
            System.out.println("3. Ver usuarios");
            System.out.println("4. Registrar entrenamiento");
            System.out.println("5. Ver mis entrenamientos");
            System.out.println("6. Salir");

            op = Integer.parseInt(sc.nextLine());

            switch (op) {

                case 1 -> {
                    System.out.print("Correo: ");
                    String c = sc.nextLine();

                    System.out.print("Password: ");
                    String p = sc.nextLine();

                    if (usuarioDAO.login(c, p)) {
                        System.out.println("Login OK " + SesionUsuario.nombre);
                    } else {
                        System.out.println("Error login");
                    }
                }

                case 2 -> {
                    System.out.print("Nombre: ");
                    String n = sc.nextLine();

                    System.out.print("Correo: ");
                    String c = sc.nextLine();

                    System.out.print("Pass: ");
                    String p = sc.nextLine();

                    System.out.print("Edad: ");
                    int e = Integer.parseInt(sc.nextLine());

                    System.out.print("Altura: ");
                    double a = Double.parseDouble(sc.nextLine());

                    System.out.print("Peso: ");
                    double pe = Double.parseDouble(sc.nextLine());

                    Usuario u = new Usuario(n, c, p, e, a, pe);

                    usuarioDAO.guardarUsuario(u);
                }

                case 3 -> usuarioDAO.mostrarUsuarios();

                case 4 -> {
                    System.out.print("Tipo: ");
                    String t = sc.nextLine();

                    System.out.print("Duración: ");
                    int d = Integer.parseInt(sc.nextLine());

                    System.out.print("Fecha: ");
                    String f = sc.nextLine();

                    Entrenamiento e = new Entrenamiento(t, d, f, SesionUsuario.usuarioId);

                    entrenamientoDAO.guardar(e);
                }

                case 5 -> entrenamientoDAO.mostrarPorUsuario(SesionUsuario.usuarioId);

            }

        } while (op != 6);
    }
}