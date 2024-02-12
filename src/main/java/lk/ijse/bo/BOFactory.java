package lk.ijse.bo;

import lk.ijse.bo.custom.impl.AuthorBOImpl;
import lk.ijse.bo.custom.impl.BookBOImpl;
import lk.ijse.bo.custom.impl.DashboardImpl;
import lk.ijse.bo.custom.impl.HomeBOImpl;

public class BOFactory {
    private static BOFactory boFactory;
    private BOFactory(){}

    public static BOFactory getBOFactory(){
        return (boFactory == null) ? boFactory = new BOFactory() : boFactory;
    }

    public enum BOTypes{
        DASHBOARD,HOME,AUTHOR,BOOKS
    }

    public SuperBO boTypes(BOTypes boTypes){
        switch (boTypes){
            case BOOKS:
                return new BookBOImpl();
            case AUTHOR:
                return new AuthorBOImpl();
            case DASHBOARD:
                return new DashboardImpl();
            case HOME:
                return new HomeBOImpl();
            default:
                return null;
        }
    }
}
