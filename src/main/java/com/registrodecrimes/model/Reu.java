package com.registrodecrimes.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Reu {
    private Long id;
    private String nome;

    public Reu() {
    }

    public Reu(Long id) {
        this.id = id;
    }

    public Reu(Long id, String nome) {
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
        Reu reu = (Reu) o;
        return Objects.equals(id, reu.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
