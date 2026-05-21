package org.example;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBD {

    public static Connection conectar() {

        try {
            String url = "jdbc:mysql://localhost:3306/deportesdb";
            String user = "root";
            String pass = "root";

            return DriverManager.getConnection(url, user, pass);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}