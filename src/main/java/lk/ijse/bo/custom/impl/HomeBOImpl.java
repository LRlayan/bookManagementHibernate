package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.HomeBO;
import lk.ijse.dao.custom.AuthorDAO;
import lk.ijse.dao.custom.impl.AuthorDAOImpl;
import lk.ijse.dto.AuthorDTO;
import lk.ijse.dto.BookDTO;
import lk.ijse.entity.Author;

public class HomeBOImpl implements HomeBO {

    AuthorDAO authorDAO = new AuthorDAOImpl();

    @Override
    public boolean saveAuthor(AuthorDTO authorDTO) {
        return authorDAO.save(new Author(authorDTO.getName()));
    }

    @Override
    public boolean saveBook(BookDTO bookDTO) {
        return false;
    }
}
