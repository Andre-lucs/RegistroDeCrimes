package com.registrodetreinos.service;

import com.registrodetreinos.dao.AtletaDAO;
import com.registrodetreinos.model.Atleta;

import java.sql.SQLException;

public class AtletaService implements Service<Atleta> {
    private AtletaDAO dao;

    public AtletaService() {
        this.dao = new AtletaDAO();
    }

    @Override
    public void insert(Atleta object) {
        try {
            dao.insert(object);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Atleta object) {
        try {
            dao.update(object);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Atleta object) {
        try {
            dao.delete(object);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Atleta findById(Long id) {
        try {
            return dao.findById(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Iterable<Atleta> findAll() {
        return null;
    }
}
