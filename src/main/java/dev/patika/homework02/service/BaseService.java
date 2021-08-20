package dev.patika.homework02.service;

import java.util.List;

public interface BaseService<T> {

    T save(T object);

    T findById(int id);

    T update(T object);

    List<T> findByAll();

    void deleteById(int id);


}
