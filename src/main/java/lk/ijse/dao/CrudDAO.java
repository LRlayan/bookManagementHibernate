package lk.ijse.dao;

import lk.ijse.entity.Author;

import java.util.ArrayList;
import java.util.List;

public interface CrudDAO<T> extends SuperDAO{
    boolean update(T entity);
    boolean save(T entity);
    boolean delete(int id);
    List<T> findAll();
}
