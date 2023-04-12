package com.example;

import java.util.List;

public interface Dao<T> {
    public int count();
    public T getOne(Long id);
    public List<T> getData();
    public boolean insert(T model);
    public boolean update(Long id, T model);
    public boolean delete(Long id);

}
