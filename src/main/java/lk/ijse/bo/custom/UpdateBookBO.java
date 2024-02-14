package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.BookDTO;

import java.util.List;

public interface UpdateBookBO extends SuperBO {
    List<BookDTO> findAllBooks();
    boolean updateBook(BookDTO bookDTO);
}
