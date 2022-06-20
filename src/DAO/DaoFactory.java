package DAO;

import DAO.Custom.Impl.ReserveDaoImpl;
import DAO.Custom.Impl.RoomDaoImpl;
import DAO.Custom.Impl.StudentDaoImpl;
import DAO.Custom.Impl.UserDaoImpl;
import DAO.Custom.SuperDao;

public class DaoFactory {
    private static DaoFactory daoFactory;

    private DaoFactory() {
    }

   
    public static DaoFactory getDaoFactory() {
        if (daoFactory == null) {
            daoFactory = new DaoFactory();
        }
        return daoFactory;
    }


    public enum DAOTypes {
        RESERVE, STUDENT, ROOM, USER
    }


    public SuperDao getDAO(DAOTypes types) {
        switch (types) {
            case RESERVE:
                return new ReserveDaoImpl(); //SuperDAO superDAO=new CustomerDAOImpl();
            case STUDENT:
                return new StudentDaoImpl(); //SuperDAO superDAO=new ItemDAOImpl();
            case ROOM:
                return  new RoomDaoImpl(); //SuperDAO superDAO = new OrderDAOImpl();
            case USER:
                return new UserDaoImpl(); //SuperDAO superDAO = new OrderDetailsDAOImpl();
            default:
                return null;
        }
    }
}
