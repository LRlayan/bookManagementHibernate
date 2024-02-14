package lk.ijse.dao.custom;

import lk.ijse.dao.CrudDAO;
import lk.ijse.entity.Book;

import java.util.List;

public interface BookDAO extends CrudDAO<Book> {
    List<Book> findAllBookTitle();

    boolean updatePrice(int percentage);
}
