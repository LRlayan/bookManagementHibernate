package lk.ijse.dao.custom.impl;

import lk.ijse.config.FactoryConfiguration;
import lk.ijse.dao.custom.AuthorDAO;
import lk.ijse.dao.custom.BookDAO;
import lk.ijse.entity.Author;
import lk.ijse.entity.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class BookDAOImpl implements BookDAO {
    public static Author author;
    @Override
    public boolean update() {
        return false;
    }

    @Override
    public boolean save(Book book) {

        ArrayList<Book> bookList = new ArrayList<>();

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        book.setAuthor(author);
        author.setBookList(bookList);

        bookList.add(book);

        session.save(book);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete() {
        return false;
    }

    @Override
    public ArrayList<Book> findAll() {
        return null;
    }
}
