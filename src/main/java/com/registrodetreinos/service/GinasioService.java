package com.registrodetreinos.service;

import com.registrodetreinos.dao.GinasioDAO;
import com.registrodetreinos.model.Ginasio;

import java.sql.SQLException;

public class GinasioService implements Service<Ginasio> {
    private GinasioDAO dao;

    public GinasioService() {
        this.dao = new GinasioDAO();
    }

    @Override
    public void insert(Ginasio object) {
        try {
            dao.insert(object);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Ginasio object) {
        try {
            dao.update(object);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Ginasio object) {
        try {
            dao.delete(object);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Ginasio findById(Long id) {
        try {
            return dao.findById(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Iterable<Ginasio> findAll() {
        return null;
    }
}
