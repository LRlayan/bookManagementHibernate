package lk.ijse.dao;

import java.util.ArrayList;
import java.util.List;

public interface CrudDAO<T> extends SuperDAO{
    boolean update();
    boolean save();
    boolean delete();
    ArrayList<T> findAll();
}
