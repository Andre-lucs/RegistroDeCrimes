package com.registrodecrimes.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Delegado {
    private Long id;
    private String nome;
    private List<Ocorrencia> ocorrencias;

    public Delegado() {
    }

    public Delegado(Long id) {
        this.id = id;
    }

    public Delegado(Long id, String nome) {
        this.id = id;
        this.ocorrencias = new ArrayList<>();
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

    public List<Ocorrencia> getOcorrencias() {
        return ocorrencias;
    }

    public void setOcorrencias(List<Ocorrencia> ocorrencias) {
        this.ocorrencias = ocorrencias;
    }

    public void addOcorrencia(Ocorrencia ocorrencia){
        this.ocorrencias.add(ocorrencia);
    }

    public void removeOcorrencia(Ocorrencia ocorrencia){
        this.ocorrencias.remove(ocorrencia);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Delegado delegado = (Delegado) o;
        return Objects.equals(id, delegado.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
