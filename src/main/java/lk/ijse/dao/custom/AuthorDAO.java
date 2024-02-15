package lk.ijse.dao.custom;

import lk.ijse.dao.CrudDAO;
import lk.ijse.entity.Author;

import java.util.List;

public interface AuthorDAO extends CrudDAO<Author> {
    List<Object[]> allBooksByAuthor();
}
