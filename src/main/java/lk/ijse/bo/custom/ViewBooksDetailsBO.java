package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.AuthorDTO;
import lk.ijse.entity.Book;

import java.util.ArrayList;

public interface ViewBooksDetailsBO extends SuperBO {

    boolean updateAuthor();
    boolean deleteAuthor();
    boolean deleteBook(int id);
    ArrayList<AuthorDTO> getAllAuthors();
}
