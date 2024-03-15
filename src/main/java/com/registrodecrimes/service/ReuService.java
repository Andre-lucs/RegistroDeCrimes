package com.registrodecrimes.service;

import com.registrodecrimes.dao.ReuDAO;
import com.registrodecrimes.model.Reu;

import java.sql.SQLException;

public class ReuService implements Service<Reu> {
    private ReuDAO dao;

    public ReuService() {
        this.dao = new ReuDAO();
    }

    @Override
    public void insert(Reu object) {
        try {
            dao.insert(object);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Reu object) {
        try {
            dao.update(object);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Reu object) {
        try {
            dao.delete(object);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Reu findById(Long id) {
        try {
            return dao.findById(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Iterable<Reu> findAll() {
        return null;
    }
}
