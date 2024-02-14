package lk.ijse.dao.custom.impl;

import jakarta.persistence.Query;
import lk.ijse.config.FactoryConfiguration;
import lk.ijse.dao.custom.AuthorDAO;
import lk.ijse.dao.custom.BookDAO;
import lk.ijse.entity.Author;
import lk.ijse.entity.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class BookDAOImpl implements BookDAO {
    public static Author author;

    @Override
    public boolean update() {
        return false;
    }

    @Override
    public boolean save(Book entity) {

        ArrayList<Book> bookList = new ArrayList<>();

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        entity.setAuthor(author);
        author.setBookList(bookList);

        bookList.add(entity);

        session.save(entity);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(int id) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("DELETE FROM Book b WHERE b.id = :id");
        query.setParameter("id" ,id);

        int row = query.executeUpdate();

        transaction.commit();
        session.close();

        return row > 0;
    }

    @Override
    public List<Book> findAll() {
        Session session2 = FactoryConfiguration.getInstance().getSession();
        return session2.createQuery("from Book").list();
    }

    @Override
    public List<Book> findAllBookTitle() {
        Session session1 = FactoryConfiguration.getInstance().getSession();
        return session1.createQuery("from Book where publicationYear > '2010'").list();
    }
}
