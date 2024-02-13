package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.AuthorDTO;
import lk.ijse.dto.BookDTO;

import java.util.ArrayList;
import java.util.List;

public interface HomeBO extends SuperBO {
    boolean saveAuthor(AuthorDTO authorDTO);
    boolean saveBook(BookDTO bookDTO);

    List<AuthorDTO> findAllAuthor();
    List<BookDTO> findAllBook();
    List<BookDTO> books();
}
