package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.AuthorDTO;
import lk.ijse.entity.Author;

import java.util.ArrayList;

public interface AuthorBO extends SuperBO {
    boolean saveAuthor();
    boolean updateAuthor();
    boolean deleteAuthor();
    ArrayList<AuthorDTO> getAllAuthors();
}
