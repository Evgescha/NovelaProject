package com.novelasgame.novelas.service;

public interface CrudService<T> {

    boolean create(T entity);

    T read(long id);

    boolean update(T entity);

    boolean delete(long id);
}
