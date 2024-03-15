package com.registrodecrimes.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Ocorrencia {
    private Long id;
    private List<Delegado> delegados;
    private Reu reu;

    public Ocorrencia() {
    }

    public Ocorrencia(Long id) {
        this.id = id;
    }

    public Ocorrencia(Long id, Reu reu) {
        this.id = id;
        this.reu = reu;
        this.delegados = new ArrayList<>();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Delegado> getDelegados() {
        return delegados;
    }

    public void setDelegados(List<Delegado> delegados) {
        this.delegados = delegados;
    }

    public Reu getReu() {
        return reu;
    }

    public void setReu(Reu reu) {
        this.reu = reu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ocorrencia that = (Ocorrencia) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
