package com.registrodetreinos.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Atleta {
    private Long id;
    private String nome;
    private List<Treino> treinos;

    public Atleta() {
    }

    public Atleta(Long id) {
        this.id = id;
    }

    public Atleta(Long id, String nome) {
        this.id = id;
        this.treinos = new ArrayList<>();
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Treino> getTreinos() {
        return treinos;
    }

    public void setTreinos(List<Treino> treinos) {
        this.treinos = treinos;
    }

    public void addTreino(Treino treino){
        this.treinos.add(treino);
    }

    public void removeTreino(Treino treino){
        this.treinos.remove(treino);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Atleta atleta = (Atleta) o;
        return Objects.equals(id, atleta.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
