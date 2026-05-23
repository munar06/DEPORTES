package org.example.dao;

import org.example.model.SesionUsuario;
import org.example.model.Usuario;
import org.example.util.ConexionBD;

import java.sql.*;

public class UsuarioDAO {

    public void guardarUsuario(Usuario u) {

        String sql = "INSERT INTO usuarios (nombre, correo, password, edad, altura, peso_actual) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            Connection con = ConexionBD.obtenerConexion();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, u.getNombre());
            ps.setString(2, u.getCorreo());
            ps.setString(3, u.getPassword());
            ps.setInt(4, u.getEdad());
            ps.setDouble(5, u.getAltura());
            ps.setDouble(6, u.getPesoActual());

            ps.executeUpdate();

            System.out.println("Usuario guardado");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mostrarUsuarios() {

        String sql = "SELECT * FROM usuarios";

        try {
            Connection con = ConexionBD.obtenerConexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getInt("id") + " " + rs.getString("nombre"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean login(String correo, String password) {

        String sql = "SELECT * FROM usuarios WHERE correo=? AND password=?";

        try {
            Connection con = ConexionBD.obtenerConexion();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, correo);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                SesionUsuario.setUsuarioId(rs.getInt("id"));
                SesionUsuario.setNombre(rs.getString("nombre"));
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}