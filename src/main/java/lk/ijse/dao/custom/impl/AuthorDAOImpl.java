package lk.ijse.dao.custom.impl;

import lk.ijse.config.FactoryConfiguration;
import lk.ijse.dao.custom.AuthorDAO;
import lk.ijse.entity.Author;
import lk.ijse.entity.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AuthorDAOImpl implements AuthorDAO {

    private Session session;
    private Transaction transaction;
    @Override
    public boolean update(Author author) {
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
    public boolean delete(int id) {
       Session session1 = FactoryConfiguration.getInstance().getSession();
       Transaction transaction1 = session1.beginTransaction();

     Author author = session1.get(Author.class,id);
        for (Book book : author.getBookList()){
            session1.delete(book);
        }

        session1.delete(author);
        transaction1.commit();
        session1.close();

        return true;
    }

    @Override
    public List<Author> findAll() {
        Session session1 = FactoryConfiguration.getInstance().getSession();
        return session1.createQuery("FROM Author").list();
    }

    @Override
    public List<Object[]> allBooksByAuthor() {
        Session session2 = FactoryConfiguration.getInstance().getSession();
        return session2.createQuery("SELECT a.name , COUNT(b) FROM Author a LEFT JOIN a.bookList b GROUP BY a.id ").list();
    }
}
