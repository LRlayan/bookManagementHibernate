package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.AuthorDTO;

import java.util.ArrayList;

public interface ViewBooksDetailsBO extends SuperBO {

    boolean updateAuthor();
    boolean deleteAuthor();
    ArrayList<AuthorDTO> getAllAuthors();
}
