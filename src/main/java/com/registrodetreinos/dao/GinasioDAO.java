package com.registrodetreinos.dao;

import com.registrodetreinos.jdbc.DBConnection;
import com.registrodetreinos.model.Ginasio;
import com.registrodetreinos.model.Atleta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GinasioDAO {
    Connection connection;

    public GinasioDAO() {
        this.connection = DBConnection.getConnection();
    }

    public Ginasio findById(Long id) throws SQLException {
        String sql = "SELECT * FROM ginasios WHERE id =?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setLong(1, id);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            Ginasio ginasio = new Ginasio(rs.getLong("id"), rs.getString("nome"));
            return ginasio;
        }
        return null;
    }

    public Ginasio findByNome(String nome) throws SQLException {
        String sql = "SELECT * FROM ginasios WHERE nome =?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, nome);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            Ginasio ginasio = new Ginasio(rs.getLong("id"), rs.getString("nome"));
            return ginasio;
        }
        return null;
    }

    public void insert(Ginasio g) throws SQLException {
        String sql = "INSERT INTO ginasios (nome) VALUES (?)";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, g.getNome());
        stmt.execute();
    }

    public void update(Ginasio g) throws SQLException {
        String sql = "UPDATE ginasios SET nome =? WHERE id =?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, g.getNome());
        stmt.setLong(2, g.getId());
        stmt.execute();
    }

    public void delete(Ginasio g) throws SQLException {
        String sql = "DELETE FROM ginasios WHERE id=?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setLong(1, g.getId());
        stmt.execute();
    }
}
