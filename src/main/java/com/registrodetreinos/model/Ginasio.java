package com.registrodetreinos.model;

import java.util.Objects;

public class Ginasio {
    private Long id;
    private String nome;

    public Ginasio() {
    }

    public Ginasio(Long id) {
        this.id = id;
    }

    public Ginasio(Long id, String nome) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ginasio ginasio = (Ginasio) o;
        return Objects.equals(id, ginasio.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
