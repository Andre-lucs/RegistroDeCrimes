package com.registrodetreinos.dao;

import com.registrodetreinos.jdbc.DBConnection;
import com.registrodetreinos.model.Treino;
import com.registrodetreinos.model.Ginasio;
import com.registrodetreinos.model.Atleta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TreinoDAO {
    private final Connection connection;

    public TreinoDAO() {
        this.connection = DBConnection.getConnection();
    }

    public Treino findById(Long id) throws SQLException {
        String sql = "SELECT * FROM treinos WHERE id =?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setLong(1, id);
        ResultSet rs = stmt.executeQuery();
        if (!rs.next()) return null;
        Treino treino = new Treino(rs.getLong(1), rs.getString("data"), new Ginasio(rs.getLong("ginasio_id")));
        String sql2 = "SELECT * FROM treino_atleta WHERE treino_id = ?";
        PreparedStatement stmt2 = connection.prepareStatement(sql2);
        stmt2.setLong(1, id);
        ResultSet rs2 = stmt2.executeQuery();
        while (rs2.next()) {
            Atleta atleta = new Atleta(rs2.getLong("atleta_id"));
            treino.getAtletas().add(atleta);
        }
        return treino;
    }

    public void insert(Treino treino) throws SQLException {
        String sql = "INSERT INTO treinos (id, ginasio_id, data) VALUES (?,?,?)";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setLong(1, treino.getId());
        stmt.setLong(2, treino.getGinasio().getId());
        stmt.setString(3, treino.getData());
        stmt.execute();
        if(treino.getAtletas() != null)
	        for (Atleta atleta : treino.getAtletas()) {
	            String sql2 = "INSERT INTO treino_atleta (treino_id, atleta_id) VALUES (?,?)";
	            PreparedStatement stmt2 = connection.prepareStatement(sql2);
	            stmt2.setLong(1, treino.getId());
	            stmt2.setLong(2, atleta.getId());
	            stmt2.execute();
	        }
    }

    public void delete(Treino treino) throws SQLException {
        String sql = "DELETE FROM treinos WHERE id =?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setLong(1, treino.getId());
        stmt.execute();
    }

    public void update(Treino treino) throws SQLException {
        String sql = "UPDATE treinos SET data =? WHERE id =?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, treino.getData());
        stmt.execute();
    }
}
