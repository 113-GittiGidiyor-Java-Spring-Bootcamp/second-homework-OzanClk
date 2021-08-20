package dev.patika.homework02.dao;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BaseDAO<T> {

    T save(T object);

    T findById(int id);

    T update(T object);

    List<T> findByAll();

    void deleteById(int id);


}
