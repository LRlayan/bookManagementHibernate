package lk.ijse.dao.custom.impl;

import lk.ijse.config.FactoryConfiguration;
import lk.ijse.dao.custom.AuthorDAO;
import lk.ijse.dao.custom.BookDAO;
import lk.ijse.entity.Author;
import lk.ijse.entity.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class AuthorDAOImpl implements AuthorDAO {
    @Override
    public boolean update() {
        return false;
    }

    @Override
    public boolean save(Author author) {

       Session session = FactoryConfiguration.getInstance().getSession();
       Transaction transaction = session.beginTransaction();

       BookDAOImpl.author = author;
       session.save(author);

       transaction.commit();
       session.close();
       return true;
    }

    @Override
    public boolean delete() {
        return false;
    }

    @Override
    public ArrayList<Author> findAll() {
        return null;
    }
}
