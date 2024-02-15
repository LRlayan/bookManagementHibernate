package lk.ijse.bo.custom.impl;

import lk.ijse.dao.custom.AuthorDAO;
import lk.ijse.dao.custom.BookDAO;
import lk.ijse.dao.custom.impl.AuthorDAOImpl;
import lk.ijse.dao.custom.impl.BookDAOImpl;
import lk.ijse.dto.AuthorDTO;
import lk.ijse.dto.BookDTO;
import lk.ijse.entity.Author;
import lk.ijse.entity.Book;

import java.util.ArrayList;
import java.util.List;

public class ViewBooksDetailsBOImpl implements lk.ijse.bo.custom.ViewBooksDetailsBO {

    BookDAO bookDAO = new BookDAOImpl();
    AuthorDAO authorDAO = new AuthorDAOImpl();

    @Override
    public boolean updateAuthor() {
        return false;
    }

    @Override
    public boolean deleteAuthor(int authorId) {
        return authorDAO.delete(authorId);
    }

    @Override
    public boolean deleteBook(int id) {
       return bookDAO.delete(id);
    }

    @Override
    public ArrayList<AuthorDTO> findAllAuthors() {
        ArrayList<AuthorDTO> authorDTOS = new ArrayList<AuthorDTO>();
        for (Author author :authorDAO.findAll()){
            authorDTOS.add(new AuthorDTO(
                    author.getId(),
                    author.getName(),
                    author.getCountry()
            ));
        }
        return authorDTOS;
    }

    @Override
    public List<BookDTO> findAllBook() {
        return null;
    }
}
