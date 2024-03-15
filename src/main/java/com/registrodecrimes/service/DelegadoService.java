package com.registrodecrimes.service;

import com.registrodecrimes.dao.DelegadoDAO;
import com.registrodecrimes.model.Delegado;

import java.sql.SQLException;

public class DelegadoService implements Service<Delegado> {
    private DelegadoDAO dao;

    public DelegadoService() {
        this.dao = new DelegadoDAO();
    }

    @Override
    public void insert(Delegado object) {
        try{
            dao.insert(object);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Delegado object) {
        try{
            dao.update(object);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Delegado object) {
        try{
            dao.update(object);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Delegado findById(Long id) {
        try{
            return dao.findById(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Iterable<Delegado> findAll() {
        return null;
    }
}
