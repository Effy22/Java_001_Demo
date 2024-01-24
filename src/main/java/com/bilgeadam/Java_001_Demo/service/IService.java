package com.bilgeadam.Java_001_Demo.service;

import java.util.List;
import java.util.Optional;

public interface IService<T, ID> {

    T save(T t);
    T update (T t);
    Iterable<T> saveAll(Iterable<T> t);
    void delete(T t);
    void deleteById(ID id);
    Optional<T> findById(ID id);
    List<T> findAll();
}