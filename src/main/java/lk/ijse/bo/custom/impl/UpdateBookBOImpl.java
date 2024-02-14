package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.UpdateBookBO;
import lk.ijse.dao.custom.BookDAO;
import lk.ijse.dao.custom.impl.BookDAOImpl;
import lk.ijse.dto.BookDTO;
import lk.ijse.entity.Book;

import java.util.ArrayList;
import java.util.List;

public class UpdateBookBOImpl implements UpdateBookBO {

    BookDAO bookDAO = new BookDAOImpl();
    @Override
    public List<BookDTO> findAllBooks() {
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
    public boolean updateBook(BookDTO bookDTO) {
        return false;
    }

}
