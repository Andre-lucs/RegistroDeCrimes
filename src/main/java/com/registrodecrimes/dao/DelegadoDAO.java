package com.registrodecrimes.dao;

import com.registrodecrimes.jdbc.DBConnection;
import com.registrodecrimes.model.Delegado;
import com.registrodecrimes.model.Ocorrencia;

import java.sql.*;
import java.sql.Connection;
import java.util.List;

public class DelegadoDAO {
    private Connection connection;

    public DelegadoDAO() {
        this.connection = DBConnection.getConnection();
    }

    public Delegado findById(Long id) throws SQLException {
        String sql = "SELECT * FROM delegados WHERE id =?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setLong(1, id);
        ResultSet rs = stmt.executeQuery();
        Delegado d = null;
        if(rs.next()){
            d = new Delegado();
            d.setId(rs.getLong("id"));
            d.setNome(rs.getString("nome"));
            //ocorrencias (não retorna outros atributos alem do id)
            String sql2 = "SELECT * FROM delegado_ocorrencia WHERE delegado_id =?";
            PreparedStatement stmt2 = connection.prepareStatement(sql2);
            stmt2.setLong(1, id);
            ResultSet rs2 = stmt2.executeQuery();
            List<Ocorrencia> ocorrencias = new java.util.ArrayList<Ocorrencia>();
            while(rs2.next()){
                Ocorrencia o = new Ocorrencia();
                o.setId(rs2.getLong("ocorrencia_id"));
                ocorrencias.add(o);
            }
            d.setOcorrencias(ocorrencias);
        }
        return d;
    }

    public void insert(Delegado d) throws SQLException{
        String sql = "INSERT INTO delegados (nome) VALUES (?)";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, d.getNome());
        ResultSet rs = stmt.executeQuery();
        if(rs.next()){
            Long id = rs.getLong("id");
            for (Ocorrencia ocorrencia : d.getOcorrencias()) {
                String sql2 = "INSERT INTO delegado_ocorrencia (delegado_id, ocorrencia_id) VALUES (?,?)";
                PreparedStatement stmt2 = connection.prepareStatement(sql2);
                stmt2.setLong(1, id);
                stmt2.setLong(2, ocorrencia.getId());
            }

        }
    }
    public void update(Delegado d) throws SQLException{
        String sql = "UPDATE delegados SET nome =? WHERE id =?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, d.getNome());
        stmt.setLong(2, d.getId());
        stmt.execute();
    }
    public void delete(Delegado d) throws SQLException{
        String sql = "DELETE FROM delegados WHERE id =?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setLong(1, d.getId());
        stmt.execute();
        String sql2 = "DELETE FROM delegado_ocorrencia WHERE delegado_id =?";
        PreparedStatement stmt2 = connection.prepareStatement(sql2);
        stmt2.execute();
    }
}