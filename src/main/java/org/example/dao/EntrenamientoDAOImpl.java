package org.example.dao;

import org.example.model.Entrenamiento;
import org.example.util.ConexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EntrenamientoDAOImpl
        implements IEntrenamientoDAO {

    @Override
    public void guardar(Entrenamiento e) {

        String sql = """
                INSERT INTO entrenamientos
                (tipo, duracion, fecha, usuario_id)
                VALUES (?, ?, ?, ?)
                """;

        try {

            Connection con = ConexionBD.obtenerConexion();

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, e.getTipo());
            ps.setInt(2, e.getDuracion());
            ps.setString(3, e.getFecha());
            ps.setInt(4, e.getUsuarioId());

            ps.executeUpdate();

            System.out.println("Entrenamiento guardado");

        } catch (Exception ex) {

            ex.printStackTrace();
        }
    }

    @Override
    public void mostrarPorUsuario(int usuarioId) {

        String sql = """
                SELECT * FROM entrenamientos
                WHERE usuario_id=?
                """;

        try {

            Connection con = ConexionBD.obtenerConexion();

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, usuarioId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                System.out.println(
                        rs.getInt("id")
                                + " | "
                                + rs.getString("tipo")
                                + " | "
                                + rs.getInt("duracion")
                                + " min"
                );
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}