package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.BookDTO;

import java.util.ArrayList;

public interface BookBO extends SuperBO {
    boolean saveBook();
    boolean updateBook();
    boolean deleteBook();
    ArrayList<BookDTO> getAllBooks();
}
