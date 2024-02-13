package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.AuthorDTO;
import lk.ijse.dto.BookDTO;

public interface HomeBO extends SuperBO {
    boolean saveAuthor(AuthorDTO authorDTO);
    boolean saveBook(BookDTO bookDTO);
}
