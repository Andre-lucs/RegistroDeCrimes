package com.registrodecrimes.service;

public interface Service<T> {
    public void insert(T object);
    public void update(T object);
    public void delete(T object);
    public T findById(Long id);
    public Iterable<T> findAll();

}
