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
        ArrayList<BookDTO> bookDTOS = new ArrayList<>();

        for (Book book : bookDAO.findAll()){
            bookDTOS.add(new BookDTO(
                    book.getId(),
                    book.getTitle(),
                    book.getPublicationYear(),
                    book.getPrice(),
                    book.getAuthor().getId()
            ));
        }
        return bookDTOS;
    }

    @Override
    public Object sumOfPrices() {
        return bookDAO.sumOfPrices();
    }

    @Override
    public List<Object[]> allBooksByAuthor() {
       return authorDAO.allBooksByAuthor();
    }

    @Override
    public List<BookDTO> question6(String country) {
       List<Book> book = bookDAO.question6(country);
       List<BookDTO> bookDTOS = new ArrayList<>();

       for (Book books : book){
           bookDTOS.add(new BookDTO(books.getTitle()));
        }
       return bookDTOS;
    }

    @Override
    public List<BookDTO> books() {
        List<Book> books = bookDAO.findAllBookTitle();
        ArrayList<BookDTO> bookDTOS = new ArrayList<>();

        for (Book book : books){
            bookDTOS.add(new BookDTO(book.getTitle()));
        }
        return bookDTOS;
    }
}
