package lk.ijse.dao.custom;

import lk.ijse.dao.CrudDAO;
import lk.ijse.entity.Book;

import java.util.List;

public interface BookDAO extends CrudDAO<Book> {
    List<Book> findAllBookTitle();
    Object sumOfPrices();
    boolean updatePrice(int percentage);
    List<Book> question6(String country);
}
