package org.example.dao;

import org.example.model.Entrenamiento;

public interface IEntrenamientoDAO {

    void guardar(Entrenamiento entrenamiento);

    void mostrarPorUsuario(int usuarioId);
}