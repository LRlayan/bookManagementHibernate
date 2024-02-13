package lk.ijse.dao;

import lk.ijse.entity.Author;

import java.util.ArrayList;

public interface CrudDAO<T> extends SuperDAO{
    boolean update();
    boolean save(T entity);
    boolean delete();
    ArrayList<T> findAll();
}
