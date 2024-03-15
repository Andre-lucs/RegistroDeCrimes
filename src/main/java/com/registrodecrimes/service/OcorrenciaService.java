package com.registrodecrimes.service;

import com.registrodecrimes.dao.OcorrenciaDAO;
import com.registrodecrimes.model.Ocorrencia;

import java.sql.SQLException;

public class OcorrenciaService implements Service<Ocorrencia>{
    private OcorrenciaDAO dao;

    public OcorrenciaService() {
        this.dao = new OcorrenciaDAO();
    }

    @Override
    public void insert(Ocorrencia object) {
        try{
            dao.insert(object);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Ocorrencia object) {
        try{
            dao.update(object);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Ocorrencia object) {
        try{
            dao.delete(object);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Ocorrencia findById(Long id) {
        try{
            return dao.findById(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Iterable<Ocorrencia> findAll() {
        return null;
    }
}
