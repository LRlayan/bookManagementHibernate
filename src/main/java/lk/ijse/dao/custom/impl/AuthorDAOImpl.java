package lk.ijse.dao.custom.impl;

import jakarta.persistence.Query;
import lk.ijse.config.FactoryConfiguration;
import lk.ijse.dao.custom.AuthorDAO;
import lk.ijse.entity.Author;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class AuthorDAOImpl implements AuthorDAO {

    private Session session;
    private Transaction transaction;
    @Override
    public boolean update() {
        return false;
    }

    @Override
    public boolean save(Author author) {
       session = FactoryConfiguration.getInstance().getSession();
       transaction = session.beginTransaction();

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
    public List<Author> findAll() {
        return null;
    }
}
