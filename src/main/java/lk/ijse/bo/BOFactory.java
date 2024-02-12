package lk.ijse.bo;

import lk.ijse.bo.custom.impl.ViewBooksDetailsBOImpl;
import lk.ijse.bo.custom.impl.DashboardImpl;
import lk.ijse.bo.custom.impl.HomeBOImpl;

public class BOFactory {
    private static BOFactory boFactory;
    private BOFactory(){}

    public static BOFactory getBOFactory(){
        return (boFactory == null) ? boFactory = new BOFactory() : boFactory;
    }

    public enum BOTypes{
        DASHBOARD,HOME,VIEW_BOOKS_DETAILS
    }

    public SuperBO boTypes(BOTypes boTypes){
        switch (boTypes){
            case VIEW_BOOKS_DETAILS:
                return new ViewBooksDetailsBOImpl();
            case DASHBOARD:
                return new DashboardImpl();
            case HOME:
                return new HomeBOImpl();
            default:
                return null;
        }
    }
}
