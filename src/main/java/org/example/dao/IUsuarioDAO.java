package org.example.dao;

import org.example.model.Usuario;

public interface IUsuarioDAO {

    void guardarUsuario(Usuario usuario);

    void mostrarUsuarios();

    boolean login(String correo, String password);
}