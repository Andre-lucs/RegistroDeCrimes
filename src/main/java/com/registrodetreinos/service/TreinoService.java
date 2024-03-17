package com.registrodetreinos.service;

import com.registrodetreinos.dao.TreinoDAO;
import com.registrodetreinos.model.Treino;

import java.sql.SQLException;

public class TreinoService implements Service<Treino>{
    private TreinoDAO dao;

    public TreinoService() {
        this.dao = new TreinoDAO();
    }

    @Override
    public void insert(Treino object) {
        try{
            dao.insert(object);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Treino object) {
        try{
            dao.update(object);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Treino object) {
        try{
            dao.delete(object);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Treino findById(Long id) {
        try{
            return dao.findById(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Iterable<Treino> findAll() {
        return null;
    }
}
