package com.registrodetreinos.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.registrodetreinos.jdbc.DBConnection;

public class PrepareDB {
    public static void main(String[] args) {
        Connection c = DBConnection.getConnection();
        List<String> tabelas = new ArrayList<>();
        tabelas.add("CREATE TABLE ginasios (id INTEGER PRIMARY KEY, nome VARCHAR(255))");
        tabelas.add("CREATE TABLE atletas (id INTEGER PRIMARY KEY, nome VARCHAR(255))");
        tabelas.add("CREATE TABLE treinos (\n" +
                "    id INTEGER PRIMARY KEY,\n" +
                "    ginasio_id INTEGER,\n" +
                " 	 data varchar(100),\n" +	
                "    CONSTRAINT fk_treino_ginasio FOREIGN KEY (ginasio_id) REFERENCES ginasios (id)\n" +
                ")");
        tabelas.add("CREATE TABLE treino_atleta (\n" +
                "    treino_id INTEGER,\n" +
                "    atleta_id INTEGER,\n" +
                "    CONSTRAINT pk_treino_atleta PRIMARY KEY (treino_id, atleta_id),\n" +
                "    CONSTRAINT fk_treino_atleta_treino FOREIGN KEY (treino_id) REFERENCES treinos (id),\n" +
                "    CONSTRAINT fk_treino_atleta_atleta FOREIGN KEY (atleta_id) REFERENCES atletas (id)\n" +
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
