package com.registrodecrimes.dao;

import com.registrodecrimes.jdbc.DBConnection;
import com.registrodecrimes.model.Delegado;
import com.registrodecrimes.model.Ocorrencia;
import com.registrodecrimes.model.Reu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class OcorrenciaDAO {
    private final Connection connection;

    public OcorrenciaDAO() {
        this.connection = DBConnection.getConnection();
    }
    public Ocorrencia findById(Long id) throws SQLException {
        String sql = "SELECT * FROM ocorrencias WHERE id =?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setLong(1, id);
        ResultSet rs = stmt.executeQuery();
        if (!rs.next()) return null;
        Ocorrencia ocorrencia = new Ocorrencia(rs.getLong(1), new Reu(rs.getLong("reu_id")));
        String sql2 = "SELECT * FROM delegado_ocorrencia WHERE ocorrencia_id = ?";
        PreparedStatement stmt2 = connection.prepareStatement(sql2);
        ResultSet rs2 = stmt2.executeQuery();
        while (rs2.next()) {
            Delegado delegado = new Delegado(rs2.getLong("delegado_id"));
            ocorrencia.getDelegados().add(delegado);
        }
        return ocorrencia;
    }


    public void insert(Ocorrencia ocorrencia) throws SQLException {
        String sql = "INSERT INTO ocorrencias (id, reu_id) VALUES (?,?)";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setLong(1, ocorrencia.getId());
        stmt.setLong(2, ocorrencia.getReu().getId());
        ResultSet rs = stmt.executeQuery();
        if (rs.next()){
            Ocorrencia o = new Ocorrencia(rs.getLong("id"), null);
            for (Delegado delegado : ocorrencia.getDelegados()) {
                String sql2 = "INSERT INTO delegado_ocorrencia (delegado_id, ocorrencia_id) VALUES (?,?)";
                PreparedStatement stmt2 = connection.prepareStatement(sql2);
                stmt2.setLong(1, delegado.getId());
                stmt2.setLong(2, o.getId());
                stmt2.execute();
            }
        }else{
            throw new SQLException("Cannot insert");
        }
    }

    public void delete(Ocorrencia ocorrencia) throws SQLException {
        String sql = "DELETE FROM ocorrencias WHERE id =?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setLong(1, ocorrencia.getId());
        stmt.execute();
    }

    public void update(Ocorrencia ocorrencia) throws SQLException {
        String sql = "UPDATE ocorrencias SET reu_id =? WHERE id =?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setLong(1, ocorrencia.getReu().getId());
        stmt.setLong(2, ocorrencia.getId());
        stmt.execute();
    }
}
