package com.registrodetreinos.dao;

import com.registrodetreinos.jdbc.DBConnection;
import com.registrodetreinos.model.Atleta;
import com.registrodetreinos.model.Treino;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AtletaDAO {
    private Connection connection;

    public AtletaDAO() {
        this.connection = DBConnection.getConnection();
    }

    public Atleta findById(Long id) throws SQLException {
        String sql = "SELECT * FROM atletas WHERE id =?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setLong(1, id);
        ResultSet rs = stmt.executeQuery();
        Atleta a = null;
        if(rs.next()){
            a = new Atleta();
            a.setId(rs.getLong("id"));
            a.setNome(rs.getString("nome"));
            //treinos (não retorna outros atributos alem do id)
            String sql2 = "SELECT * FROM treino_atleta WHERE atleta_id =?";
            PreparedStatement stmt2 = connection.prepareStatement(sql2);
            stmt2.setLong(1, id);
            ResultSet rs2 = stmt2.executeQuery();
            List<Treino> treinos = new ArrayList<>();
            while(rs2.next()){
                Treino t = new Treino();
                t.setId(rs2.getLong("treino_id"));
                treinos.add(t);
            }
            a.setTreinos(treinos);
        }
        return a;
    }

    public void insert(Atleta a) throws SQLException {
        String sql = "INSERT INTO atletas (id, nome) VALUES (?,?)";
        PreparedStatement stmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        stmt.setLong(1, a.getId());
        stmt.setString(2, a.getNome());
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next() && a.getTreinos() != null) {
            Long id = rs.getLong(1);
            for (Treino treino : a.getTreinos()) {
                String sql2 = "INSERT INTO treino_atleta (atleta_id, treino_id) VALUES (?,?)";
                PreparedStatement stmt2 = connection.prepareStatement(sql2);
                stmt2.setLong(1, id);
                stmt2.setLong(2, treino.getId());
                stmt2.executeUpdate();
            }
        }
    }

    public void update(Atleta a) throws SQLException {
        String sql = "UPDATE atletas SET nome =? WHERE id =?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, a.getNome());
        stmt.setLong(2, a.getId());
        stmt.executeUpdate();
    }

    public void delete(Atleta a) throws SQLException {
        String sql = "DELETE FROM atletas WHERE id =?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setLong(1, a.getId());
        stmt.executeUpdate();
        String sql2 = "DELETE FROM treino_atleta WHERE atleta_id =?";
        PreparedStatement stmt2 = connection.prepareStatement(sql2);
        stmt2.setLong(1, a.getId());
        stmt2.executeUpdate();
    }
}
