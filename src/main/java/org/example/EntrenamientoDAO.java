package org.example;

import java.sql.*;

public class EntrenamientoDAO {

    public void guardar(Entrenamiento e) {

        String sql = "INSERT INTO entrenamientos (tipo, duracion, fecha, usuario_id) VALUES (?, ?, ?, ?)";

        try {
            Connection con = ConexionBD.conectar();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, e.getTipo());
            ps.setInt(2, e.getDuracion());
            ps.setString(3, e.getFecha());
            ps.setInt(4, e.getUsuarioId());

            ps.executeUpdate();

            System.out.println("Entrenamiento guardado");

        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public void mostrarPorUsuario(int id) {

        String sql = "SELECT * FROM entrenamientos WHERE usuario_id=?";

        try {
            Connection con = ConexionBD.conectar();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getString("tipo") + " - " + rs.getInt("duracion"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}