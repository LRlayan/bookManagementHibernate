package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.HomeBO;
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

public class HomeBOImpl implements HomeBO {

   AuthorDAOImpl authorDAO = new AuthorDAOImpl();
    BookDAO bookDAO = new BookDAOImpl();

    @Override
    public boolean saveAuthor(AuthorDTO authorDTO) {
        return authorDAO.save(new Author(authorDTO.getId(),authorDTO.getName(),authorDTO.getCountry()));
    }

    @Override
    public boolean saveBook(BookDTO bookDTO) {
        return bookDAO.save(new Book(bookDTO.getId(),bookDTO.getTitle(),bookDTO.getPublicationYear(),bookDTO.getPrice()));
    }

    @Override
    public List<AuthorDTO> findAllAuthor() {
        return null;
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
                   book.getAuthor()
           ));
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
