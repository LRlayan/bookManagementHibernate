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
        List<Author> authors = authorDAO.findAll();
        ArrayList<AuthorDTO> authorDTOS = new ArrayList<>();

        for (Author author : authors){
//            AuthorDTO authorDTO = new AuthorDTO(author.getId(),author.getName());
//            authorDTO.setBookList(author.getBookList());
//            authorDTOS.add(authorDTO);
            author.setBookList(author.getBookList());
            authorDTOS.add(new AuthorDTO(author.getId(),author.getName(),author.getCountry(),author.getBookList()));
        }
        return authorDTOS;
    }
}
