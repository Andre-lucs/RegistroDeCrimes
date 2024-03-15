package com.registrodecrimes.main;

import com.registrodecrimes.jdbc.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PrepareDB {
    public static void main(String[] args) {
        Connection c = DBConnection.getConnection();
        List<String> tabelas = new ArrayList<>();
        tabelas.add("CREATE TABLE reus (id SERIAL PRIMARY KEY, nome VARCHAR(255))");
        tabelas.add("CREATE TABLE ocorrencias (\n" +
                "    id SERIAL PRIMARY KEY,\n" +
                "    reu_id INTEGER,\n" +
                "    CONSTRAINT fk_ocorrencia_reu FOREIGN KEY (reu_id) REFERENCES reus (id)\n" +
                ")");
        tabelas.add("CREATE TABLE delegados (\n" +
                "    id SERIAL PRIMARY KEY,\n" +
                "    nome VARCHAR(255),\n" +
                "    CONSTRAINT pk_delegado_id_unique UNIQUE (id)\n" +
                ")");
        tabelas.add("CREATE TABLE delegado_ocorrencia (\n" +
                "    delegado_id INTEGER,\n" +
                "    ocorrencia_id INTEGER,\n" +
                "    CONSTRAINT pk_delegado_ocorrencia PRIMARY KEY (delegado_id, ocorrencia_id),\n" +
                "    CONSTRAINT fk_delegado_ocorrencia_delegado FOREIGN KEY (delegado_id) REFERENCES delegados (id),\n" +
                "    CONSTRAINT fk_delegado_ocorrencia_ocorrencia FOREIGN KEY (ocorrencia_id) REFERENCES ocorrencias (id)\n" +
                ")");
        for (String tabela : tabelas) {
            try{
                PreparedStatement stmt = c.prepareStatement(tabela);
                stmt.execute();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
