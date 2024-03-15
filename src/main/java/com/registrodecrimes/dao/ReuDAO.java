package com.registrodecrimes.dao;

import com.registrodecrimes.jdbc.DBConnection;
import com.registrodecrimes.model.Ocorrencia;
import com.registrodecrimes.model.Reu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ReuDAO {
    Connection connection;

    public ReuDAO(){
        this.connection = DBConnection.getConnection();
    }

    public Reu findById(Long id) throws SQLException {
        String sql = "SELECT * FROM reus WHERE id =?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setLong(1, id);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            Reu reu = new Reu(rs.getLong("id"), rs.getString("name"));
            return reu;
        }
        return null;
    }

    public Reu findByNome(String nome) throws SQLException{
        String sql = "SELECT * FROM reus WHERE name =?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, nome);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            Reu reu = new Reu(rs.getLong("id"), rs.getString("name"));
            return reu;
        }
        return null;
    }

    public void insert(Reu r) throws SQLException {
        String sql = "INSERT INTO reu (name) VALUES (?)";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, r.getNome());
        stmt.execute();
    }

    public void update(Reu r) throws SQLException {
        String sql = "UPDATE reu SET name =? WHERE id =?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, r.getNome());
        stmt.setLong(2, r.getId());
        stmt.execute();
    }

    public void delete(Reu r) throws SQLException {
        String sql = "DELETE FROM reus WHERE id=?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setLong(1, r.getId());
        stmt.execute();
    }

}
