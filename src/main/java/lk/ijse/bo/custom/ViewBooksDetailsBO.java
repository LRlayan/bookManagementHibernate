package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.AuthorDTO;
import lk.ijse.dto.BookDTO;
import lk.ijse.entity.Book;

import java.util.ArrayList;
import java.util.List;

public interface ViewBooksDetailsBO extends SuperBO {

    boolean updateAuthor();
    boolean deleteAuthor(int authorId);
    boolean deleteBook(int id);
    ArrayList<AuthorDTO> findAllAuthors();
    List<BookDTO> findAllBook();
    Object sumOfPrices();
}
