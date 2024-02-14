package lk.ijse.bo.custom.impl;

import lk.ijse.dao.custom.BookDAO;
import lk.ijse.dao.custom.impl.BookDAOImpl;
import lk.ijse.dto.AuthorDTO;
import lk.ijse.entity.Book;

import java.util.ArrayList;

public class ViewBooksDetailsBOImpl implements lk.ijse.bo.custom.ViewBooksDetailsBO {

    BookDAO bookDAO = new BookDAOImpl();

    @Override
    public boolean updateAuthor() {
        return false;
    }

    @Override
    public boolean deleteAuthor() {
        return false;
    }

    @Override
    public boolean deleteBook(int id) {
       return bookDAO.delete(id);
    }

    @Override
    public ArrayList<AuthorDTO> getAllAuthors() {
        return null;
    }
}
