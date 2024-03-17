package com.registrodetreinos.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Treino {
    private Long id;
    private String data;
    private List<Atleta> atletas;
    private Ginasio ginasio;

    public Treino() {
    }

    public Treino(Long id, String data) {
        this.id = id;
    }

    public Treino(Long id, String data, Ginasio ginasio) {
        this.id = id;
        this.ginasio = ginasio;
        this.atletas = new ArrayList<>();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    public List<Atleta> getAtletas() {
        return atletas;
    }

    public void setAtletas(List<Atleta> atletas) {
        this.atletas = atletas;
    }

    public Ginasio getGinasio() {
        return ginasio;
    }

    public void setGinasio(Ginasio ginasio) {
        this.ginasio = ginasio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Treino treino = (Treino) o;
        return Objects.equals(id, treino.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
