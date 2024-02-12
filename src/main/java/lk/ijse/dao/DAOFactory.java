package lk.ijse.dao;

import lk.ijse.dao.custom.impl.AuthorDAOImpl;
import lk.ijse.dao.custom.impl.BookDAOImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory(){}

    private static DAOFactory getDaoFactory(){
        return (daoFactory == null)? daoFactory = new DAOFactory() : daoFactory;
    }

    public enum DAOTypes{
        AUTHOR,BOOKS
    }

    public SuperDAO DAOTypes(DAOTypes daoTypes){
        switch (daoTypes){
            case BOOKS:
                return new BookDAOImpl();
            case AUTHOR:
                return new AuthorDAOImpl();
            default:
                return null;
        }
    }
}
